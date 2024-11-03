package com.example.bread.web.menu.service;

import com.example.bread.web.menu.dto.MenuDto;
import com.example.bread.web.menu.entity.MenuEntity;
import com.example.bread.web.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    public List<MenuEntity> getMenuList() {
        return menuRepository.findAll();
    }
    public MenuEntity getMenu(Long id) {
        Optional<MenuEntity> opt = menuRepository.findById(id);
        return opt.orElse(null);
    }

    public void insertMenu(MenuDto menuDto) {
        menuRepository.save(MenuEntity.toEntity(menuDto));
    }

    public void updateMenu(MenuDto menuDto) {
        menuRepository.save(MenuEntity.toEntity(menuDto));
    }

    public void deleteMenu(MenuDto menuDto) {
        menuRepository.delete(MenuEntity.toEntity(menuDto));
    }
}
