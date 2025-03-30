package com.example.bread.web.menu.dto;


import com.example.bread.web.menu.entity.MenuEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

public class MenuDto {
    @Getter
    @ToString
    @AllArgsConstructor
    public static class MenuRequestDto {
        private Long id;            //메뉴ID

        @NotBlank
        private String menuName;    //메뉴명

        @NotBlank
        private String menuUrl;     //메뉴url

        @NotBlank
        private String menuLevel;   //메뉴 level

        @NotBlank
        private String menuRole;    //메뉴권한

        @NotBlank
        private String isVisible;   //메뉴 표시 여부

        @NotBlank
        private Integer sortOrder;  //정렬 순서

        private String menuDesc;    //메뉴설명

        private Long parentId;      //메뉴 부모 ID
    }

    @Getter
    @Builder
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MenuResponseDto {
        private Long id;           //메뉴키
        private String menuName;   //메뉴명
        private String menuUrl;    //메뉴url
        private String menuLevel;  //메뉴 level
        private String menuRole;   //메뉴권한
        private String menuDesc;   //메뉴설명
        private String isVisible;  //메뉴 표시 여부
        private Integer sortOrder; //정렬 순서
        private Long parentId;     //메뉴 부모 ID
    }

    //entity -> dto
    public static MenuResponseDto toDto(MenuEntity menu) {
       return MenuResponseDto.builder()
               .id(menu.getId())
               .menuName(menu.getMenuName())
               .menuUrl(menu.getMenuUrl())
               .menuDesc(menu.getMenuDesc())
               .menuLevel(menu.getMenuLevel())
               .menuRole(String.valueOf(menu.getMenuRole()))
               .isVisible(menu.getIsVisible())
               .sortOrder(menu.getSortOrder())
               .parentId(menu.getParentId())
               .build();
    }
}
