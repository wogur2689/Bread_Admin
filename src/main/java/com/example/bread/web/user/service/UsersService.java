package com.example.bread.web.user.service;

import com.example.bread.web.user.entiry.UsersEntity;
import com.example.bread.web.user.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    /**
     * 유저 목록 반환(추후 페이징 적용)
     */
    public List<UsersEntity> getUserList() {
        return usersRepository.findAll();
    }
}
