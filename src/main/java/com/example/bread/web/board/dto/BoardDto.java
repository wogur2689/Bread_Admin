package com.example.bread.web.board.dto;

import com.example.bread.web.board.entity.BoardEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

public class BoardDto {

    @Getter
    @ToString
    @AllArgsConstructor
    public static class BoardRequestDto {
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
    public static class BoardResponseDto {
        private Long id;            //ID
        private String subject;     //제목
        private String contents;    //내용
    }

    //entity -> dto
    public static BoardResponseDto toDto(BoardEntity board) {
        return BoardResponseDto.builder()
                .id(board.getId())
                .subject(board.getSubject())
                .contents(board.getContents())
                .build();
    }
}
