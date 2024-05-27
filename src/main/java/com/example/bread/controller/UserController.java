package com.example.bread.controller;

import com.example.bread.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    /**
     * 전체 유저 목록
     */
    @GetMapping("/userList")
    public ModelAndView getUserList(HttpServletRequest request, ModelAndView mav) {
        mav.addObject("userList", userService.getUserList());
        mav.setViewName("jsonView");
        return mav;
    }
}
