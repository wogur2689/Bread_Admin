package com.example.bread.common.dto;

import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommonDto {
    private String code; //결과코드
    private String msg;  //반환메세지
    private Object data; //데이터
}
