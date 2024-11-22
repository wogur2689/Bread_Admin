package com.example.bread.web.user.dto;

import lombok.*;

/**
 * 기본 로그인 dto
 */
@Builder
public record LoginDto (
    String userId,  //userID
    String role     //role
) {}
