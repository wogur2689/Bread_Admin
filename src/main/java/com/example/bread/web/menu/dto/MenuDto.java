package com.example.bread.web.menu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuDto {
    private String menuMame;        //메뉴명
    private String menuUrl;         //메뉴 url
    private String menuRole;        //접근권한 (기본은 guest)
}
