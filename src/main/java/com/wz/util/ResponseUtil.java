package com.wz.util;

import com.wz.model.Response;

public class ResponseUtil {

    private ResponseUtil() {

    }

    /**
     * 失败返回提示信息以及状态码
     * @param message
     * @param code
     * @return
     */
    public static Response fail(String message, Integer code) {
        return Response.builder().message(message).code(code).build();
    }

    /**
     * 成功返回数据
     * @param object
     * @return
     */
    public static Response success(Object object) {
        return Response.builder().data(object).code(200).message("success").build();
    }

    /**
     * 成功返回数据
     * @param object
     * @return
     */
    public static Response success(Object object,String message) {
        return Response.builder().data(object).code(200).message(message).build();
    }
}
