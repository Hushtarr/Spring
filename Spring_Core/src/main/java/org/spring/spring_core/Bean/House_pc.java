package org.spring.spring_core.Bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
/*
 * Component注解用于类级别，标记一个类为Spring管理的组件。
 * 当你在一个类上使用@Component注解时，你告诉Spring，这个类应该被当作一个Bean来处理，Spring会负责创建和管理这个类的实例
 */
public class House_pc
    {
    private String pc;
    private House_tv pc_tv; //组件之间的依赖关系的建立可以通过wiring 解决,此处是一个tv类,但是为了建立pc所拥有的tv之间的关系,要用wiring

    @Autowired
    //这意味着Spring将会自动注入一个House_tv的实例到House_pc的构造函数中。
    public House_pc(House_tv tv)
        {
        this.pc_tv = tv;
        }

    public void info()
        {
        System.out.println(getPc()+" is your Pc and "+pc_tv.getTv()+" is you tv");
        }
    }
