package org.spring.spring_core.Interface;

import org.spring.spring_core.Interface.config.Config;
import org.spring.spring_core.Interface.model.Comment;
import org.spring.spring_core.Interface.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
    {
    public static void main(String[] args)
        {
        Comment msg=new Comment();
        msg.setUser("Abc");
        msg.setMessage("Hello world");
        ApplicationContext container=new  AnnotationConfigApplicationContext(Config.class);
        CommentService t1=container.getBean(CommentService.class);
        t1.commentUsage(msg);

        }
    }
