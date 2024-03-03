package com.example.bread.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //cors
//        http.csrf().disable()
//                .headers().frameOptions().disable();
//
//        //세션 생성
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
        //페이지 인증설정(일단은 전부 해제
        http.authorizeHttpRequests(request -> request.requestMatchers("/**").permitAll());
//
//        //로그인 폼
//        http.formLogin().disable();
//
//        // api
//        http.httpBasic().disable();

        return http.build();
    }
}
