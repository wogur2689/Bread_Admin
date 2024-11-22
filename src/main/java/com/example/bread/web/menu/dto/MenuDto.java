package com.example.bread.web.menu.dto;

import lombok.Builder;

@Builder
public record MenuDto (
    String menuMame,        //메뉴명
    String menuUrl,         //메뉴 url
    String menuRole         //접근권한 (기본은 guest)
){}
