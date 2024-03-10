package com.example.bread.dto;

import lombok.*;

/**
 * 기본 로그인 dto
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginDto {
    private String userId;                       //userID
    private String role;                         //role
}
