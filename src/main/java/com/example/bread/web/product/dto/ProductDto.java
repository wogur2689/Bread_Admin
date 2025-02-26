package com.example.bread.web.product.dto;

public record ProductDto (
    Long id,
    String name,        //상품명
    Long price,         //가격
    String imageUrl     //이미지 경로
){}