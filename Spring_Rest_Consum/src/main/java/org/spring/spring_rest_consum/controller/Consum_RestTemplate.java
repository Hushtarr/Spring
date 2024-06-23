package org.spring.spring_rest_consum.controller;

import org.spring.spring_rest_consum.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/cy")
public class Consum_RestTemplate {
    private final RestTemplate restTemplate;
    private final String URI="https://jsonplaceholder.typicode.com/users";

    public Consum_RestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public ResponseEntity<User[]>getAllUser(){
        return restTemplate.getForEntity(URI,User[].class);
    }
}
