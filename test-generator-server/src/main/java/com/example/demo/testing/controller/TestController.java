package com.example.demo.testing.controller;

import com.example.demo.module.database.modules.DatabaseTableModule;
import com.example.demo.generator.TemplateGenerator;
import com.example.demo.testing.component.TestComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testing")
public class TestController {

    @Autowired
    private TemplateGenerator templateGenerator;

    @PostMapping("/table")
    public String testTable(@RequestBody DatabaseTableModule databaseTable) {
        return templateGenerator.generate(databaseTable);
    }

    @PostMapping("/fields")
    public String testFields(@RequestBody TestComponent testComponent) {
        return testComponent.toString();
    }

}
