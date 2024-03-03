package com.example.bread.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MainVO implements Serializable {
    //로그인
    private String userId; //id
    private String password; //pw

    //메인

    //권한

    @Builder
    public MainVO(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
