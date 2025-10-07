package com.example.bread.web.transaction.entity;

import com.example.bread.common.entity.TimeEntity;
import com.example.bread.web.transaction.dto.TransactionDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Table(name = "transaction")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TransactionEntity extends TimeEntity {
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

    //dto -> entity
    public static TransactionEntity toEntity(TransactionDto.TransactionRequestDto transationDto) {
        return TransactionEntity.builder()
                .name(transationDto.getName())
                .price(transationDto.getPrice())
                .imageUrl(transationDto.getImageUrl())
                .build();
    }
}
