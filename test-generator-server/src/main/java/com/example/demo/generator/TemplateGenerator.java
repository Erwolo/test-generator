package com.example.demo.generator;

import com.example.demo.module.AppConfig;
import com.example.demo.module.Module;
import com.example.demo.module.ModuleData;
import com.example.demo.util.FileHelper;
import com.example.demo.util.TemplateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
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

    public String generate(Module module) {
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

    public String generateModules(AppConfig config) {
        String folderName = UUID.randomUUID().toString();

        config.getModules().forEach(template -> {
            String templateContent = templateHelper.getTemplateAsString(template);
            FileHelper.writeToFile(getPath(folderName, template), templateContent);
        });

        return folderName;
    }

    public String generate(List<AppConfig> config) {
        String folderName = UUID.randomUUID().toString();

        config.forEach(app -> app.getTemplates().forEach(template -> {
            String templateContent = templateHelper.getTemplateAsString(template);
            FileHelper.writeToFile(getPath(folderName, template), templateContent);
        }));

        return folderName;
    }

    private String getPath(String folderName, ModuleData template) {
        return String.format("generated_output/%s/%s/%s", folderName, template.filePackage.replaceAll("\\.", "/"), template.fileName + ".java");
    }

    private String getPath(String folderName, Module template) {
        return String.format("generated_output/%s/%s/%s", folderName, template.getModulePackage().replaceAll("\\.", "/"), template.getModuleName() + ".java");
    }
}
