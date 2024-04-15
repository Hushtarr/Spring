package org.spring.spring_core.Interface.service;
// service：包含服务层类，这些类通常包含业务逻辑。

import org.spring.spring_core.Interface.Notification.CommentNotification;
import org.spring.spring_core.Interface.model.Comment;
import org.spring.spring_core.Interface.repository.CommentBase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CommentService

    {
    // private CommentBase_Local comments;
    // private CommentNotification_Email email;
    //直接使用接口方便更灵活的运用
    /*你的代码依赖于抽象而不是具体的实现细节，使得代码更加灵活。(比如本地存储换成云端存储)
    * 更换不同的实现类变得更加容易，因为这种更改不会影响到使用这些接口的代码。(比如 邮件 换成 短信)
    * */
    private final CommentBase comments;
    private final CommentNotification notific;
    //意义：声明为final的变量必须在构造函数完成时被初始化，之后就不能再改变其引用
    //通过将依赖声明为final，明确表示这些依赖是该类不可或缺的部分，它们在整个对象的生命周期内都不应该被更换。
    //使用final关键字可以让编译器帮助检查代码，确保所有的final变量在构造器结束前被初始化

    public CommentService(CommentBase comments,@Qualifier("Top bar")CommentNotification notific)
            //  distinguish Bean->  Bean("name"),

         /*
          distinguish Components
          [component("value")->     (@Qualifier("value")+引用处.method name)]*/
        {
        this.comments = comments;
        this.notific = notific;
        }

    public void commentUsage(Comment comment)
        {

        // Store to CommentBase
        comments.storeComment(comment);


        // Send the Notification
        notific.sendComment(comment);

        }
    }
