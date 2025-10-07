package com.example.bread.web.transaction.service;

import com.example.bread.common.util.CommonCode;
import com.example.bread.web.log.annotation.Loggable;
import com.example.bread.web.payment.dto.PaymentDto;
import com.example.bread.web.payment.entity.PaymentEntity;
import com.example.bread.web.payment.repository.PaymentRepository;
import com.example.bread.web.transaction.dto.TransactionDto;
import com.example.bread.web.transaction.entity.TransactionEntity;
import com.example.bread.web.transaction.repository.TransactionRepository;
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
public class TransactionService {
    private final TransactionRepository transactionRepository;

    @Transactional(readOnly = true)
    public Page<TransactionEntity> list(int page) {
        Pageable pageable = PageRequest.of(page - 1, 10, Sort.by(Sort.Direction.DESC, "createdAt"));
        return transactionRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public TransactionEntity view(Long id) {
        return transactionRepository.findById(id).orElseThrow();
    }

    public String insert(TransactionDto.TransactionRequestDto TransactionDto) {
        String code = CommonCode.CODE_0000.getCode();
        try {
            TransactionEntity transaction = TransactionEntity.toEntity(TransactionDto);
            transactionRepository.save(transaction);
        } catch (DataAccessException | NullPointerException e) {
            code = "9999";
        }
        return code;
    }

    public String update(TransactionDto.TransactionRequestDto transactionDto) {
        String code = CommonCode.CODE_0000.getCode();
        try {
            TransactionEntity transaction = TransactionEntity.toEntity(transactionDto);
            transactionRepository.save(transaction);
        } catch (DataAccessException | NullPointerException e) {
            code = "9999";
        }
        return code;
    }

    public String delete(TransactionDto.TransactionRequestDto transactionDto) {
        String code = CommonCode.CODE_0000.getCode();
        try {
            TransactionEntity Transaction = TransactionEntity.toEntity(transactionDto);
            transactionRepository.delete(Transaction);
        } catch (DataAccessException | NullPointerException e) {
            code = "9999";
        }
        return code;
    }
}
