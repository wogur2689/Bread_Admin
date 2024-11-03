package com.example.bread.web.menu.controller;

import com.example.bread.web.menu.dto.MenuDto;
import com.example.bread.web.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;
    /**
     * 메뉴 목록 반환
     */
    @GetMapping("/list")
    public ModelAndView getMenuList(ModelAndView mav) {
        mav.addObject("menuList", menuService.getMenuList());
        mav.setViewName("jsonView");
        return mav;
    }

    /**
     * 메뉴 관리 화면
     */
    @GetMapping("/menuManage")
    public ModelAndView menuManage(ModelAndView mav) {
        mav.addObject("menuList", menuService.getMenuList());
        mav.setViewName("menu/list");
        return mav;
    }

    /**
     * 메뉴 관리 상세
     */
    @GetMapping("/menuManage/{id}")
    public ModelAndView menuManage(@PathVariable Long id, ModelAndView mav) {
        mav.addObject("menuData", menuService.getMenu(id));
        mav.setViewName("menu/view");
        return mav;
    }

    /**
     * 메뉴 생성 폼
     */
    @GetMapping("/menuManage/menuWrite")
    public ModelAndView menuWrite(ModelAndView mav) {
        mav.setViewName("menu/write");
        return mav;
    }

    /**
     * 메뉴 수정 폼
     */
    @GetMapping("/menuManage/menuEdit")
    public ModelAndView menuEdit(ModelAndView mav) {
        mav.setViewName("menu/edit");
        return mav;
    }

    /**
     * 메뉴 생성
     */
    @PostMapping("/menuCreate")
    public ModelAndView menuCreate(ModelAndView mav, MenuDto menuDto) {
        menuService.insertMenu(menuDto);
        mav.setViewName("jsonView");
        return mav;
    }

    /**
     * 메뉴 수정
     */
    @PostMapping("/menuUpdate")
    public ModelAndView menuUpdate(ModelAndView mav, MenuDto menuDto) {
        menuService.updateMenu(menuDto);
        mav.setViewName("jsonView");
        return mav;
    }

    /**
     * 메뉴 삭제
     */
    @PostMapping("/menuDelete")
    public ModelAndView menuDelete(ModelAndView mav, MenuDto menuDto) {
        menuService.deleteMenu(menuDto);
        mav.setViewName("jsonView");
        return mav;
    }
}
