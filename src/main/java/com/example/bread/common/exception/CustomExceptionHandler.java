package com.example.bread.common.exception;

import com.example.bread.common.dto.CommonDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CommonDto> handleCustomException(CustomException ex) {
        return ResponseEntity.status(500).body(new CommonDto(ex.getCode(), ex.getMsg(), null));
    }
}
