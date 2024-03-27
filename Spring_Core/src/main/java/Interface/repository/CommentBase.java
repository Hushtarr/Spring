package Interface.repository;
// repository：用于存放数据访问对象，通常与数据库交互。

import Interface.model.Comment;


public interface CommentBase
    {
    void storeComment(Comment comment);
    }
