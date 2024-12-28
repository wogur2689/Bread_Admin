package com.example.bread.common.dto;

import lombok.Getter;

@Getter
public class PagingDto {
    private Integer page;   //page
    private Integer size;   //size

    public PagingDto() {
        page = 5;
        size = 5;
    }
}
