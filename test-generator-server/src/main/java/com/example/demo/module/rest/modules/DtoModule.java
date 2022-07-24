package com.example.demo.module.rest.modules;

import com.example.demo.module.Module;
import com.example.demo.module.rest.components.Field;

import java.util.List;

public class DtoModule extends Module {

    public List<Field> fields;

    public DtoModule() {
        templateLocation = "rest/DtoTemplate.ftlh";
    }

    @Override
    public String toString() {
        return "DtoModule{" +
                "fields=" + fields +
                ", moduleName='" + moduleName + '\'' +
                ", moduleLocation='" + moduleLocation + '\'' +
                ", modulePackage='" + modulePackage + '\'' +
                ", components=" + components +
                ", templateLocation='" + templateLocation + '\'' +
                '}';
    }
}