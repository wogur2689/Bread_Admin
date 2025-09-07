package com.example.bread.web.product.entity;

import com.example.bread.common.entity.TimeEntity;
import com.example.bread.web.product.dto.ProductDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Table(name = "product")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductEntity extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;        //상품명

    @Column(name = "price")
    private Long price;         //가격

    @Column(name = "image_url")
    private String imageUrl;    //이미지 경로

    @Column(name = "desc")
    private String desc;    //상세설명

    //dto -> entity
    public static ProductEntity toEntity(ProductDto.ProductRequestDto productDto) {
        return ProductEntity.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .imageUrl(productDto.getImageUrl())
                .desc(productDto.getDesc())
                .build();
    }
}
