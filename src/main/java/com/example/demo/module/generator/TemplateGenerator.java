package com.example.demo.module.generator;

import com.example.demo.module.AppConfig;
import com.example.demo.module.ModuleData;
import com.example.demo.util.FileHelper;
import com.example.demo.util.TemplateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TemplateGenerator {

    @Autowired
    private TemplateHelper templateHelper;

    public String generate(ModuleData module) {
        String folderName = UUID.randomUUID().toString();

        String templateContent = templateHelper.getTemplateAsString(module);
        FileHelper.writeToFile(getPath(folderName, module), templateContent);

        return folderName;
    }

    public String generate(AppConfig config) {
        String folderName = UUID.randomUUID().toString();

        config.getTemplates().forEach(template -> {
            String templateContent = templateHelper.getTemplateAsString(template);
            FileHelper.writeToFile(getPath(folderName, template), templateContent);
        });

        return folderName;
    }


    private String getPath(String folderName, ModuleData template) {
        return String.format("generated_output/%s/%s/%s", folderName, template.filePackage.replaceAll("\\.", "/"), template.fileName);
    }


}
