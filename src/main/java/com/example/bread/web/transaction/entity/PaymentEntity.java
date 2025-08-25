package com.example.bread.web.transaction.entity;

import com.example.bread.common.entity.TimeEntity;
import com.example.bread.web.payment.dto.PaymentDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Table(name = "payment")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PaymentEntity extends TimeEntity {
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
    public static PaymentEntity toEntity(PaymentDto.PaymentRequestDto paymentDto) {
        return PaymentEntity.builder()
                .name(paymentDto.getName())
                .price(paymentDto.getPrice())
                .imageUrl(paymentDto.getImageUrl())
                .build();
    }
}
