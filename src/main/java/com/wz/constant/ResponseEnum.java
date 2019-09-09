package com.wz.constant;




public enum  ResponseEnum {

    SUCESSS(200,"成功"),
    CAMERAL_NOT_EXITS(400,"摄像头不存在");

    public int code;
    public String message;

    ResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseEnum getEnum(int code) {
        for (ResponseEnum responseEnum:ResponseEnum.values()) {
            if(code == responseEnum.getCode()) {
                return responseEnum;
            }
        }
        return null;
    }
}
