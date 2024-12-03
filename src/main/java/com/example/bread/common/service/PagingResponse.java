package com.example.bread.common.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class PagingResponse<T> {
    private final List<T> list = new ArrayList<>();
    private final PagingService pagingService;

    public PagingResponse(List<T> list, PagingService pagingService) {
        this.pagingService = pagingService;
        this.list.addAll(list);
    }
}
