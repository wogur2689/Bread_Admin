package com.example.bread.web.log.dto;

import com.example.bread.web.log.entity.LogEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

public class LogDto {

    @Getter
    @ToString
    @AllArgsConstructor
    public static class LogRequestDto {
        private Long id;            //ID

        @NotBlank(message = "제목을 입력해주세요.")
        private String subject;     //제목
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
        private String subject;     //제목
        private String contents;    //내용
    }

    //entity -> dto
    public static LogResponseDto toDto(LogEntity Log) {
        return LogResponseDto.builder()
                .id(Log.getId())
                .subject(Log.getSubject())
                .contents(Log.getContents())
                .build();
    }
}
