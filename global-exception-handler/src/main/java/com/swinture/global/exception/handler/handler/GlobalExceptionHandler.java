package com.swinture.global.exception.handler.handler;

import com.swinture.global.exception.handler.model.CommonAns;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author swinture
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 请求方法不支持异常
     * @param e
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public CommonAns handle(HttpRequestMethodNotSupportedException e) {
        logger.error(e.getMessage());
        return new CommonAns(HttpStatus.METHOD_NOT_ALLOWED.value(),
                HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase());
    }

    /**
     * 请求不存在
     * @param e
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public CommonAns handle(NoHandlerFoundException e) {
        logger.error(e.getMessage());
        return new CommonAns(HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase());
    }

    /**
     * 请求参数校验不通过异常
     * @param e
     * @return
     */
    @ExceptionHandler({
            MethodArgumentNotValidException.class,
            BindException.class,
            HttpMessageNotReadableException.class,
            MissingServletRequestParameterException.class,
            MissingPathVariableException.class,
            MissingRequestCookieException.class,
            MissingRequestHeaderException.class,
            TypeMismatchException.class})
    public CommonAns handle(Exception e) {
        logger.error(e.getMessage());
        return new CommonAns(HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase());
    }


    /**
     * 其他异常统一处理，对于未明确定义ExceptionHandler的异常，一律返回内部错误异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public CommonAns handleException(Exception e) {
        e.printStackTrace();
        logger.error(e.getMessage());
        return new CommonAns(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }
}
