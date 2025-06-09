package com.example.bread.web.log.dto;

import com.example.bread.web.log.entity.LogEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

public class LogDto {

    @Getter
    @ToString
    @Builder
    @AllArgsConstructor
    public static class LogRequestDto {
        private Long id;            //ID
        @NotBlank(message = "로그타입을 입력해주세요.")
        private String logType;     //로그 타입 (info, error)
        @NotBlank(message = "로그명을 입력해주세요.")
        private String logName;     //로그명
        @NotBlank(message = "내용을 입력해주세요.")
        private String contents;    //내용
    }

    @Getter
    @Builder
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LogResponseDto {
        private Long id;            //ID
        private String logType;     //로그 타입 (info, error)
        private String logName;     //로그명
        private String contents;    //내용
    }

    //entity -> dto
    public static LogResponseDto toDto(LogEntity log) {
        return LogResponseDto.builder()
                .id(log.getId())
                .logName(log.getLogName())
                .logType(log.getLogType())
                .contents(log.getContents())
                .build();
    }
}
