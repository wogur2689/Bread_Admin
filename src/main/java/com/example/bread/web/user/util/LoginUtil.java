package com.example.bread.web.user.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class LoginUtil {

    /**
     * 로그인 체크
     */
    public static boolean isLogin() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth != null;
    }
}
