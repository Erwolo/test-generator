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
    }
}