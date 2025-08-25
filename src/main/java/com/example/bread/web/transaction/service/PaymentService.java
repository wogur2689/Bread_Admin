package com.example.bread.web.transaction.service;

import com.example.bread.common.util.CommonCode;
import com.example.bread.web.log.annotation.Loggable;
import com.example.bread.web.payment.dto.PaymentDto;
import com.example.bread.web.payment.entity.PaymentEntity;
import com.example.bread.web.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Loggable
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    @Transactional(readOnly = true)
    public Page<PaymentEntity> list(int page) {
        Pageable pageable = PageRequest.of(page - 1, 10, Sort.by(Sort.Direction.DESC, "createdAt"));
        return paymentRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public PaymentEntity view(Long id) {
        return paymentRepository.findById(id).orElseThrow();
    }

    public String insert(PaymentDto.PaymentRequestDto paymentDto) {
        String code = CommonCode.CODE_0000.getCode();
        try {
            PaymentEntity Payment = PaymentEntity.toEntity(paymentDto);
            paymentRepository.save(Payment);
        } catch (DataAccessException | NullPointerException e) {
            code = "9999";
        }
        return code;
    }

    public String update(PaymentDto.PaymentRequestDto paymentDto) {
        String code = CommonCode.CODE_0000.getCode();
        try {
            PaymentEntity Payment = PaymentEntity.toEntity(paymentDto);
            paymentRepository.save(Payment);
        } catch (DataAccessException | NullPointerException e) {
            code = "9999";
        }
        return code;
    }

    public String delete(PaymentDto.PaymentRequestDto paymentDto) {
        String code = CommonCode.CODE_0000.getCode();
        try {
            PaymentEntity Payment = PaymentEntity.toEntity(paymentDto);
            paymentRepository.delete(Payment);
        } catch (DataAccessException | NullPointerException e) {
            code = "9999";
        }
        return code;
    }
}
