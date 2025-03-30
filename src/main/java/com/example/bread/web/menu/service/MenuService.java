package com.example.bread.web.menu.service;

import com.example.bread.common.exception.CustomException;
import com.example.bread.common.util.CommonCode;
import com.example.bread.web.menu.dto.MenuDto;
import com.example.bread.web.menu.entity.MenuEntity;
import com.example.bread.web.menu.repository.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MenuService {
    private final MenuRepository menuRepository;
    private final MenuService self; // 자기 자신을 주입하여 트랜잭션 적용

    public MenuService(@Lazy MenuService self, @Lazy MenuRepository menuRepository) { //지연 로딩 사용
        this.menuRepository = menuRepository;
        this.self = self;
    }

    @Transactional(readOnly = true)
    public List<MenuDto.MenuResponseDto> list() {
        //1. 메뉴 조회
        List<MenuEntity> rootMenus = menuRepository.findAll(); // 최상위 메뉴(GNB) 조회

        //2. entity -> res
        return rootMenus.stream().map(MenuDto::toDto).collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Exception.class)
    public String insert(MenuDto.MenuRequestDto menuDto) {
        String code = CommonCode.CODE_0000.getCode();
        try {
            //1. dto -> entity
            MenuEntity menu = MenuEntity.toEntity(menuDto);

            //2. save
            menuRepository.save(menu);
        } catch (DataAccessException e) {
            throwError(CommonCode.CODE_9998.getCode());
        }
        return code;
    }

    @Transactional(rollbackFor = Exception.class)
    public String update(MenuDto.MenuRequestDto menuDto) {
        String code = CommonCode.CODE_0000.getCode();
        try {
            //1. 기존 메뉴 조회
            MenuEntity targetMenu = getMenu(menuDto.getId());
            if(targetMenu == null) {
                throwError(CommonCode.CODE_9997.getCode());
                return code;
            }

            //2. 변경감지를 이용한 기존데이터 값 수정
            targetMenu.update(menuDto);
        } catch (DataAccessException e) {
            throwError(CommonCode.CODE_9998.getCode());
        }
        return code;
    }

    @Transactional(rollbackFor = Exception.class)
    public String delete(MenuDto.MenuRequestDto menuDto) {
        String code = CommonCode.CODE_0000.getCode();
        try {
            //1. 기존 메뉴 조회
            MenuEntity targetMenu = getMenu(menuDto.getId());
            if(targetMenu == null) {
                throwError(CommonCode.CODE_9997.getCode());
            }

            //2. 기존메뉴를 이용하여 삭제
            menuRepository.delete(targetMenu);
        } catch (DataAccessException e) {
            throwError(CommonCode.CODE_9998.getCode());
        }
        return code;
    }

    //메뉴 조회
    public MenuEntity getMenu(Long id) {
        return menuRepository.findById(id).orElse(null);
    }

    //에러처리
    private void throwError(String code) {
        throw new CustomException(code, CommonCode.getMessage(code));
    }
}
