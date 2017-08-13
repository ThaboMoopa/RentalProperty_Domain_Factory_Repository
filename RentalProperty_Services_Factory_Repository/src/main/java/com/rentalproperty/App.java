package com.rentalproperty;

/**
 * Hello world!
 **/


import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.Driver;
import java.sql.DriverManager;

@RestController

@EnableAutoConfiguration


public class App {
    @RequestMapping("/")
    String home() {

        return "<h1>Hello World</h1>";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}
