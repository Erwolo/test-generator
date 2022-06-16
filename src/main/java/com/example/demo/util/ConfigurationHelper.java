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

    private JSONObject getConfiguration() {
        // TODO: validate configuration
        JSONObject configuration = jsonParser.jsonFileToObject("src/main/resources/configuration/db_config.json");

        return configuration;
    }

    public JSONObject getDatabaseConfiguration() {
        return getConfiguration().getJSONObject("configuration").getJSONObject("database");
    }

    public JSONObject getProjectConfiguration() {
        return getConfiguration().getJSONObject("configuration").getJSONObject("project");
    }
}
