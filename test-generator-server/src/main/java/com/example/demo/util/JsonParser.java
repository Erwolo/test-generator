package com.example.demo.util;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonParser {

    public JsonParser() {}

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
        FileHelper.writeToFile(file, jsonObject.toString());
    }
}
