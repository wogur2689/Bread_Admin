package com.example.bread.common.dto;


//java 14에서 부터 record 사용가능
public record CommonDto(
    String code, //결과코드
    String msg,  //반환메세지
    Object data  //데이터
){}
