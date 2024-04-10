package com.example.bread.config;

import com.example.bread.config.handler.LoginFailureHandler;
import com.example.bread.config.handler.LoginSuccessHandler;
import com.example.bread.config.handler.LogoutCustomHandler;
import com.example.bread.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //웹 보안 활성화
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    /**
     * Securtity 설정
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //1단계 보안 검사
        http.csrf(AbstractHttpConfigurer::disable); //csrf보호(지금은 사용안함)
        http.authorizeHttpRequests(request ->
                request
                        .requestMatchers("/css", "/js", "/img")//개발을 위해 잠시 모두 해제
                        .permitAll() //해당 경로는 보안검사 없음.
                        .anyRequest()
                        .authenticated() //나머진 모두 보안검사
        );
        //2단계 로그인 폼 설정
        http.formLogin(login ->
                login
                        .loginPage("/login") //사용자 정의 로그인 페이지
                        .loginProcessingUrl("/login-processing") //로그인 form action Url
                        .defaultSuccessUrl("/") //성공시 메인페이지로 이동
                        .usernameParameter("username") //id 파라미터
                        .passwordParameter("password") //password 파라미터
                        .successHandler(new LoginSuccessHandler()) //로그인 성공 핸들러
                        .failureHandler(new LoginFailureHandler()) //로그인 실패 핸들러
                        .permitAll() //로그인 페이지 접근 권한 승인
        );
        //3단계 로그아웃 설정
        http.logout(logout ->
                logout
                        .deleteCookies("JSESSIONID","remember-me") //로그아웃시 쿠키 삭제
                        .addLogoutHandler(new LogoutCustomHandler()) //로그아웃 핸들러
                        .permitAll()
        );
        //4단계 인증 절차
        http.authenticationProvider(new LoginProvider(customUserDetailsService, getPasswordEncoder()));
        return http.build();
    }

    /**
     * 패스워드 인코더
     */
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

