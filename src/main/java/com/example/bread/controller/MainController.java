package com.example.bread.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
