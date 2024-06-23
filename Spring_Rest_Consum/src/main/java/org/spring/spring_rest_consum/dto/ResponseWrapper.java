package org.spring.spring_rest_consum.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class ResponseWrapper {

    private boolean success;
    private String message;
    private Integer status;
    private Object data;

    public ResponseWrapper(String message, Object data) {
        this.success = true;
        this.message = message;
        this.status = HttpStatus.OK.value();
        this.data = data;
    }

    public ResponseWrapper(String message) {
        this.success = true;
        this.message = message;
        this.status = HttpStatus.OK.value();

    }
}
