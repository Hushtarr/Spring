package Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BestM8_Controller
    {
        @RequestMapping("/best")
        public String getBest(Model model)
            {
            model.addAttribute("name","Abc");
            model.addAttribute("age","29");

            return "Best.M8";


        }
    }
/*
既然你使用了Thymeleaf，这解释了为什么你无法直接访问位于/static目录下的mine.html文件。
Thymeleaf是一个Java库，用于在Web应用程序中处理HTML、XML等模板。在使用Thymeleaf时，
模板文件应该位于src/main/resources/templates目录下，而不是/static目录。/static目录用于存放静态资源，
如CSS、JavaScript和图片等.对于使用Thymeleaf的Spring Boot项目，你应该这样组织你的文件：
将Thymeleaf模板（如mine.html）放入src/main/resources/templates目录。
将静态资源（如CSS、JavaScript、图片等）放入src/main/resources/static目录。
*/