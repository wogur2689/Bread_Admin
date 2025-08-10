package com.example.bread.web.payment.dto;

import com.example.bread.web.payment.entity.PaymentEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

public class PaymentDto {
    @Getter
    @ToString
    @AllArgsConstructor
    public static class PaymentRequestDto {
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
    public static class PaymentResponseDto {
        private Long id;            //상품ID
        private String name;        //상품명
        private String imageUrl;    //이미지url
        private Long price;         //가격
    }

    //entity -> dto
    public static PaymentResponseDto toDto(PaymentEntity payment) {
        return PaymentResponseDto.builder()
                .name(payment.getName())
                .imageUrl(payment.getImageUrl())
                .price(payment.getPrice())
                .build();
    }
}
