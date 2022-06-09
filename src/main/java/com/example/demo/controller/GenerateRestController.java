package com.example.demo.controller;

import com.example.demo.template.config.rest.RestAppConfig;
import com.example.demo.template.generator.TemplateGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tempalate/rest")
public class GenerateRestController {

    @Autowired
    private TemplateGenerator templateGenerator;

    @GetMapping()
    public void generateRestApp(@RequestBody RestAppConfig config) {

        config.templates.forEach(template -> {
            templateGenerator.generate(template);
        });

    }

//    private TemplateGenerator getTemplateGenerator(TemplateConfig template) throws Exception {
//        return (TemplateGenerator) Class.forName(template.generatorClass).getConstructor(TemplateConfig.class).newInstance(template);
//    }

//    private TemplateGenerator getTemplateGenerator(TemplateConfig template) throws Exception {
//        Class<?> templateSpecificConfig = Class.forName(template.generatorClass).getField("config").getType();
//        return (TemplateGenerator) Class.forName(template.generatorClass).getConstructor(TemplateConfig.class).newInstance(template);
//    }


}
