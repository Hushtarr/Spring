package Bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class CatTest
    {
    public static void main(String[] args)
        {
        ApplicationContext container=new AnnotationConfigApplicationContext(CarConfig.class);

        CarObj n1=container.getBean("audi", CarObj.class);//只有一个类但是其方法重载时 ->get(“方法名”,类文件)
        n1.setModel(" A6");
        System.out.println(n1.getModel());



        CarObj n1_1=container.getBean("b",CarObj.class); //Reference to the bean named "b"
        n1_1.setModel("116i");
        System.out.println(n1_1.getModel());



        CarObj n1_2=container.getBean(CarObj.class);
        //Points to the default method or primary method If there is a "primary" annotation
        n1_2.setModel("Mustang");
        System.out.println(n1_2.getModel());



        Car_Phone n2=container.getBean(Car_Phone.class);//只有一个类其没有方法重载时 ->  get(类文件)
        n2.setModel(" iphone 5");
        System.out.println(n2.getModel());


        }
    }
