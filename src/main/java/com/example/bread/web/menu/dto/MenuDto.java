package com.example.bread.web.menu.dto;


import com.example.bread.web.menu.entity.MenuEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MenuDto {
    @Getter
    @AllArgsConstructor
    public static class MenuRequestDto {
        @NotBlank
        private String menuName; //메뉴명

        @NotBlank
        private String menuUrl;  //메뉴url

        @NotBlank
        private String menuRole; //메뉴권한

        @NotBlank
        private String isVisible;//메뉴 표시 여부

        @NotBlank
        private String sortOrder;//정렬 순서

        private String parentId; //메뉴 부모 ID
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MenuResponseDto {
        private Long id;           //메뉴키
        private String menuName;   //메뉴명
        private String menuUrl;    //메뉴url
        private String menuRole;   //메뉴권한
        private String isVisible;  //메뉴 표시 여부
        private Integer sortOrder; //정렬 순서
        private Long parent;       //메뉴 부모 ID
    }

    //entity -> dto
    public static MenuResponseDto toDto(MenuEntity menu) {
       return MenuResponseDto.builder()
               .id(menu.getId())
               .menuName(menu.getMenuName())
               .menuUrl(menu.getMenuUrl())
               .menuRole(String.valueOf(menu.getMenuRole()))
               .isVisible(menu.getIsVisible())
               .sortOrder(menu.getSortOrder())
               .parent(menu.getParent() != null ? menu.getParent().getId() : null)
               .build();
    }
}
