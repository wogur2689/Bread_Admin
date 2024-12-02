package com.example.bread.web.board.entity;

import com.example.bread.common.entity.TimeEntity;
import com.example.bread.web.board.dto.BoardDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Table(name = "board")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardEntity extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "subject")
    private String subject;     //제목

    @Column(name = "contents")
    private String contents;    //내용

    //dto -> entity
    public static BoardEntity toEntity(BoardDto boardDto) {
        return BoardEntity.builder()
                .subject(boardDto.subject())
                .contents(boardDto.contents())
                .build();
    }
}
