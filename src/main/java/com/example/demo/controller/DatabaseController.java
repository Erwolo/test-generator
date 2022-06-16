package com.example.demo.controller;

import com.example.demo.util.FileHelper;
import com.example.demo.util.TemplateHelper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/database")
public class DatabaseController {
    @Value("${spring.datasource.password}") String password;


    @GetMapping("/")
    public String databaseHome() {
        return "database";
    }

    @GetMapping("/test")
    public String testProperties() {
        System.out.println(password);
        return "database";
    }

}
