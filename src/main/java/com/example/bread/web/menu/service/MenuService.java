package com.example.bread.web.menu.service;

import com.example.bread.common.util.CommonCode;
import com.example.bread.web.board.dto.BoardDto;
import com.example.bread.web.board.entity.BoardEntity;
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

    public List<MenuEntity> list() {
        return menuRepository.findAll();
    }
    public MenuEntity view(Long id) {
        return menuRepository.findById(id).orElseThrow();
    }

    public String insert(MenuDto menuDto) {
        String code = CommonCode.CODE_0000.getCode();
        try {
            MenuEntity menu = MenuEntity.toEntity(menuDto);
            menuRepository.save(menu);
        } catch (Exception e) {
            e.printStackTrace();
            code = "9999";
        }
        return code;
    }

    public String update(MenuDto menuDto) {
        String code = CommonCode.CODE_0000.getCode();
        try {
            MenuEntity menu = MenuEntity.toEntity(menuDto);
            menuRepository.save(menu);
        } catch (Exception e) {
            e.printStackTrace();
            code = "9999";
        }
        return code;
    }

    public String delete(MenuDto menuDto) {
        String code = CommonCode.CODE_0000.getCode();
        try {
            MenuEntity menu = MenuEntity.toEntity(menuDto);
            menuRepository.delete(menu);
        } catch (Exception e) {
            e.printStackTrace();
            code = "9999";
        }
        return code;
    }
}
