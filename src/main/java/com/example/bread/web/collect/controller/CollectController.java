package com.example.bread.web.collect.controller;

import com.example.bread.web.collect.service.CollectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/collect")
public class CollectController {
    private final CollectService collectService;

    /**
     * 파리바게트 데이터 수집 api
     */
    @PostMapping("/parisData")
    public String parisData() throws IOException {
        collectService.getParisData();
        return "success";
    }
}
