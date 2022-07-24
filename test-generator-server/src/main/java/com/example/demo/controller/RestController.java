package com.example.demo.controller;

import com.example.demo.module.rest.RestAppConfig;
import com.example.demo.generator.TemplateGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
    @Autowired
    private TemplateGenerator templateGenerator;

    @PostMapping
    public String generateRestApp(@RequestBody RestAppConfig config) {
        return templateGenerator.generate(config);
    }

    @PostMapping("/generate-modules")
    public String generateRestModules(@RequestBody RestAppConfig config) {
        return templateGenerator.generateModules(config);
    }

    @GetMapping
    public RestAppConfig getJson() {
        return new RestAppConfig();
    }
}
