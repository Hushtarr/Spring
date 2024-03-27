package org.spring.spring_core.Bean;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
* @Component和@ComponentScan之间的联系非常直接：
* @ComponentScan指定了Spring应当查找带有@Component（及其衍生注解）的类的位置，
* 而@Component则标记了哪些类应当被Spring识别和管理。没有@ComponentScan，Spring不会自动地知道去哪里查找组件；
* 没有@Component（或其衍生注解），类即使在扫描路径中也不会被注册为Spring的Bean。因此，这两个注解共同工作，使得自动组件扫描和注册成为可能，
* 极大地简化了Spring应用的配置和管理。
*/

    @Configuration
    @ComponentScan(basePackages = "org.spring.spring_core")
    /*@ComponentScan注解用于配置类上，指示Spring从哪些包开始扫描带有@Component（及其衍生注解）的类，
    这样Spring就可以自动地注册这些类为应用上下文中的Bean。你可以指定@ComponentScan扫描的基础包，这样Spring就会在这些包及其子包中查找并注册组件。*/
public class House_config
    {
    @Bean
    // @Autowired    //-> No annotations are needed when there is only one constructor
    public Multi multi(House_tv tv, House_pc pc) {  // @Bean方法直接创建一个对象实例时，你调用的构造函数需要与那个对象类中定义的构造函数保持一致
    return new Multi(tv, pc);
    }

    }
@Data
class Multi
    {
    private House_tv m_tv;
    private House_pc m_pc;

//    @Autowired    -> No annotations are needed when there is only one constructor
/*
Either define its parameters directly through Autowired here
Or use an empty constructor to customize parameters when a new object is created. See House.java lines 27 and 28 for details.
*/
    public Multi(House_tv tv,House_pc pc)
        {
        this.m_tv = tv;
        this.m_pc = pc;
        }

    public void info()
        {
        System.out.println(m_tv.getTv() +" and "+ m_pc.getPc() + " become your multiDevice");
        }
    }
