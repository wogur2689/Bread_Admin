package com.example.bread.web.menu.entity;

import com.example.bread.common.entity.TimeEntity;
import com.example.bread.web.menu.dto.MenuDto;
import com.example.bread.web.user.util.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "menu_name", nullable = false, length = 100)
    private String menuName;            //메뉴명

    @Column(name = "parent_id")
    private Long parentId;              // 부모 메뉴 ID (NULL이면 최상위 GNB)

    @Column(name = "menu_level")
    private String menuLevel;           // 메뉴 레벨 (숫자가 낮을수록 최상위)

    @Column(name = "menu_url", nullable = false, length = 512)
    private String menuUrl;             //메뉴 url

    @Column(name = "menu_desc", length = 200)
    private String menuDesc;            //메뉴설명

    @Column(nullable = false)
    private Integer sortOrder = 0;      // 메뉴 정렬 순서

    @Column(nullable = false, length = '1', columnDefinition = "N")
    private String isVisible;           // 메뉴 표시 여부

    @Column(nullable = false)
    private String menuRole;            // 접근 권한 설정

    //변경감지
    public void update(MenuDto.MenuRequestDto dto) {
        this.menuName = dto.getMenuName();
        this.menuUrl = dto.getMenuUrl();
        this.menuDesc = dto.getMenuDesc();
        this.sortOrder = dto.getSortOrder();
        this.isVisible = dto.getIsVisible();
        this.menuRole = dto.getMenuRole();
    }

    //dto -> entity
    public static MenuEntity toEntity(MenuDto.MenuRequestDto menuDto) {
        return MenuEntity.builder()
                .menuName(menuDto.getMenuName())
                .menuUrl(menuDto.getMenuUrl())
                .menuRole(menuDto.getMenuRole())
                .menuLevel(menuDto.getMenuLevel())
                .sortOrder(menuDto.getSortOrder())
                .isVisible(menuDto.getIsVisible())
                .menuDesc(menuDto.getMenuDesc())
                .parentId(menuDto.getParentId())
                .build();
    }
}
