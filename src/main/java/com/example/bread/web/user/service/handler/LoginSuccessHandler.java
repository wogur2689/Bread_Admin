package com.example.bread.web.user.service.handler;

import com.example.bread.web.user.dto.LoginDto;
import com.example.bread.web.user.util.Role;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

/**
 * 로그인 성공시 세션 생성
 */
@Slf4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        //1. 세션 초기화
        HttpSession session = request.getSession(false);

        try {
            //2. id 추출
            String userId = authentication.getPrincipal().toString();

            //3. 유저 정보 세팅
            LoginDto loginDto = LoginDto.builder()
                    .userId(userId)
                    .role(Role.USER.name())
                    .build();

            //4. 유저정보 세션에 저장 후 세션 지속시간 설정(60분)
            session.setAttribute("UserInfo", loginDto);
            session.setMaxInactiveInterval(3600);
        } catch (Exception e) {
            log.error("### error : {} ###", e.getMessage());
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"시스템 에러입니다. 다시 시도해주세요.");
        }
        //로그인 성공후 메인으로 이동
        response.sendRedirect(request.getContextPath() + "/");
    }
}
