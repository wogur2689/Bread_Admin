package com.example.bread.web.product.controller;

import com.example.bread.common.util.CommonCode;
import com.example.bread.web.product.dto.ProductDto;
import com.example.bread.web.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 상품 관리
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/list")
    public ModelAndView list(ModelAndView mav) {
        mav.addObject("data", productService.list());
        mav.setViewName("product/list");
        return mav;
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable Long id, ModelAndView mav) {
        mav.addObject("data", productService.view(id));
        mav.setViewName("product/view");
        return mav;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id, ModelAndView mav) {
        mav.addObject("data", productService.view(id));
        mav.setViewName("product/edit");
        return mav;
    }

    @GetMapping("/write")
    public ModelAndView write(ModelAndView mav) {
        mav.setViewName("product/write");
        return mav;
    }

    @PostMapping("/api/{svc}")
    public ModelAndView productApi(@PathVariable String svc, ProductDto productDto, ModelAndView mav) {
        String code = svcSwitch(svc, productDto);
        mav.addObject("code", code);
        mav.addObject("msg", CommonCode.getMessage(code));
        mav.setViewName("jsonView");
        return mav;
    }

    private String svcSwitch(String svc, ProductDto productDto) {
        return switch (svc) {
            case "insert" -> productService.insert(productDto);
            case "update" -> productService.update(productDto);
            case "delete" -> productService.delete(productDto);
            default -> CommonCode.CODE_0000.getCode();
        };
    }
}
