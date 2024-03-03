package com.example.bread.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommonVO implements Serializable {
    private String code; //결과코드
    private String msg; //반환메세지
    private Object content; //내용 VO

    @Builder
    public CommonVO(String code, String msg, Object content) {
        this.code = code;
        this.msg = msg;
        this.content = content;
    }
}
