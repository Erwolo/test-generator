package com.example.demo.template.generator;

import com.example.demo.template.config.TemplateConfig;
import com.example.demo.util.FileHelper;
import com.example.demo.util.TemplateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TemplateGenerator {

    @Autowired
    private TemplateHelper templateHelper;

    public void generate(TemplateConfig config) {

        config.config.put("fileName", config.fileName);

        String templateContent = templateHelper.getTemplateAsString(config);
        String path = String.format("generated_output/%s/%s.java", config.filePackage.replaceAll("\\.", "/"), config.fileName);
        FileHelper.writeToFile(path, templateContent);
    }


}
