package com.example.demo.module.rest.modules;

import com.example.demo.module.ModuleData;

import java.util.List;

public class RestControllerModule extends ModuleData {
    public String endpoint;
    public String usedClass;
    public Boolean get;
    public Boolean insert;
    public Boolean delete;
    public Boolean update;
    public List<String> findBy;

    public RestControllerModule() {
        templateLocation = "rest/RestTemplate.ftlh";
    }

    @Override
    public String toString() {
        return "RestControllerConfig{" +
                "endpoint='" + endpoint + '\'' +
                ", usedClass='" + usedClass + '\'' +
                ", get=" + get +
                ", insert=" + insert +
                ", delete=" + delete +
                ", update=" + update +
                ", findBy=" + findBy +
                ", template='" + templateLocation + '\'' +
                ", fileName='" + fileName + '\'' +
                ", filePackage='" + filePackage + '\'' +
                '}';
    }
}