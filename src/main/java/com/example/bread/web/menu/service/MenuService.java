package com.example.bread.web.menu.service;

import com.example.bread.common.exception.CustomException;
import com.example.bread.common.util.CommonCode;
import com.example.bread.web.board.dto.BoardDto;
import com.example.bread.web.board.entity.BoardEntity;
import com.example.bread.web.menu.dto.MenuDto;
import com.example.bread.web.menu.entity.MenuEntity;
import com.example.bread.web.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    public List<MenuDto.MenuResponseDto> list() {
        //1. 최상위 메뉴 조회
        List<MenuEntity> rootMenus = menuRepository.findByParent(null); // 최상위 메뉴(GNB) 조회

        //2. 재귀호출을 이용한 자식 메뉴 로드
        rootMenus.forEach(this::loadChildren); // 재귀적으로 자식 메뉴 로드

        //3. entity -> res
        List<MenuDto.MenuResponseDto> menuResponseDtos = new ArrayList<>();
        rootMenus.forEach(t -> {
            menuResponseDtos.add(MenuDto.toDto(t));
        });

        return menuResponseDtos;
    }

    private void loadChildren(MenuEntity menu) {
        List<MenuEntity> children = menuRepository.findByParent(menu);
        if (!children.isEmpty()) {
            menu.addChildren(children); // 🔥 커스텀 메서드 활용
            children.forEach(this::loadChildren);
        }
    }

    public String insert(MenuDto.MenuRequestDto menuDto) {
        String code = CommonCode.CODE_0000.getCode();
        try {
            MenuEntity menu = MenuEntity.toEntity(menuDto);
            menuRepository.save(menu);
        } catch (DataAccessException e) {
            code = CommonCode.CODE_9998.getCode();
        }
        return code;
    }

    public String update(MenuDto.MenuRequestDto menuDto) {
        String code = CommonCode.CODE_0000.getCode();
        try {
            MenuEntity menu = MenuEntity.toEntity(menuDto);
            menuRepository.save(menu);
        } catch (DataAccessException e) {
            code = CommonCode.CODE_9998.getCode();
        }
        return code;
    }

    public String delete(MenuDto.MenuRequestDto menuDto) {
        String code = CommonCode.CODE_0000.getCode();
        try {
            MenuEntity menu = MenuEntity.toEntity(menuDto);
            menuRepository.delete(menu);
        } catch (DataAccessException e) {
            code = CommonCode.CODE_9998.getCode();
        }
        return code;
    }
}
