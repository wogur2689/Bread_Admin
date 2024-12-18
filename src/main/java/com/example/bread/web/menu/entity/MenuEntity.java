package com.example.bread.web.menu.entity;

import com.example.bread.common.entity.TimeEntity;
import com.example.bread.web.menu.dto.MenuDto;
import jakarta.persistence.*;
import lombok.*;

/**
 * 사용자 메뉴 관리
 */
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

    @Column(name = "menu_name", nullable = false, length = 50)
    private String menuMame;        //메뉴명

    @Column(name = "menu_url", nullable = false)
    private String menuUrl;         //메뉴 url

    @Column(name = "menuRole", nullable = false, length = 20)
    private String menuRole;        //접근권한 (기본은 guest)

    public static MenuEntity toEntity(MenuDto menuDto) {
        return MenuEntity.builder()
                .menuMame(menuDto.menuMame())
                .menuUrl(menuDto.menuUrl())
                .menuRole(menuDto.menuRole())
                .build();
    }
}
