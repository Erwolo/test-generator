package com.example.demo.util;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class DatabaseHelper {

//
    public static DataSource createDatSourceH2() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:h2:mem:;INIT=RUNSCRIPT FROM 'classpath:initialize.sql';");
        ds.setUsername("se");
        ds.setPassword("");

        return ds;
    }

    public static DataSource createDatSourceMySQL() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/");
        ds.setUsername("root");
        ds.setPassword("erwin123");
        ds.setSchema("generator_test");

        return ds;
    }
}
