package com.example.demo.config;

import com.example.demo.util.ConfigurationHelper;
import com.example.demo.util.JsonParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class BeansConfig {

    @Bean
    public JsonParser getJsonParser() {
        return new JsonParser();
    }

    @Bean
    public ConfigurationHelper getConfigurationHelper() {
        return new ConfigurationHelper();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
