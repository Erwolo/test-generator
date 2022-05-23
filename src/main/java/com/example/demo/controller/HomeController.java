package com.example.demo.controller;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HomeController {

    List<Integer> ids = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {


        return "index";
    }



//    @PostMapping("/generate")
//    public String generate() throws IOException, TemplateException {
//
//        Map<String, Object> model = new HashMap<String, Object>();
//        model.put("tableName", "moja_tabela");
//
//        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
//        Template tmp = cfg.getTemplate("EntityTemplate.ftlh");
//
//        tmp.process(model, new OutputStreamWriter(System.out));
//        System.out.println(tmp);
//
//        return "index";
//    }

    @PostMapping("/generate")
    public String generate(@RequestParam String tableName, @RequestParam String field1, @RequestParam String field2, @RequestParam String field3) throws IOException, TemplateException {

        List<String> tableFields = new ArrayList<>();
        tableFields.add(field1);
        tableFields.add(field2);
        tableFields.add(field3);

        Configuration configuration = prepareConfiguration();
        Template template = configuration.getTemplate("EntityTemplate.ftlh");
        StringWriter stringWriter = new StringWriter();
        Map<String, Object> data = prepareTable(tableName);
        data.put("tableFields", tableFields);
        template.process(data, stringWriter);
        String templateContent = stringWriter.toString();




        generateJavaClass("generated_output/" + tableName + ".java", templateContent);

        return "index";
    }

    private void generateJavaClass(String className, String content) throws IOException {
        FileWriter fileWriter = new FileWriter(className);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(content);
        printWriter.close();
    }


    private Configuration prepareConfiguration() throws IOException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        return configuration;
    }

    private Map<String, Object> prepareTable(String tableName) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("tableName", tableName);
        return data;
    }

}
