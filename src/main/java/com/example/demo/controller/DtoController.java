package com.example.demo.controller;

import com.example.demo.template.loader.TemplateLoader;
import com.example.demo.template.model.ClassField;
import com.example.demo.template.model.FieldType;
import com.example.demo.template.model.TemplateModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/template/dto")
public class DtoController {


    @GetMapping
    public String generateDto(Model model) {
        List<ClassField> classFields = List.of(
                new ClassField(FieldType.STRING, "manufakturysta"),
                new ClassField(FieldType.STRING, "model"),
                new ClassField(FieldType.BOOLEAN, "czyFajne"),
                new ClassField(FieldType.INTEGER, "year"));

        TemplateModel templateModel = new TemplateModel("Car", classFields);
        TemplateLoader templateLoader = new TemplateLoader(templateModel, "DtoTemplate.ftlh");

        String loadedTemplate = templateLoader.load();

        model.addAttribute("loadedTemplate", loadedTemplate);

        return "main";
    }

}
