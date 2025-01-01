package com.example.bread.common.dto;

import lombok.*;

@Getter
public class PagingDto {
    private int page; //page
    private int size;
    public PagingDto() {
        this.page = 1;
        this.size = 10;
    }
}
