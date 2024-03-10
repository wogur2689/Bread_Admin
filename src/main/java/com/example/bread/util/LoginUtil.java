package com.example.bread.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class LoginUtil {

    /**
     * 로그인 체크
     */
    public static boolean isLogin() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth == null) return false;
        return true;
    }
}
