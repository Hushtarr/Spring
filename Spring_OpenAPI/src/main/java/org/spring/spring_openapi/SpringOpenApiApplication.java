package org.spring.spring_openapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class SpringOpenApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringOpenApiApplication.class, args);
    }

}
