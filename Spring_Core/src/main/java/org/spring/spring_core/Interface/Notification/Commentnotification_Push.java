package org.spring.spring_core.Interface.Notification;

import org.spring.spring_core.Interface.model.Comment;
import org.springframework.stereotype.Component;

@Component("Top bar")
/*

@Scope(BeanDefinition.SCOPE_SINGLETON)  // bean创建一个且仅一个实例。无论多少次请求，都只会获得相同的bean实例。
@Scope(BeanDefinition.SCOPE_PROTOTYPE) // 每次调用getBean()方法时都会创建一个新的实例。

*/

public class Commentnotification_Push implements CommentNotification
    {
    @Override
    public void sendComment(Comment comment)
        {
        System.out.println("Sending message in Top bar");
        }
    }
