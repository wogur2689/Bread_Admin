package com.example.bread.web.user.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 권한
 */
@Getter
@AllArgsConstructor
public enum Role {
    USER,
    BRANCH,
    ADMIN
    /**
     * (User) 사용자 = 빵을 구매하는 사람
     * (Branch) 점장 = 빵을 판매하는 사람
     * (Admin) 관리자 = 시스템을 관리하는 사람
     */
}
