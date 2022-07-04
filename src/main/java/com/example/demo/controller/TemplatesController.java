package com.example.demo.controller;

import com.example.demo.template.config.AppConfig;
import com.example.demo.template.config.rest.RestAppConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tempalates")
public class TemplatesController {

    @GetMapping
    public List<AppConfig> getTemplates() {
        return List.of(new RestAppConfig(), new RestAppConfig(), new RestAppConfig());
    }
}
