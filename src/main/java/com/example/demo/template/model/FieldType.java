package com.example.demo.template.model;

public enum FieldType {
    STRING("String"),
    INTEGER("Integer"),
    BOOLEAN("Boolean");

    private String type;

    FieldType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
