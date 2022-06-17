package com.example.demo.util;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class ConfigurationHelper {

    private static JSONObject getConfiguration(String configurationPath) {
        // src/main/resources/configuration/db_config.json

        // TODO: validate configuration
        JSONObject configuration = JsonParser.jsonFileToObject(configurationPath);

        return configuration;
    }

    public static JSONObject getDatabaseConfig(String path) {
        return getConfiguration(path).getJSONObject("configuration").getJSONObject("database");
    }

    public static JSONObject getDatabaseConfig(JSONObject jsonObject) {
        return jsonObject.getJSONObject("configuration").getJSONObject("database");
    }

    public static JSONObject getProjectConfig(String path) {
        return getConfiguration(path).getJSONObject("configuration").getJSONObject("project");
    }

    public static JSONObject getProjectConfig(JSONObject jsonObject) {
        return jsonObject.getJSONObject("configuration").getJSONObject("project");
    }

    public static JSONObject addProperty(JSONObject currentJson, String key, String value) {
        JSONObject properties;
        if (currentJson.keySet().stream().noneMatch(k -> k.equals("properties"))) currentJson.put("properties", new JSONObject());

        properties = currentJson.getJSONObject("properties");
        properties.put(key, value);
        currentJson.put("properties", properties);
        return currentJson;
    }
}
