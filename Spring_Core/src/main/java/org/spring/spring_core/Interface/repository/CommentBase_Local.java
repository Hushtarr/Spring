package org.spring.spring_core.Interface.repository;
// // repository：用于存放数据访问对象，通常与数据库交互。

import org.spring.spring_core.Interface.model.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentBase_Local implements CommentBase
    {
    @Override
    public void storeComment(Comment comment)
        {
        System.out.println("Storing data to the local");
        }
    }
