package com.example.bread.common.dto;

import lombok.Builder;

@Builder
public record PagingDto(
        Integer page,
        Integer size
) {
}
