package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("database-connector")
public class DatabaseConnectorController {

    @GetMapping("/")
    public String databaseConnectorHome() {
        return "database-connector";
    }

    @PostMapping("generate-db-connection")
    public String generateDbConnection(@RequestParam String dbAddress) {
        System.out.println("DB address is: " + dbAddress);


        return "database-table";
    }

}
