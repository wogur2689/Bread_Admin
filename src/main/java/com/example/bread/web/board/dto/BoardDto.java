package com.example.bread.web.board.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record BoardDto(
        Long id,
        String subject,
        String contents
)
{}
