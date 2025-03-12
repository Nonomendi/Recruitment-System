package com.example.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
        System.out.println("Server is running on http://localhost:8080");
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            System.out.println("Application has started and is connected to the database!");
        };
    }
}
