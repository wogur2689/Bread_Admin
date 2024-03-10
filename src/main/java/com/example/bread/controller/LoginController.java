package com.example.bread.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
    /**
     * 로그인 화면
     */
    @GetMapping
    public ModelAndView login(ModelAndView mav) {
        mav.setViewName("login/login");
        return mav;
    }
}
