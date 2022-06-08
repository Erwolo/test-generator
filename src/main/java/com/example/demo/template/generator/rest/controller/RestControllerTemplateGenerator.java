package com.example.demo.template.generator.rest.controller;

import com.example.demo.template.generator.TemplateConfig;
import com.example.demo.template.generator.TemplateGenerator;
import com.example.demo.util.FileHelper;
import com.example.demo.util.TemplateHelper;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;

public class RestControllerTemplateGenerator implements TemplateGenerator {
    private final TemplateConfig config;

    public RestControllerTemplateGenerator(TemplateConfig config) {
        this.config = config;
    }

    public void generate() throws Exception {

        config.config.put("fileName", config.fileName);

        Configuration configuration = TemplateHelper.prepareConfiguration();
        Template template = configuration.getTemplate(config.templateLocation);

        StringWriter stringWriter = new StringWriter();
        template.process(config.config, stringWriter);

        String templateContent = stringWriter.toString();
        FileHelper.writeToFile(String.format("generated_output/%s/%s.java", config.filePackage.replaceAll("\\.", "/"), config.fileName), templateContent);
    }

}
