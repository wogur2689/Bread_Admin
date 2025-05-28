package com.example.bread.web.log.entity;

import com.example.bread.common.entity.TimeEntity;
import com.example.bread.web.log.dto.LogDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Table(name = "log_history")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LogEntity extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "subject", nullable = false, length = 50)
    private String subject;     //제목

    @Column(name = "contents", nullable = false)
    private String contents;    //내용

    //dto -> entity
    public static LogEntity toEntity(LogDto.LogRequestDto logDto) {
        return LogEntity.builder()
                .subject(logDto.getSubject())
                .contents(logDto.getContents())
                .build();
    }
}
