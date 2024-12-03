package com.example.bread.common.dto;

import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class SearchDto {
    private int page;
    private int recordSize;
    private int pageSize;
    private String startDate;
    private String endDate;
    private String keyWord;
}