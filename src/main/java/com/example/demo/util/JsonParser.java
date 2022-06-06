package com.example.demo.util;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonParser {

    protected JsonParser() {}

    public static JSONObject jsonFileToObject(String file) {
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(file)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new JSONObject(content);
    }

    public static void jsonObjectToFile(JSONObject jsonObject, String file) {

        FileHelper.writeToFile("file", jsonObject.toString());

    }

    public static void main(String[] args) {
        JSONObject json = jsonFileToObject("src/main/resources/configuration/db_config.json");
        JSONObject dbSettings = json.getJSONObject("configuration").getJSONObject("database").getJSONObject("settings");
        System.out.println(dbSettings);
//        jsonObjectToFile("");
    }
}
