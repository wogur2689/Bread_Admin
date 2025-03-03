package com.example.bread.web.user.controller;

import com.example.bread.web.user.entiry.UsersEntity;
import com.example.bread.web.user.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ModelAndView list(ModelAndView mav, @RequestParam(defaultValue = "1") int page) {
        Page<UsersEntity> response = usersService.getUserList(page);
        mav.addObject("response", response);
        mav.addObject("currentPage", page);
        mav.addObject("totalPages", response.getTotalPages());
        mav.setViewName("user/user_list");
        return mav;
    }

    /*
     * 유저 Excel upload
     */
    @PostMapping("/userList")
    public ModelAndView excelUpload(ModelAndView mav, @RequestParam(defaultValue = "1") int page) {
        Page<UsersEntity> response = usersService.getUserList(page);
        mav.addObject("response", response);
        mav.addObject("currentPage", page);
        mav.addObject("totalPages", response.getTotalPages());
        mav.setViewName("user/user_list");
        return mav;
    }
}
