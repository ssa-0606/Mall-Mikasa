package com.imikasa.pojo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ResultCode implements ErrorCode{
    SUCCESS(200,"操作成功"),
    FAILED(500,"操作失败");

    private int code ;
    private String message ;


    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
