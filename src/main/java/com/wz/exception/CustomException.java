package com.wz.exception;

public class CustomException extends Exception {

    private int code;
    private String message;
    public CustomException() {
        super();
    }

    public CustomException(int code,String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
