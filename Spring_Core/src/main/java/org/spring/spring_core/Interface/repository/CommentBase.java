package org.spring.spring_core.Interface.repository;
// repository：用于存放数据访问对象，通常与数据库交互。

import org.spring.spring_core.Interface.model.Comment;


public interface CommentBase
    {
    void storeComment(Comment comment);
    }
