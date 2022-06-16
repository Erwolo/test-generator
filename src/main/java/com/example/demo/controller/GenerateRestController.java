package com.example.demo.controller;

import com.example.demo.template.config.rest.RestAppConfig;
import com.example.demo.template.generator.TemplateGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tempalate/rest")
public class GenerateRestController {
    @Autowired
    private TemplateGenerator templateGenerator;

    @PostMapping
    public String generateRestApp(@RequestBody RestAppConfig config) {
        return templateGenerator.generate(config);
    }

    @GetMapping
    public RestAppConfig getJson() {
        return new RestAppConfig();
    }
}
