package com.example.demo.template.config.rest.components;

import com.example.demo.template.config.TemplateConfig;

import java.util.List;

public class DtoConfig extends TemplateConfig {

    public List<Field> fields;

    public DtoConfig() {
        template = "rest/DtoTemplate.ftlh";
    }

    @Override
    public String toString() {
        return "DtoConfig{" +
                "fields=" + fields +
                ", template='" + template + '\'' +
                ", fileName='" + fileName + '\'' +
                ", filePackage='" + filePackage + '\'' +
                '}';

    }
}