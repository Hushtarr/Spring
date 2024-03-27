package org.spring.spring_core.Bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class House
    {
    public static void main(String[] args)
        {
        ApplicationContext container=new AnnotationConfigApplicationContext(House_config.class);
        House_pc n1=container.getBean(House_pc.class);
        House_tv n2=container.getBean(House_tv.class);
        // 依赖关系的建立  方法1     (使用了component)
        n1.setPc("Mac os");
        n2.setTv("apple TV");
        n1.setPc_tv(n2);

        //依赖关系的建立  方法2      (使用了component)
        // n1.setPc_tv(new House_tv().setTv("apple tv")); // lombok 的原因而报错 需要手动 getter setter
        n1.setPc_tv(new House_tv());// 先建立一个对象
        n1.getPc_tv().setTv("Apple tv"); //再调用该对象的setter方法在设置属性(此处会覆盖第16行的属性)*/

        n1.info();

        // 为解读依赖关系而建立的  Multi obj (使用了bean)
        Multi mdvice=container.getBean(Multi.class);
        // mdvice.setM_pc(n1);
        // mdvice.setM_tv(n2);
        mdvice.info();


        }
    }
