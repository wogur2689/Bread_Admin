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

    @Column(name = "log_type", nullable = false, length = 50)
    private String logType;     //로그 타입 (info, error)

    @Column(name = "logName", nullable = false, length = 50)
    private String logName;     //로그명

    @Column(name = "contents", nullable = false)
    private String contents;    //내용

    //dto -> entity
    public static LogEntity toEntity(LogDto.LogRequestDto logDto) {
        return LogEntity.builder()
                .logType(logDto.getLogType())
                .logName(logDto.getLogName())
                .contents(logDto.getContents())
                .build();
    }
}
