package com.example.bread.web.product.controller;

import com.example.bread.common.util.CommonCode;
import com.example.bread.web.product.dto.ProductDto;
import com.example.bread.web.product.entity.ProductEntity;
import com.example.bread.web.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/productList")
    public ModelAndView list(ModelAndView mav, @RequestParam(defaultValue = "1") int page) {
        Page<ProductEntity> response = productService.list(page);

        mav.addObject("response", response);
        mav.addObject("currentPage", page);
        mav.addObject("totalPages", response.getTotalPages());
        mav.setViewName("product/product_list");
        return mav;
    }

    @GetMapping("/productView/{id}")
    public ModelAndView view(@PathVariable Long id, ModelAndView mav) {
        mav.addObject("response", productService.view(id));
        mav.setViewName("product/product_view");
        return mav;
    }

    @GetMapping("/productEdit/{id}")
    public ModelAndView edit(@PathVariable Long id, ModelAndView mav) {
        mav.addObject("response", productService.view(id));
        mav.setViewName("product/product_edit");
        return mav;
    }

    @GetMapping("/productWrite")
    public ModelAndView write(ModelAndView mav) {
        mav.setViewName("product/product_write");
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
