package com.example.bread.web.user.dto;

/**
 * 기본 로그인 dto
 */
public record LoginDto (
    String userId,  //userID
    String role     //role
) {}
