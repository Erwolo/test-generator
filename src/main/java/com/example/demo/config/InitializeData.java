package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class InitializeData {

    @Autowired
    private DataSource dataSource;

    @Value("${db.mode}")
    private String databaseMode;

    @EventListener(ApplicationReadyEvent.class)
    public void loadData() {
        if (databaseMode.equals("prod"))
            new ResourceDatabasePopulator(false, false, "UTF-8", new ClassPathResource("mysql_initialize.sql"))
                    .execute(dataSource);
        if (databaseMode.equals("dev"))
            new ResourceDatabasePopulator(false, false, "UTF-8", new ClassPathResource("h2_initialize.sql"))
                    .execute(dataSource);
    }
}
