package com.example.bread.web.user.service.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;

/**
 * 로그인 실패시 로그인 페이지에 에러 메세지 전송.
 */
@Slf4j
public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        log.info("### error msg : {} ###", exception.getMessage());

        //로그인 화면으로 이동
        log.info("### login fail ###");
        response.sendRedirect("/login");
    }
}
