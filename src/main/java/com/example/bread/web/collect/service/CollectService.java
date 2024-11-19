package com.example.bread.web.collect.service;

import com.example.bread.web.collect.repository.CollectRepository;
import com.example.bread.web.product.entity.ProductEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CollectService {
    private CollectRepository collectRepository;
    private final String parisUrl = "https://www.paris.co.kr/products/?cat1=%EB%B8%8C%EB%A0%88%EB%93%9C";

    // 파리바게트 데이터 가져오기
    public List<ProductEntity> getParisData() throws IOException {
        // GET 으로 요청하고, 요청 결과를 Document 객체로 반환
        Connection conn = Jsoup.connect(parisUrl);
        Document document = conn.get();

        //1. 이미지
        Elements imgs = document.getElementsByClass("product-tb");

        //2. 상품명
        Elements names = document.getElementsByClass("product-name");

        //3. DB에 저장
        List<ProductEntity> list = new ArrayList<>();
        for(int i = 0; i < names.size(); i++) {
            ProductEntity productEntity = ProductEntity.builder()
                    .imageUrl(imgs.get(i).attr("src"))
                    .name(names.get(i).text())
                    .build();
            collectRepository.save(productEntity);
            list.add(productEntity);
        }
        return list;
    }
}
