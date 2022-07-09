package com.example.demo.template.config.rest;

import com.example.demo.template.config.AppConfig;
import com.example.demo.template.config.rest.components.DtoConfig;
import com.example.demo.template.config.rest.components.RestControllerConfig;

public class RestAppConfig extends AppConfig {

    public RestControllerConfig restControllerConfig;
    public DtoConfig dtoConfig;

    public RestAppConfig() {
        this.name = "Rest Application";
    }

    @Override
    public String toString() {
        return "RestAppConfig{" +
                "restControllerConfig=" + restControllerConfig +
                ", dtoConfig=" + dtoConfig +
                ", name='" + name + '\'' +
                '}';
    }
}