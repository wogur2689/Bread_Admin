package com.example.bread.common.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private final String code;
    private final String msg;

    public CustomException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
