package com.example.demo.util;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TemplateHelper {

    public static Configuration prepareConfiguration() throws IOException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        return configuration;
    }

}
