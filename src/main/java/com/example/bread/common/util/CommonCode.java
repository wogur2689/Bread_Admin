package com.example.bread.common.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonCode {
    /**
     * api 통신 코드
     * 0000 ~ 9999
     */
    CODE_0000("0000", "성공"),

    //user 1000 ~ 1999
    CODE_1000("1000", "존재하지 않는 유저입니다."),
    CODE_1001("1001", "비밀번호가 틀렸습니다."),
    CODE_1002("1002", "계정이 잠겼습니다."),
    CODE_1003("1003", "계정이 잠겼습니다."),

    CODE_9995("9995", "파라미터 에러"),
    CODE_9996("9996", "네트워크 에러"),
    CODE_9997("9997", "NULL 에러"),
    CODE_9998("9998", "DB 에러"),
    CODE_9999("9999", "기타 에러");

    private final String code;
    private final String msg;

    public static String getMessage(String code) {
        if(code == null) {
            return "해당 코드는 없는 코드입니다.";
        }
        for(CommonCode codeValue : values()) {
            if(codeValue.getCode().equals(code)) {
                return codeValue.getMsg();
            }
        }
        return "해당 코드는 없는 코드입니다.";
    }
}
