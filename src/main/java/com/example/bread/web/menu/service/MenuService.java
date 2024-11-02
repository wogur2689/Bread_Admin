package com.example.bread.web.menu.service;

import com.example.bread.web.menu.entity.MenuEntity;
import com.example.bread.web.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;
    public List<MenuEntity> getMenuList() {
        return menuRepository.findAll();
    }
}
