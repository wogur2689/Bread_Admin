package com.example.bread.web.menu.entity;

import com.example.bread.common.entity.TimeEntity;
import com.example.bread.web.menu.dto.MenuDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Table(name = "menu")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MenuEntity extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "menu_name")
    private String menuMame;        //메뉴명

    @Column(name = "menu_url")
    private String menuUrl;         //메뉴 url

    @Column(name = "menuRole")
    private String menuRole;        //접근권한 (기본은 guest)

    public static MenuEntity toEntity(MenuDto menuDto) {
        return MenuEntity.builder()
                .menuMame(menuDto.getMenuMame())
                .menuUrl(menuDto.getMenuUrl())
                .menuRole(menuDto.getMenuRole())
                .build();
    }
}
