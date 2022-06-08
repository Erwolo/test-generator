package com.example.demo.template.generator.rest.controller;

import com.example.demo.template.generator.TemplateConfig;

import java.util.List;

public class RestControllerTemplateConfig extends TemplateConfig {
    public String endpoint;
    public String usedClass;
    public Boolean get;
    public Boolean insert;
    public Boolean delete;
    public Boolean update;
    public List<String> findBy;
}
