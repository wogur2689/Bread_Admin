package com.example.bread.web.log.service;

import com.example.bread.common.util.CommonCode;
import com.example.bread.web.log.dto.LogDto;
import com.example.bread.web.log.entity.LogEntity;
import com.example.bread.web.log.reposiory.LogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
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

    public String insert(LogDto.LogRequestDto logDto) {
        String code = CommonCode.CODE_0000.getCode();
        try {
            LogEntity board = LogEntity.toEntity(logDto);
            logRepository.save(board);
        } catch (DataAccessException | NullPointerException e) {
            code = "9999";
        }
        return code;
    }

    public String update(LogDto.LogRequestDto logDto) {
        String code = CommonCode.CODE_0000.getCode();
        try {
            LogEntity board = LogEntity.toEntity(logDto);
            logRepository.save(board);
        } catch (DataAccessException | NullPointerException e) {
            e.printStackTrace();
            code = "9999";
        }
        return code;
    }

    public String delete(LogDto.LogRequestDto logDto) {
        String code = CommonCode.CODE_0000.getCode();
        try {
            LogEntity board = LogEntity.toEntity(logDto);
            logRepository.delete(board);
        } catch (DataAccessException | NullPointerException e) {
            e.printStackTrace();
            code = "9999";
        }
        return code;
    }
}
