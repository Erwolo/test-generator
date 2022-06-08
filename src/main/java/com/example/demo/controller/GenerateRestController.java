package com.example.demo.controller;

import com.example.demo.template.generator.AppConfig;
import com.example.demo.template.generator.TemplateConfig;
import com.example.demo.template.generator.TemplateGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tempalate/rest")
public class GenerateRestController {

    @GetMapping()
    public void generateRestApp(@RequestBody AppConfig config) {

        config.templates.forEach(template -> {
            try {
                getTemplateGenerator(template).generate();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

    }

    private TemplateGenerator getTemplateGenerator(TemplateConfig template) throws Exception {
        return (TemplateGenerator) Class.forName(template.generatorClass).getConstructor(TemplateConfig.class).newInstance(template);
    }

//    private TemplateGenerator getTemplateGenerator(TemplateConfig template) throws Exception {
//        Class<?> templateSpecificConfig = Class.forName(template.generatorClass).getField("config").getType();
//        return (TemplateGenerator) Class.forName(template.generatorClass).getConstructor(TemplateConfig.class).newInstance(template);
//    }


}
