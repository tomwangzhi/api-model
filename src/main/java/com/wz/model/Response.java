package com.wz.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class  Response<T> {

    /**
     * 状态码
     */
    private Integer code=200;
    /**
     * 提示信息
     */
    private String message = "success";
    /**
     * 返回的数据
     */
    private T data;

}
