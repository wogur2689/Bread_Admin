package com.example.bread.web.log.aspect;

import com.example.bread.web.log.dto.LogDto;
import com.example.bread.web.log.entity.LogEntity;
import com.example.bread.web.log.entity.LogLevel;
import com.example.bread.web.log.reposiory.LogRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class LoggableAspect {
    private final LogRepository logRepository;

    @Around("@annotation(com.example.bread.web.log.annotation.Loggable)")
    public Object logError(ProceedingJoinPoint joinPoint) {
        try {
            return joinPoint.proceed(); //정상 수행
        } catch (Throwable ex) {
            // 예외 발생 시 로그 저장
            LogDto.LogRequestDto dto = LogDto.LogRequestDto.builder()
                    .logType(String.valueOf(LogLevel.ERROR))
                    .logName(ex.getClass().getSimpleName())
                    .contents(ex.getMessage())
                    .build();
            LogEntity logEntity = LogEntity.toEntity(dto);
            logRepository.save(logEntity);
            return null;
        }
    }
}
