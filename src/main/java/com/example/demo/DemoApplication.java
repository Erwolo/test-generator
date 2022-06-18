package com.example.demo;

import com.example.demo.util.DatabaseHelper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(DatabaseHelper databaseHelper) {
        return (args) -> {
            try (Connection con = databaseHelper.createMySqlDataSource().getConnection())
            {
                con.prepareStatement("CREATE SCHEMA if NOT EXISTS micro_generator;").execute();
                con.prepareStatement("USE micro_generator;").execute();
                con.prepareStatement("INSERT IGNORE INTO user (login, password) values ('erwol', '123');").execute();
                con.prepareStatement("INSERT IGNORE INTO user (login, password) values ('perwol', '321');").execute();
                con.prepareStatement("INSERT IGNORE INTO role (name) values ('admin');").execute();
                con.prepareStatement("INSERT IGNORE INTO role (name) values ('user');").execute();
                con.prepareStatement("INSERT IGNORE INTO permission (name) values ('read');").execute();
                con.prepareStatement("INSERT IGNORE INTO permission (name) values ('write');").execute();
                con.prepareStatement("INSERT IGNORE INTO permission (name) values ('edit');").execute();
                con.prepareStatement("INSERT IGNORE INTO permission (name) values ('delete');").execute();
                con.prepareStatement("INSERT IGNORE INTO user_role (user_id, role_id) VALUES (SELECT id FROM user WHERE name = 'erwol', SELECT id FROM role WHERE name = 'admin');").execute();
                con.prepareStatement("INSERT IGNORE INTO user_role (user_id, role_id) VALUES (SELECT id FROM user WHERE name = 'perwol', SELECT id FROM role WHERE name = 'user');").execute();
                con.prepareStatement("INSERT IGNORE INTO role_permission (role_id, permission_id) VALUES (SELECT id FROM role WHERE name = 'admin', SELECT id FROM permission WHERE name = 'read');").execute();
                con.prepareStatement("INSERT IGNORE INTO role_permission (role_id, permission_id) VALUES (SELECT id FROM role WHERE name = 'admin', SELECT id FROM permission WHERE name = 'write');").execute();
                con.prepareStatement("INSERT IGNORE INTO role_permission (role_id, permission_id) VALUES (SELECT id FROM role WHERE name = 'admin', SELECT id FROM permission WHERE name = 'edit');").execute();
                con.prepareStatement("INSERT IGNORE INTO role_permission (role_id, permission_id) VALUES (SELECT id FROM role WHERE name = 'admin', SELECT id FROM permission WHERE name = 'delete');").execute();
                con.prepareStatement("INSERT IGNORE INTO role_permission (role_id, permission_id) VALUES (SELECT id FROM role WHERE name = 'user', SELECT id FROM permission WHERE name = 'read');").execute();

            } catch (Exception e) {
                System.out.println("Could not initialize data on startup");
                e.printStackTrace();
            }
        };
    }

}
