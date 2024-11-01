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
    ADMIN("admin", "관리자");

    private final String role;
    private final String msg;
}
