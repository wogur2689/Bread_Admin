package com.example.bread.web.log.service;

import com.example.bread.web.log.entity.LogEntity;
import com.example.bread.web.log.reposiory.LogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class LogService {
    private final LogRepository logRepository;

    public Page<LogEntity> list(int page) {
        Pageable pageable = PageRequest.of(page - 1, 10, Sort.by(Sort.Direction.DESC, "createdAt"));
        return logRepository.findAll(pageable);
    }

    public LogEntity view(Long id) {
        return logRepository.findById(id).orElseThrow();
    }
}
