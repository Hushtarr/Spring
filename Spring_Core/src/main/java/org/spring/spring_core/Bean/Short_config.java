package org.spring.spring_core.Bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Short_config
    {
    @Bean
        Short_audi shortAudi()
        {
        return new Short_audi();
        }



    @Bean(name = "Bmw")
    Short_bmw shortBmw()
        {
        return new Short_bmw();
        }


    @Bean
    @Primary
    Short_benz shortBenz()
        {
        return new Short_benz();
        }
    }



