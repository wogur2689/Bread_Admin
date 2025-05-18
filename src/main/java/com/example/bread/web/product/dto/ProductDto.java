package com.example.bread.web.product.dto;

import com.example.bread.web.product.entity.ProductEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

public class ProductDto {
    @Getter
    @ToString
    @AllArgsConstructor
    public static class ProductRequestDto {
        private Long id;            //상품ID

        @NotBlank(message = "상품명을 입력해주세요.")
        private String name;        //상품명

        @NotBlank(message = "이미지 URL을 입력해주세요.")
        private String imageUrl;    //이미지url

        @NotBlank(message = "가격을 입력해주세요.")
        private Long price;         //가격
    }

    @Getter
    @Builder
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductResponseDto {
        private Long id;            //상품ID
        private String name;        //상품명
        private String imageUrl;    //이미지url
        private Long price;         //가격
    }

    //entity -> dto
    public static ProductDto.ProductResponseDto toDto(ProductEntity product) {
        return ProductResponseDto.builder()
                .name(product.getName())
                .imageUrl(product.getImageUrl())
                .price(product.getPrice())
                .build();
    }
}
