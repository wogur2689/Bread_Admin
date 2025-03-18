package com.example.bread.common.dto;

public class CommonDto<T> {
    private String code; //결과코드
    private String msg;  //반환메세지
    private T data; //데이터
}
