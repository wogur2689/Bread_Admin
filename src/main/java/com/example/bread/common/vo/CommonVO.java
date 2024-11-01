package com.example.bread.common.vo;

import lombok.*;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommonVO {
    private String code; //결과코드
    private String msg;  //반환메세지
    private Object data; //데이터
}
