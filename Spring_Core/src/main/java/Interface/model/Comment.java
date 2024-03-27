package Interface.model;
//model或domain：包含应用的业务模型或实体类。

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
    @Data
public class Comment
    {
        private String message;
        private String user;
    }
