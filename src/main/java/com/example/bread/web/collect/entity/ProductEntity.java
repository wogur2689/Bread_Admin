package com.example.bread.web.collect.entity;

import com.example.bread.common.entity.TimeEntity;
import com.example.bread.web.menu.dto.MenuDto;
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
}
