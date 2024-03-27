package Interface;

import Interface.config.Config;
import Interface.model.Comment;
import Interface.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import javax.management.Notification;

public class App
    {
    public static void main(String[] args)
        {
        Comment msg=new Comment();
        msg.setUser("Abc");
        msg.setMessage("Hello world");
        ApplicationContext container=new  AnnotationConfigApplicationContext(Config.class);
        CommentService t1=container.getBean(CommentService.class);
        t1.publishComment(msg);
        }
    }
