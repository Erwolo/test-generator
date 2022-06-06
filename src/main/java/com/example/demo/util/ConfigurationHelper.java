package com.example.demo.util;

import org.json.JSONObject;

public class ConfigurationHelper {

    JSONObject configuration;

    public ConfigurationHelper() {
    }

    public JSONObject getConfiguration() {
        configuration = JsonParser.jsonFileToObject("src/main/resources/configuration/db_config.json");

        return configuration;
    }

}
