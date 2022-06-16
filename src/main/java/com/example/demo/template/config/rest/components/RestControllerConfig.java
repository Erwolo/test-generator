package com.example.demo.template.config.rest.components;

import com.example.demo.template.config.TemplateConfig;

import java.util.List;

public class RestControllerConfig extends TemplateConfig {
    public String endpoint;
    public String usedClass;
    public Boolean get;
    public Boolean insert;
    public Boolean delete;
    public Boolean update;
    public List<String> findBy;

    public RestControllerConfig() {
    }
}