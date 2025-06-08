package com.example.bread.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseCommonDto {
    private LocalDateTime createdAt;    //작성일
    private LocalDateTime updatedAt;    //수정일
    private String createdBy;           //작성자
    private String updatedBy;           //수정자

    private String pageSize;            //갯수
    private String pageOffset;          //페이지 번호
    private String keyWord;             //키워드
}
