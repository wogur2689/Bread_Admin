package com.example.bread.web.user.service.handler;

import com.example.bread.common.util.CommonCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 로그인 실패시 로그인 페이지에 에러 메세지 전송.
 */
@Slf4j
public class LoginFailureHandler implements AuthenticationFailureHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        String code = CommonCode.CODE_0000.getCode();
        if (exception instanceof UsernameNotFoundException) {
            code = CommonCode.CODE_1000.getCode();
        }
        if (exception instanceof BadCredentialsException) {
            code = CommonCode.CODE_1001.getCode();
        }
        if (exception instanceof LockedException) {
            code = CommonCode.CODE_1002.getCode();
        }
        if (exception instanceof DisabledException) {
            code = CommonCode.CODE_1003.getCode();
        }

        //로그인 화면으로 이동
        response.sendRedirect("/login");
    }
}
