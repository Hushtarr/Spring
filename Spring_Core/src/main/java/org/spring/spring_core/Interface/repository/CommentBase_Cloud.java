package org.spring.spring_core.Interface.repository;

import org.spring.spring_core.Interface.model.Comment;

public class CommentBase_Cloud implements CommentBase
    {

    @Override
    public void storeComment(Comment comment)
        {
        System.out.println("Storing data to the local");
        }


    }
