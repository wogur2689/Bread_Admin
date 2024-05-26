package com.example.bread.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

    /**
     * 전체 유저 목록
     */
    @GetMapping("/userList")
    public ModelAndView getUserList(HttpServletRequest request, ModelAndView mav) {
        mav.setViewName("jsonView");
        return mav;
    }
}
