package com.example.demo.util;

import com.example.demo.generator.exception.TemplateLoadException;
import com.example.demo.generator.exception.TemplatesFolderNotFoundRuntimeException;
import com.example.demo.template.config.TemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

@Component
public class TemplateHelper {

    public static Configuration prepareConfiguration() {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);
        setDirectory(configuration);
        return configuration;
    }

    private static void setDirectory(Configuration configuration) {
        try {
            configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        } catch (IOException e) {
            throw new TemplatesFolderNotFoundRuntimeException(e);
        }
    }

    public Template getTemplate(TemplateConfig config) {
        Configuration configuration = TemplateHelper.prepareConfiguration();
        return getTemplate(config, configuration);
    }

    public String getTemplateAsString(TemplateConfig config) {
        return processTemplate(config, getTemplate(config));
    }

    private String processTemplate(TemplateConfig config, Template template) {
        StringWriter stringWriter = new StringWriter();

        try {
            template.process(config.config, stringWriter);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return stringWriter.toString();
    }

    private Template getTemplate(TemplateConfig config, Configuration configuration) {
        try {
            return configuration.getTemplate(config.templateLocation);
        } catch (IOException e) {
            throw new TemplateLoadException(e);
        }
    }

}
