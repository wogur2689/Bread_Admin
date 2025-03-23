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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private MenuEntity parent;          // 부모 메뉴 (NULL이면 최상위 GNB)

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MenuEntity> children = new ArrayList<>(); // 자식 메뉴 목록

    @Column(name = "menu_url", nullable = false, length = 512)
    private String menuUrl;             //메뉴 url

    @Column(nullable = false)
    private Integer sortOrder = 0;      // 메뉴 정렬 순서

    @Column(nullable = false, length = '1', columnDefinition = "N")
    private String isVisible;           // 메뉴 표시 여부

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role menuRole = Role.USER; // 접근 권한 설정

    //children만 수정 메서드
    public void addChildren(List<MenuEntity> children) {
        this.children.addAll(children); // Setter 없이 추가 가능!
    }

    public static MenuEntity toEntity(MenuDto.MenuRequestDto menuDto) {
        return MenuEntity.builder()
                .menuName(menuDto.getMenuName())
                .menuUrl(menuDto.getMenuUrl())
                .menuRole(Role.valueOf(menuDto.getMenuRole()))
                .build();
    }
}
