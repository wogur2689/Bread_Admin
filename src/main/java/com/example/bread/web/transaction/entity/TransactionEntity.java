package com.example.bread.web.transaction.entity;

import com.example.bread.common.entity.TimeEntity;
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

    @Column(name = "orderId")
    private String orderId;        //주문ID

    @Column(name = "orderNo")
    private String orderNo;        //주문번호

    @Column(name = "name")
    private String name;           //상품명

    @Column(name = "totalAmt")
    private Long totalAmt;         //총금액

    @Column(name = "amt")
    private Long amt;              //결제한 금액

    @Column(name = "cnt")
    private Integer cnt;           //수량
}
