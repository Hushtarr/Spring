package Bean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
/*
* Component注解用于类级别，标记一个类为Spring管理的组件。
* 当你在一个类上使用@Component注解时，你告诉Spring，这个类应该被当作一个Bean来处理，Spring会负责创建和管理这个类的实例
*/
public class House_tv
    {
    private String tv;
    public void info()
        {
        System.out.println(getTv()+" is your Tv");
        }
    }
