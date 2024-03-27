package com.example.demo.Controller;

import com.example.demo.Model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class ctrl
    {

    @RequestMapping("/a")
    public String getpage2(Model model)
        {
        model.addAttribute("name","Hushtar");
        model.addAttribute("school","Cydeo");

        String sbj="Wow";
        model.addAttribute("sbj",sbj);

        int obj=new Random().nextInt();
        model.addAttribute("obj",obj);

        List<Integer>num=new ArrayList<>();
        for (int i = 0; i < 3; i++)
            {
            int ran=new Random().nextInt();
            num.add(ran);
            }
        model.addAttribute("num",num);


        Student s1=new Student("Abc","Cydeo",888);
        model.addAttribute("Student",s1);


        return "mine";
        }
    }
