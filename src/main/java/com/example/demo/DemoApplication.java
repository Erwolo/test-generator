package com.example.demo;

import com.example.demo.util.DatabaseHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@SpringBootApplication
public class DemoApplication {
    @Value("db.is.active")
    String databaseState;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(DatabaseHelper databaseHelper) {

        return (args) -> {
            if (databaseState.equals("true")) {
                try (Connection con = databaseHelper.createMySqlDataSource().getConnection())
                {
                    con.prepareStatement("CREATE SCHEMA if NOT EXISTS micro_generator;").execute();
                    con.prepareStatement("USE micro_generator;").execute();
                    con.prepareStatement("ALTER TABLE user MODIFY COLUMN id INT NOT NULL AUTO_INCREMENT;").execute();
                    con.prepareStatement("ALTER TABLE role MODIFY COLUMN id INT NOT NULL AUTO_INCREMENT;").execute();
                    con.prepareStatement("ALTER TABLE permission MODIFY COLUMN id INT NOT NULL AUTO_INCREMENT;").execute();
                    con.prepareStatement("INSERT INTO user (login, password) SELECT 'erwol', '123' FROM DUAL WHERE NOT EXISTS (SELECT * FROM user WHERE login = 'erwol');").execute();
                    con.prepareStatement("INSERT INTO user (login, password) SELECT 'perwol', '321' FROM DUAL WHERE NOT EXISTS (SELECT * FROM user WHERE login = 'perwol');").execute();
                    con.prepareStatement("INSERT INTO role (name) SELECT 'admin' FROM DUAL WHERE NOT EXISTS (SELECT * FROM role WHERE name = 'admin');").execute();
                    con.prepareStatement("INSERT INTO role (name) SELECT 'user' FROM DUAL WHERE NOT EXISTS (SELECT * FROM role WHERE name = 'user');").execute();
                    con.prepareStatement("INSERT INTO permission (name) SELECT 'read' FROM DUAL WHERE NOT EXISTS (SELECT * FROM permission WHERE name = 'read');").execute();
                    con.prepareStatement("INSERT INTO permission (name) SELECT 'write' FROM DUAL WHERE NOT EXISTS (SELECT * FROM permission WHERE name = 'write');").execute();
                    con.prepareStatement("INSERT INTO permission (name) SELECT 'edit' FROM DUAL WHERE NOT EXISTS (SELECT * FROM permission WHERE name = 'edit');").execute();
                    con.prepareStatement("INSERT INTO permission (name) SELECT 'delete' FROM DUAL WHERE NOT EXISTS (SELECT * FROM permission WHERE name = 'delete');").execute();
                    con.prepareStatement("INSERT INTO user_role (user_id, role_id) SELECT (SELECT id FROM user WHERE login = 'erwol' LIMIT 1), (SELECT id FROM role WHERE name = 'admin' LIMIT 1) FROM DUAL WHERE NOT EXISTS (SELECT * FROM user_role where user_id = (SELECT id FROM user WHERE login = 'erwol' LIMIT 1) AND role_id = (SELECT id FROM role WHERE name = 'admin' LIMIT 1));").execute();
                    con.prepareStatement("INSERT INTO user_role (user_id, role_id) SELECT (SELECT id FROM user WHERE login = 'perwol' LIMIT 1), (SELECT id FROM role WHERE name = 'user' LIMIT 1) FROM DUAL WHERE NOT EXISTS (SELECT * FROM user_role where user_id = (SELECT id FROM user WHERE login = 'perwol' LIMIT 1) AND role_id = (SELECT id FROM role WHERE name = 'user' LIMIT 1));").execute();
                    con.prepareStatement("INSERT INTO role_permission (role_id, permission_id) SELECT (SELECT id FROM role WHERE name = 'admin' LIMIT 1), (SELECT id FROM permission WHERE name = 'read' LIMIT 1) FROM DUAL WHERE NOT EXISTS (SELECT * FROM role_permission WHERE role_id = (SELECT id FROM role WHERE name = 'admin' LIMIT 1) AND permission_id = (SELECT id FROM permission WHERE name = 'read' LIMIT 1));").execute();
                    con.prepareStatement("INSERT INTO role_permission (role_id, permission_id) SELECT (SELECT id FROM role WHERE name = 'admin' LIMIT 1), (SELECT id FROM permission WHERE name = 'write' LIMIT 1) FROM DUAL WHERE NOT EXISTS (SELECT * FROM role_permission WHERE role_id = (SELECT id FROM role WHERE name = 'admin' LIMIT 1) AND permission_id = (SELECT id FROM permission WHERE name = 'write' LIMIT 1));").execute();
                    con.prepareStatement("INSERT INTO role_permission (role_id, permission_id) SELECT (SELECT id FROM role WHERE name = 'admin' LIMIT 1), (SELECT id FROM permission WHERE name = 'edit' LIMIT 1) FROM DUAL WHERE NOT EXISTS (SELECT * FROM role_permission WHERE role_id = (SELECT id FROM role WHERE name = 'admin' LIMIT 1) AND permission_id = (SELECT id FROM permission WHERE name = 'edit' LIMIT 1));").execute();
                    con.prepareStatement("INSERT INTO role_permission (role_id, permission_id) SELECT (SELECT id FROM role WHERE name = 'admin' LIMIT 1), (SELECT id FROM permission WHERE name = 'delete' LIMIT 1) FROM DUAL WHERE NOT EXISTS (SELECT * FROM role_permission WHERE role_id = (SELECT id FROM role WHERE name = 'admin' LIMIT 1) AND permission_id = (SELECT id FROM permission WHERE name = 'delete' LIMIT 1));").execute();
                    con.prepareStatement("INSERT INTO role_permission (role_id, permission_id) SELECT (SELECT id FROM role WHERE name = 'user' LIMIT 1), (SELECT id FROM permission WHERE name = 'read' LIMIT 1) FROM DUAL WHERE NOT EXISTS (SELECT * FROM role_permission WHERE role_id = (SELECT id FROM role WHERE name = 'user' LIMIT 1) AND permission_id = (SELECT id FROM permission WHERE name = 'read' LIMIT 1));").execute();

                } catch (Exception e) {
                    System.out.println("Could not initialize data on startup");
                    e.printStackTrace();
                }
            }
        };
    }

}
