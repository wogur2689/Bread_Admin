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

    @Column(name = "subject", nullable = false, length = 50)
    private String subject;     //제목

    @Column(name = "contents", nullable = false)
    private String contents;    //내용

    //dto -> entity
    public static BoardEntity toEntity(BoardDto.BoardRequestDto boardDto) {
        return BoardEntity.builder()
                .id(boardDto.getId())
                .subject(boardDto.getSubject())
                .contents(boardDto.getContents())
                .build();
    }

    //변경 감지를 통한 업데이트
    public void update(BoardDto.BoardRequestDto boardDto){
        this.subject = boardDto.getSubject();
        this.contents = boardDto.getContents();
    }
}
