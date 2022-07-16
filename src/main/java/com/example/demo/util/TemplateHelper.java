package com.example.demo.util;

import com.example.demo.generator.exception.TemplateLoadException;
import com.example.demo.generator.exception.TemplatesFolderNotFoundRuntimeException;
import com.example.demo.module.Module;
import com.example.demo.module.ModuleData;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

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

    public Template getTemplate(ModuleData module) {
        Configuration configuration = TemplateHelper.prepareConfiguration();
        return getTemplate(module, configuration);
    }

    public Template getTemplate(Module module) {
        Configuration configuration = TemplateHelper.prepareConfiguration();
        return getTemplate(module, configuration);
    }

    public Template getTemplate(ModuleData module, Configuration configuration) {
        try {
            return configuration.getTemplate(module.getTemplateLocation());
        } catch (IOException e) {
            throw new TemplateLoadException(e);
        }
    }

    public Template getTemplate(Module module, Configuration configuration) {
        try {
            return configuration.getTemplate(module.getTemplateLocation());
        } catch (IOException e) {
            throw new TemplateLoadException(e);
        }
    }

    public String getTemplateAsString(ModuleData config) {
        return processTemplate(config, getTemplate(config));
    }

    public String getTemplateAsString(Module config) {
        return processTemplate(config, getTemplate(config));
    }

    private String processTemplate(ModuleData config, Template template) {
        StringWriter stringWriter = new StringWriter();

        try {
            Map dataModel = convertToMap(config);
            template.process(dataModel, stringWriter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stringWriter.toString();
    }

    private String processTemplate(Module config, Template template) {
        StringWriter stringWriter = new StringWriter();

        try {
            Map dataModel = convertToMap(config);
            template.process(dataModel, stringWriter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stringWriter.toString();
    }

    private static void setDirectory(Configuration configuration) {
        try {
            configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        } catch (IOException e) {
            throw new TemplatesFolderNotFoundRuntimeException(e);
        }
    }

    private Map convertToMap(ModuleData config) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(config, Map.class);
    }

    private Map convertToMap(Module config) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(config, Map.class);
    }
}