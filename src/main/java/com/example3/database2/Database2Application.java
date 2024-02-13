package com.example3.database2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2

public class Database2Application {

    public static void main(String[] args) {

        SpringApplication.run(Database2Application.class, args);
    }

}
