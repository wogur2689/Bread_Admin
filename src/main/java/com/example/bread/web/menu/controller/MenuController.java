package com.example.bread.web.menu.controller;

import com.example.bread.web.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
}
