package com.example.bread.config;

import com.example.bread.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 인증 토큰 생성
 */
@Slf4j
@RequiredArgsConstructor
public class LoginProvider implements AuthenticationProvider {

    private final CustomUserDetailsService customUserDetailsService;

    private final PasswordEncoder passwordEncoder;

    //    @Resource
//    private LoginService loginService; //로그인 이력저장(고려중)
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //1. 입력받은 값에서 사용자 이름, 비밀번호 생성
        //log.info(authentication.getDetails().toString()); //WebAuthenticationDetails [RemoteIpAddress=0:0:0:0:0:0:0:1, SessionId=6B8D861708F03350B044E8FE743A227A]
        String username = authentication.getName(); //id
        String password = authentication.getCredentials().toString(); //password

        //2. db에서 사용자 이름, 비밀번호 가져오기
        UserDetails user = customUserDetailsService.loadUserByUsername(username);

        //3. 비밀번호가 맞는지 틀리는지 확인
        if(!passwordEncoder.matches(password, user.getPassword())) {
            log.error("### login param error userId : {}, password : {}", username, password);
            throw new BadCredentialsException("### 비밀번호가 틀렸습니다. ###");
        }

        //4. 토큰 생성
        return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

