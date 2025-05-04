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

        @NotBlank(message = "메뉴명을 입력해주세요.")
        private String menuName;    //메뉴명

        @NotBlank(message = "메뉴 URL을 입력해주세요.")
        private String menuUrl;     //메뉴url

        @NotBlank(message = "메뉴 level을 입력해주세요.")
        private String menuLevel;   //메뉴 level

        @NotBlank(message = "메뉴권한을 입력해주세요.")
        private String menuRole;    //메뉴권한

        @NotBlank(message = "메뉴 표시여부를 선택해주세요.")
        private String isVisible;   //메뉴 표시 여부

        @NotBlank(message = "정렬순서를 입력해주세요.")
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
               .menuRole(menu.getMenuRole())
               .isVisible(menu.getIsVisible())
               .sortOrder(menu.getSortOrder())
               .parentId(menu.getParentId())
               .build();
    }
}
