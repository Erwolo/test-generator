package com.example.demo.module.rest;

import com.example.demo.module.ModuleData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AppConfig {
    public List<ModuleData> getTemplates() {
        return Arrays.stream(this.getClass().getFields()).map(field -> {
            try {
                return (ModuleData) field.get(this);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
    }
}
