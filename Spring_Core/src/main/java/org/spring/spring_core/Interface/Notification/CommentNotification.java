package org.spring.spring_core.Interface.Notification;
// util或helper：包含辅助类或工具类。

import org.spring.spring_core.Interface.model.Comment;

public interface CommentNotification
    {
    void sendComment(Comment comment);
    // bean but found 2: commentNotification_Email,commentnotification_Push

    /*When multiple classes implement the same interface, an error will be reported,
    and the bean will complain that multiple classes were found,
    so it is necessary to distinguish those classes in order to decide which one to use.*/
    }
