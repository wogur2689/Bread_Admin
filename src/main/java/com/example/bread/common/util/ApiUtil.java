package com.example.bread.common.util;

import com.example.bread.common.dto.CommonDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.nio.charset.StandardCharsets;

public class ApiUtil {

    /**
     * 공통 헤더(json 반환)
     */
    public static HttpHeaders getHttpHeader() {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
        return header;
    }

    /**
     * 공통 결과 리턴형식(메세지, 코드)
     */
    public static CommonDto commonReturn(String code, String msg) {
        return new CommonDto(code, msg, null);
    }

    /**
     * 공통 결과 리턴형식(메세지, 코드, 내용)
     */
    public static CommonDto commonDataReturn(Object data, String code, String msg) {
        return new CommonDto(code, msg, msg);
    }
}
