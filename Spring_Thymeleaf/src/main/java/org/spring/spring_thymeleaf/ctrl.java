package org.spring.spring_thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        return "test1";
        }
    @RequestMapping("/getinfo")
    public String getinfo1()
        {
        return "test2";
        }
    @RequestMapping("/lab")
    public String lab(Model model)
        {
        model.addAttribute("List",DTgenerate.base());
        return "test3";
        }

    @GetMapping("/pro")
    public String pro(Model model)
        {
        List<String>teamList= Arrays.asList(null,"Djungle","Code Buster","ionia");
        model.addAttribute("teamList",teamList);
        model.addAttribute("gamer",new Gamer());
        return "test4";
        }

    @PostMapping("/set")
    public String setForm(@ModelAttribute("gamer") Gamer gamer)
        {
            return "redirect:/student/pro";
        }
    }


//Query Parameter
//http://localhost:8080/info2?brand=Bmw&year=2017
//
//Path Variable
//http://localhost:8080/info4/Bmw/2017