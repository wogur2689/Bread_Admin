package com.example.bread.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.Principal;
import java.util.Optional;

@Slf4j
@Configuration
public class AuditorAwareConfig implements AuditorAware<String> {

    /**
     * 생성자 및 수정자 추적 설정
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        /**
         * SecurityContext 에서 인증정보를 가져와 주입.
         */
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(authentication -> authentication.getPrincipal().toString());
    }
}
