package com.example.bread.web.product.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductDto {
    private Long id;
    private String name;        //상품명
    private Long price;         //가격
    private String imageUrl;    //이미지 경로
}
