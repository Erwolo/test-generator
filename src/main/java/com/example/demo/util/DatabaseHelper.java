package com.example.demo.util;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class DatabaseHelper {

    protected DatabaseHelper(){}

    public static DataSource createH2DatSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:h2:mem:;INIT=RUNSCRIPT FROM 'classpath:/initialize.sql';");
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
