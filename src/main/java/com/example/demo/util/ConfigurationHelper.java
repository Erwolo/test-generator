package com.example.demo.util;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfigurationHelper {

    @Autowired
    private JsonParser jsonParser;

    public ConfigurationHelper() {
    }

    private JSONObject getConfiguration(String configurationPath) {
        // TODO: validate configuration
        JSONObject configuration = jsonParser.jsonFileToObject(configurationPath);

        return configuration;
    }

    public JSONObject getDatabaseConfiguration(String configurationPath) {
        return getConfiguration(configurationPath).getJSONObject("configuration").getJSONObject("database");
    }

    public JSONObject getProjectConfiguration(String configurationPath) {
        return getConfiguration(configurationPath).getJSONObject("configuration").getJSONObject("project");
    }
}
