package com.example.demo.template.generator.rest.dto;

import com.example.demo.template.generator.TemplateConfig;
import com.example.demo.template.generator.TemplateGenerator;
import com.example.demo.util.FileHelper;
import com.example.demo.util.TemplateHelper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;

public class DtoTemplateGenerator implements TemplateGenerator {

    private TemplateConfig config;

    public DtoTemplateGenerator(TemplateConfig config) {
        this.config = config;
    }

    public void generate() throws IOException, TemplateException {
//        Map<String, Object> data = Map.of(
//                "templateLocation", config.templateLocation,
//                "fileName", config.fileName,
//                "filePackage", config.filePackage,
//                "fields", config.fields
//        );


        config.config.put("fileName", config.fileName);

        Configuration configuration = TemplateHelper.prepareConfiguration();
        Template template = configuration.getTemplate(config.templateLocation);
        StringWriter stringWriter = new StringWriter();
        template.process(config.config, stringWriter);
        String templateContent = stringWriter.toString();

        FileHelper.writeToFile(String.format("generated_output/%s/%s.java", config.filePackage.replaceAll("\\.", "/"), config.fileName), templateContent);
    }

}
