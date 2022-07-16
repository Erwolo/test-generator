package com.example.demo.module.rest.modules;

import com.example.demo.module.ModuleData;
import com.example.demo.module.rest.components.Field;

import java.util.List;

public class DtoModule extends ModuleData {

    public List<Field> fields;

    public DtoModule() {
        template = "rest/DtoTemplate.ftlh";
    }

    @Override
    public String toString() {
        return "DtoConfig{" +
                "fields=" + fields +
                ", template='" + template + '\'' +
                ", fileName='" + fileName + '\'' +
                ", filePackage='" + filePackage + '\'' +
                '}';

    }
}