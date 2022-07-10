package com.example.demo.module;

import com.example.demo.module.component.Component;

import java.util.List;

public abstract class ModuleEntity {

    protected String moduleName;
    protected String moduleLocation;
    protected String modulePackage;
    protected List<Component> components;
    protected String templatePath;

}
