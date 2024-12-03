package com.example.bread.common.service;

import com.example.bread.common.dto.PagingDto;
import com.example.bread.common.dto.SearchDto;
import org.springframework.stereotype.Service;

@Service
public class PagingService {
    public PagingDto pagination(int totalRecordCount, SearchDto params) {
        PagingDto pagingDto = null;
        if (totalRecordCount > 0) {
            pagingDto = calculation(totalRecordCount, params);
        }
        return pagingDto;
    }

    //페이징 계산
    private PagingDto calculation(int totalRecordCount, SearchDto params) {
        // 전체 페이지 수 계산
        int totalPageCount = ((totalRecordCount - 1) / params.getPageSize()) + 1;

        // 현재 페이지 번호가 전체 페이지 수보다 큰 경우, 현재 페이지 번호에 전체 페이지 수 저장
        int newPage = Math.min(params.getPage(), totalPageCount);

        // 첫 페이지 번호 계산
        int startPage = ((newPage - 1) / params.getPageSize()) * params.getPageSize() + 1;

        // 끝 페이지 번호 계산
        int endPage = startPage + params.getPageSize() - 1;

        // 끝 페이지가 전체 페이지 수보다 큰 경우, 끝 페이지 전체 페이지 수 저장
        endPage = Math.min(endPage, totalPageCount);

        // LIMIT 시작 위치 계산
        int limitStart = (newPage - 1) * params.getRecordSize();

        // 이전 페이지 존재 여부 확인
        boolean existPrevPage = startPage != 1;

        // 다음 페이지 존재 여부 확인
        boolean existNextPage = (endPage * params.getRecordSize()) < totalRecordCount;

        return PagingDto.builder()
                .totalRecordCount(totalRecordCount)
                .totalPageCount(newPage)
                .startPage(startPage)
                .endPage(endPage)
                .limitStart(limitStart)
                .existPrevPage(existPrevPage)
                .existNextPage(existNextPage)
                .build();
    }
}
