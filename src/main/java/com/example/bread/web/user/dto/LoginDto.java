package com.example.bread.web.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 기본 로그인 dto
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    private String userId;  //userID
    private String role;    //role
}
