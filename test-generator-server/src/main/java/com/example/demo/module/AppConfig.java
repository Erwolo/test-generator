package com.example.demo.module;

import com.example.demo.module.ModuleData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AppConfig {
    public String name;

    public List<ModuleData> getTemplates() {
        return Arrays.stream(this.getClass().getFields())
                .filter(field -> field.getType().getSuperclass().equals(ModuleData.class))
                .map(field -> {
                    try {
                        return (ModuleData) field.get(this);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toList());
    }

    public List<Module> getModules() {
        return Arrays.stream(this.getClass().getFields())
                .filter(field -> field.getType().getSuperclass().equals(Module.class))
                .map(field -> {
                    try {
                        return (Module) field.get(this);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toList());
    }
}
