package org.spring.spring_core.Interface.Notification;
// util或helper：包含辅助类或工具类。

import org.spring.spring_core.Interface.model.Comment;
import org.springframework.stereotype.Component;

@Component("Email")
public class CommentNotification_Email implements CommentNotification
    {
    @Override
    public void sendComment(Comment comment)
        {
        System.out.println("Sending message by email");
        }
    }
