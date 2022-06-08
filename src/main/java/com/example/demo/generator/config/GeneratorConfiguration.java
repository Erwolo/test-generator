package com.example.demo.generator.config;

import com.example.demo.generator.exception.TemplatesFolderNotFoundRuntimeException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;

public class GeneratorConfiguration {
    private static final String ENCODING = "UTF-8";
    private static final String RESOURCES_TEMPLATES_PATH = "src/main/resources/templates";
    private final Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);

    public GeneratorConfiguration() {
        configuration.setDefaultEncoding(ENCODING);
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        try {
            configuration.setDirectoryForTemplateLoading(new File(RESOURCES_TEMPLATES_PATH));
        } catch (IOException e) {
            new TemplatesFolderNotFoundRuntimeException(e);
        }
    }

    public Template getTemplate(String templateName) {
        try {
            return configuration.getTemplate(templateName);
        } catch (IOException e) {
            return Template.getPlainTextTemplate(templateName, "", configuration);
        }
    }
}

