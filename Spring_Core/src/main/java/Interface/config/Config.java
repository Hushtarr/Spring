package Interface.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "Interface")
public class Config
    {
    /*
    建立component的条件
        如果该类是被其他组件依赖的,也就是在其他地方被注入了的就可以(目前的知识储备)
        comment-没有
        CommentNotification-没有(而且interface不能建立对象)
        CommentNotification_Email   -有
        CommentBase -没有
        CommentBase_Local   -有
        CommentService  -有
    */
    }
