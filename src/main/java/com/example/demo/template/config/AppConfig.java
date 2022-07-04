package com.example.demo.template.config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AppConfig {

    public String name;

    public List<TemplateConfig> getTemplates() {
        return Arrays.stream(this.getClass().getFields())
                .filter(field -> field.getType().getSuperclass().equals(TemplateConfig.class))
                .map(field -> {
                    try {
                        return (TemplateConfig) field.get(this);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toList());
    }
}
