package com.example.bread.web.user.service;

import com.example.bread.web.user.entiry.UsersEntity;
import com.example.bread.web.user.repository.UsersRepository;
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
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    /**
     * 유저 목록 반환(추후 페이징 적용)
     */
    public Page<UsersEntity> getUserList(int page) {
        Pageable pageable = PageRequest.of(page - 1, 10, Sort.by(Sort.Direction.DESC, "createdAt"));
        return usersRepository.findAll(pageable);
    }
}
