package com.example.bread.web.user.controller;

import com.example.bread.web.user.service.UsersService;
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

    private final UsersService usersService;

    /**
     * 유저 관리 화면
     */
    @GetMapping("/userList")
    public ModelAndView user(ModelAndView mav) {
        mav.addObject("userList", usersService.getUserList());
        mav.setViewName("user/user_list");
        return mav;
    }
}
