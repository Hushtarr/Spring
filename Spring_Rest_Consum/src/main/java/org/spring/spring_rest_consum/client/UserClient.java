package org.spring.spring_rest_consum.client;

import org.spring.spring_rest_consum.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "https://jsonplaceholder.typicode.com",name = "USER-CLIENT")
public interface UserClient {

    @GetMapping("/users")
    List<User>getUsers();

}
