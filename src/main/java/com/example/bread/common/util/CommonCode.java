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
    CODE_0001("0001", "파라미터 검증 필요"),
    CODE_0002("0002", "시간 초과"),
    CODE_0003("0003", "네트워크 에러"),
    CODE_0004("0004", "시스템 에러"),
    CODE_0005("0005", "기타 에러"),

    //user 1000 ~ 1999
    CODE_1000("1000", "존재하지 않는 유저입니다."),
    CODE_1001("1001", "비밀번호가 틀렸습니다."),
    CODE_1002("1002", "계정이 잠겼습니다."),
    CODE_1003("1003", "계정이 잠겼습니다."),

    CODE_9999("9999", "시스템 에러");

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
