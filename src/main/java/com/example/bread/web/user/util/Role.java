package com.example.bread.web.user.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 권한
 */
@Getter
@AllArgsConstructor
public enum Role {
    USER("user", "사용자"),
    BRANCH("branch", "점장"),
    ADMIN("admin", "관리자");

    private final String role;
    private final String description;
    /**
     * 사용자 = 빵을 구매하는 사람
     * 점장 = 빵을 판매하는 사람
     * 관리자 = 시스템을 관리하는 사람
     */
}
