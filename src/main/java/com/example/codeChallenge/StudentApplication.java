package com.example.codeChallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
@ConfigurationPropertiesScan
public class StudentApplication {

    public static void main (String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }

}
