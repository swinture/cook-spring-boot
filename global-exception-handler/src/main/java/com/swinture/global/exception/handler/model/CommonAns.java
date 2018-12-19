package com.swinture.global.exception.handler.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author swinture
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonAns implements Serializable {

    private int resultCode;
    private String resultMsg;

    public CommonAns ok() {
        this.resultCode = HttpStatus.OK.value();
        this.resultMsg = HttpStatus.OK.getReasonPhrase();
        return this;
    }

}
