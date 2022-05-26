package com.company;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@OpenAPIDefinition
public class Compulsory11Application {
    // openAPI: localhost:8082/swagger-ui.html
    //on explore: /v2/api-docs
    public static void main(String[] args) {
        SpringApplication.run(Compulsory11Application.class, args);
    }

}



