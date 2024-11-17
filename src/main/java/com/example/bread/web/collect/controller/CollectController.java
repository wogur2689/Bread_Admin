package com.example.bread.web.collect.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/collect")
public class CollectController {
    /**
     * 파리바게트 데이터 수집 api
     */
    @GetMapping("/parisData")
    public String parisData() throws IOException {
        // GET 으로 요청하고, 요청 결과를 Document 객체로 반환
        Connection conn = Jsoup.connect("https://www.paris.co.kr/products/?cat1=%EB%B8%8C%EB%A0%88%EB%93%9C");
        Document document = conn.get();

        //1. 이미지
        Elements imgs = document.getElementsByClass("product-tb");

        //2. 상품명
        Elements names = document.getElementsByClass("product-name");

        Element name = names.get(0);
        Element img = imgs.get(0);

        log.info(String.valueOf(name.text()));
        log.info(String.valueOf(img.attr("src")));
        return "success";
    }
}
