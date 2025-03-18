package com.example.bread.common.dto;

public class CommonDto<T> {
    private final String code; //결과코드
    private final String msg;  //반환메세지
    private final T data; //데이터

    public CommonDto(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
