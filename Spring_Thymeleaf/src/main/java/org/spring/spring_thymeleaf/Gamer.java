package org.spring.spring_thymeleaf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gamer
    {
    private String gameId,userName,gender,email,teamName,msg;
    private boolean pro;

    }
