package Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController
    {
    @RequestMapping() //default
    public String getpage1()
        {
        return "mine";
        //If it is not in the default folder, it cannot be called directly, and the folder must be indicated.
        }

    @RequestMapping("/mine") //default
    public String getpage2()
        {
        return "mine";
        //If it is not in the default folder, it cannot be called directly, and the folder must be indicated.
        }
    @RequestMapping("/Custom") //Customize
    public String getpage3()
        {
        return "mine";
        //If it is not in the default folder, it cannot be called directly, and the folder must be indicated.
        }

    @RequestMapping({"One","Two"}) //Multiple end points
    public String getpage4()
        {
        return "Best.M8"; //If it is in the default folder, you can call it directly
        }
    }
