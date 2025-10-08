package com.example.bread.web.payment.service;

import com.example.bread.web.log.annotation.Loggable;
import com.example.bread.web.payment.entity.PaymentEntity;
import com.example.bread.web.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
}
