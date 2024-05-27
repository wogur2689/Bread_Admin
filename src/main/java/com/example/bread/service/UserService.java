package com.example.bread.service;

import com.example.bread.entity.Users;
import com.example.bread.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
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
