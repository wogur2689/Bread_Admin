package com.example.bread.web.user.service;

import com.example.bread.web.user.entiry.Users;
import com.example.bread.web.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    /**
     * 유저 목록 반환(추후 페이징 적용)
     */
    public List<Users> getUserList() {
        return userRepository.findAll();
    }
}
