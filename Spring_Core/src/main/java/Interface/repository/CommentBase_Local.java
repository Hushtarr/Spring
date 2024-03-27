package Interface.repository;
// // repository：用于存放数据访问对象，通常与数据库交互。

import Interface.model.Comment;
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
