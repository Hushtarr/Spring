package org.spring.spring_core.Bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ShorApp
    {
    public static void main(String[] args)
        {
        ApplicationContext Container = new AnnotationConfigApplicationContext(Short_config.class);

        Short_audi a=Container.getBean(Short_audi.class);
        a.Buy_Audi();

        Short_bmw b=Container.getBean(Short_bmw.class);
        b.Buy_Bmw();

        }

    }
