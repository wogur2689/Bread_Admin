package com.example.bread.web.user.controller;

import com.example.bread.web.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    /**
     * 유저 관리 화면
     */
    @GetMapping("/userManage")
    public ModelAndView user(ModelAndView mav) {
        mav.addObject("userList", userService.getUserList());
        mav.setViewName("user/userManage");
        return mav;
    }

    /**
     * 전체 유저 목록
     */
    @GetMapping("/userList")
    public ModelAndView getUserList(ModelAndView mav) {
        mav.addObject("userList", userService.getUserList());
        mav.setViewName("jsonView");
        return mav;
    }
}
