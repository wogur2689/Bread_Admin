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

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    public List<MenuEntity> list() {
        List<MenuEntity> rootMenus = menuRepository.findByParent(null); // 최상위 메뉴(GNB) 조회
        rootMenus.forEach(this::loadChildren); // 재귀적으로 자식 메뉴 로드
        return rootMenus;
    }

    private void loadChildren(MenuEntity menu) {
        List<MenuEntity> children = menuRepository.findByParent(menu);
        if (!children.isEmpty()) {
            menu.addChildren(children); // 🔥 커스텀 메서드 활용
            children.forEach(this::loadChildren);
        }
    }

    public String insert(MenuDto menuDto) {
        String code = CommonCode.CODE_0000.getCode();
        try {
            MenuEntity menu = MenuEntity.toEntity(menuDto);
            menuRepository.save(menu);
        } catch (DataAccessException e) {
            code = CommonCode.CODE_9998.getCode();
        }
        return code;
    }

    public String update(MenuDto menuDto) {
        String code = CommonCode.CODE_0000.getCode();
        try {
            MenuEntity menu = MenuEntity.toEntity(menuDto);
            menuRepository.save(menu);
        } catch (DataAccessException e) {
            code = CommonCode.CODE_9998.getCode();
        }
        return code;
    }

    public String delete(MenuDto menuDto) {
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
