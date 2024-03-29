package org.spring.spring_thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
//
//Path Variable
//http://localhost:8080//student//info -> then it will work
@RequestMapping("/student")
public class ctrl
    {
    @RequestMapping("/info")
    public String getinfo(Model model)
        {
        model.addAttribute("List",DTgenerate.base());
        return "ps";
        }
    }
//Query Parameter
//http://localhost:8080/info2?brand=Bmw&year=2017
//
//Path Variable
//http://localhost:8080/info4/Bmw/2017