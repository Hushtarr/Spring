package org.spring.spring_rest_consum.controller;

import org.spring.spring_rest_consum.dto.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

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

    @GetMapping("{id}")
    public Object findUser(@PathVariable("id") Integer id ){
        String url=URI+"/{id}";
        return restTemplate.getForObject(url,Object.class,id);
    }
    @GetMapping("/test")
    public ResponseEntity<Object> consumePostFromDummyApi(){

        HttpHeaders headers =new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("app-id","6298ebfecd0551211fce37a6");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange("https://dummyapi.io/data/v1/user?limit=10", HttpMethod.GET,entity,Object.class);

    }
}
