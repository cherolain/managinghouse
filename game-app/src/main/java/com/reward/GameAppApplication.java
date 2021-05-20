package com.reward;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource( "application-database.properties")
public class GameAppApplication {


    public static void main(String[] args) {
        SpringApplication.run(GameAppApplication.class, args);

    }
}
