package com.example.demo.controller;

import com.example.demo.util.FileHelper;
import com.example.demo.util.TemplateHelper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/database-table")
public class DatabaseTableController {

    @GetMapping("/")
    public String databaseTableHome() {
        return "database-table";
    }

    @PostMapping("/generate-db-table")
    public String generateDbTable(@RequestParam String tableName, @RequestParam String field1, @RequestParam String field2, @RequestParam String field3) throws IOException, TemplateException {

        List<String> tableFields = new ArrayList<>();
        tableFields.add(field1);
        tableFields.add(field2);
        tableFields.add(field3);

        Configuration configuration = TemplateHelper.prepareConfiguration();
        Template template = configuration.getTemplate("database_templates/EntityTemplate.ftlh");
        StringWriter stringWriter = new StringWriter();
        Map<String, Object> data = prepareTable(tableName);
        data.put("tableFields", tableFields);
        template.process(data, stringWriter);
        String templateContent = stringWriter.toString();

        FileHelper.writeToFile("generated_output/" + tableName + ".java", templateContent);

        return "database-table";
    }

    private Map<String, Object> prepareTable(String tableName) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("tableName", tableName);
        return data;
    }

}
