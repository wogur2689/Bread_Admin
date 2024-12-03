package com.example.bread.common.dto;

import lombok.Builder;

@Builder
public record PagingDto(
        int totalRecordCount,     // 전체 데이터 수
        int totalPageCount,       // 전체 페이지 수
        int startPage,            // 첫 페이지 번호
        int endPage,              // 끝 페이지 번호
        int limitStart,           // LIMIT 시작 위치
        boolean existPrevPage,    // 이전 페이지 존재 여부
        boolean existNextPage     // 다음 페이지 존재 여부
) {}
