package com.example.bread.common.dto;

import lombok.*;

@Getter
@ToString
@AllArgsConstructor
public class SearchDto {
    private int page;
    private int recordSize;
    private int pageSize;
    private String startDate;
    private String endDate;
    private String keyword;

    public SearchDto() {
        this.page = 1;
        this.recordSize = 15;
        this.pageSize = 1;
    }
}