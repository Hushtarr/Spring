package org.spring.spring_rest_consum.controller;

import org.spring.spring_rest_consum.client.EmployeeClient;
import org.spring.spring_rest_consum.client.UserClient;
import org.spring.spring_rest_consum.dto.ResponseWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Consum_FeignClient {
    private final UserClient userClient;
    private final EmployeeClient employeeClient;

    public Consum_FeignClient(UserClient userClient, EmployeeClient employeeClient) {
        this.userClient = userClient;
        this.employeeClient = employeeClient;
    }

    @GetMapping("/api/v1/users")
    public ResponseEntity<ResponseWrapper>getusers(){
        return ResponseEntity
                .ok(new ResponseWrapper("user finded",userClient.getUsers()));
    }

    @GetMapping("/api/v1/employee")
    public ResponseEntity<ResponseWrapper>getEmployees(){
        return ResponseEntity
               .ok(new ResponseWrapper("employee finded",employeeClient.getEmployee("6298ebfecd0551211fce37a6")));
    }
}
