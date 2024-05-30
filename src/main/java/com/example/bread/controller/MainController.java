package com.example.bread.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * page 관리 용도
 */
@Controller
public class MainController {

    /**
     * 메인 화면
     */
    @GetMapping("/")
    public ModelAndView home(ModelAndView mav) {
        mav.setViewName("index");
        return mav;
    }

    /**
     * 로그인 화면
     */
    @GetMapping("/login")
    public ModelAndView login(ModelAndView mav) {
        mav.setViewName("login/login");
        return mav;
    }

    /**
     * 유저 관리 화면
     */
    @GetMapping("/userManage")
    public ModelAndView user(ModelAndView mav) {
        mav.setViewName("user/userManage");
        return mav;
    }
}
