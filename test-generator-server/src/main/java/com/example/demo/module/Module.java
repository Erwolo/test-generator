package com.example.demo.module;

import com.example.demo.module.component.Component;

import java.util.List;

public abstract class Module {

    protected String moduleName;
    protected String moduleLocation;
    protected String modulePackage;
    protected List<Component> components;
    protected String templateLocation;

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleLocation() {
        return moduleLocation;
    }

    public void setModuleLocation(String moduleLocation) {
        this.moduleLocation = moduleLocation;
    }

    public String getModulePackage() {
        return modulePackage;
    }

    public void setModulePackage(String modulePackage) {
        this.modulePackage = modulePackage;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public String getTemplateLocation() {
        return templateLocation;
    }

    public void setTemplateLocation(String templateLocation) {
        this.templateLocation = templateLocation;
    }
}
