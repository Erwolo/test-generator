package com.example.demo.util;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DatabaseHelper {

    @Autowired
    private Environment env;

    protected DatabaseHelper(){}

    public DataSource createH2DatSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:h2:mem:;INIT=RUNSCRIPT FROM 'classpath:/initialize.sql';");
        ds.setUsername("se");
        ds.setPassword("");

        return ds;
    }

    public DataSource createDatSourceMySQL() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(env.getProperty("spring.datasource.url"));
        ds.setUsername(env.getProperty("spring.datasource.username"));
        ds.setPassword(env.getProperty("spring.datasource.password"));
        ds.setSchema(env.getProperty("db.schema"));

        return ds;
    }


}
