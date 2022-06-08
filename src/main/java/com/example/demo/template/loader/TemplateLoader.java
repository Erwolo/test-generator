package com.example.demo.template.loader;

import com.example.demo.generator.config.GeneratorConfiguration;
import com.example.demo.generator.exception.TemplateLoadException;
import com.example.demo.template.model.TemplateModel;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TemplateLoader {
    private final GeneratorConfiguration generatorConfiguration = new GeneratorConfiguration();
    private final TemplateModel model;
    private final String templateName;

    public TemplateLoader(TemplateModel templateModel, String templateName) {
        this.model = templateModel;
        this.templateName = templateName;
    }

    public String load() {
        Template template = generatorConfiguration.getTemplate(templateName);

        try {
            return FreeMarkerTemplateUtils.processTemplateIntoString(template, model.getMap());
        } catch (IOException | TemplateException e) {
            throw new TemplateLoadException(e);
        }
    }

    public String load(String templateName) {
        Template template = generatorConfiguration.getTemplate(templateName);

        try {
            return FreeMarkerTemplateUtils.processTemplateIntoString(template, model.getMap());
        } catch (IOException | TemplateException e) {
            throw new TemplateLoadException(e);
        }
    }

    public void generateJavaClass(String generatedClassName) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("generated_output/" + generatedClassName + ".java");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(load());
        printWriter.close();
    }

}
