package com.wz.exception;

import com.wz.constant.ErrorResp;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 继承抽象类框架的异常处理类 ResponseEntityExceptionHandler
 */
@RestControllerAdvice
public class CommonExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(value = CustomException.class)
    public ErrorResp handCustom(HttpServletRequest request, Exception e, HttpServletResponse response) {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        CustomException exception = (CustomException) e;
        return new ErrorResp(exception.getCode(),exception.getMessage());
    }
}
