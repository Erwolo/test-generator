package com.example.demo.template.model;

import java.util.List;
import java.util.Map;

public class TemplateModel {
    private String name;
    private List<ClassField> fields;
    private Map<String, Object> map;

    public TemplateModel() {
    }

    public TemplateModel(String name, List<ClassField> fields) {
        this.name = name;
        this.fields = fields;
        initMap();
    }

    public void initMap() {
        this.map = Map.of(
//                "group", "",
//                "artifact", "",
//                "package", "",
                "name", name,
                "fields", fields);
    }

    public Map getMap() {
        return map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ClassField> getFields() {
        return fields;
    }

    public void setFields(List<ClassField> fields) {
        this.fields = fields;
    }
}