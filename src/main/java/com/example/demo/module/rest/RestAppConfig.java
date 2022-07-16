package com.example.demo.module.rest;

import com.example.demo.module.AppConfig;
import com.example.demo.module.rest.modules.DtoModule;
import com.example.demo.module.rest.modules.RestControllerModule;

public class RestAppConfig extends AppConfig {

    public RestControllerModule restControllerConfig;
    public DtoModule dtoConfig;

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
