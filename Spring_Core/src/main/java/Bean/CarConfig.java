package Bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.ui.Model;

@Configuration
@Lazy
public class CarConfig
    {
    @Bean()
    //
    public CarObj audi()

        {
        System.out.println("this is audi");
        return new CarObj();
        }
    //在Spring容器初始化时，它会加载并处理配置类CarConfig中的所有@Bean注解方法，从而创建和注册所有定义的bean。
    // 所以就算通过一个方法创建,另外的方法也会自动被加载并输出
    //解决方法就是在对应的config或者某个单一的方法里加上@Lazy注解，
    @Bean(name = "b") //Customize bean names to more conveniently distinguish methods when creating beans
    public CarObj bmw()

        {
        System.out.println("this is Bmw");
        return new CarObj();
        }

    @Bean
    @Primary
    public CarObj ford()
        {
        System.out.println("this is Ford");
        return new CarObj();
        }
    @Bean()
    public Car_Phone phone()
        {
        System.out.println("your first iphone it was");
        return new Car_Phone();
        }
    }
