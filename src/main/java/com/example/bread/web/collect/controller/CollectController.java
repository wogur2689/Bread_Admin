package com.example.bread.web.collect.controller;

import com.example.bread.web.collect.service.CollectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * 데이터 수집
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
@RequestMapping("/api/collect")
public class CollectController {
    private final CollectService collectService;

    /**
     * 파리바게트 데이터 수집 api
     */
    @PostMapping("/parisData")
    public ModelAndView parisData(ModelAndView mav) throws IOException {
        mav.addObject("data", collectService.getParisData());
        mav.setViewName("jsonView");
        return mav;
    }
}
