package com.example.demo.template.model;

import org.springframework.util.StringUtils;

public class ClassField {
    private String type;
    private String name;
    private String upperCaseName;

    public ClassField() {
    }

    public ClassField(String type, String name) {
        this.type = type;
        this.name = name;
        this.upperCaseName = StringUtils.capitalize(name);
    }

    public ClassField(FieldType type, String name) {
        this.type = type.getType();
        this.name = name;
        this.upperCaseName = StringUtils.capitalize(name);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.upperCaseName = StringUtils.capitalize(name);
    }

    public String getUpperCaseName() {
        return upperCaseName;
    }

}

