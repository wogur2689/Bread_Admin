package com.example.bread.web.payment.controller;

import com.example.bread.web.payment.entity.PaymentEntity;
import com.example.bread.web.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 결제 API 요청 및 결과 관리
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("/paymentList")
    public ModelAndView list(ModelAndView mav, @RequestParam(defaultValue = "1") int page) {
        Page<PaymentEntity> response = paymentService.list(page);

        mav.addObject("response", response);
        mav.addObject("currentPage", page);
        mav.addObject("totalPages", response.getTotalPages());
        mav.setViewName("payment/payment_list");
        return mav;
    }

    @GetMapping("/paymentView/{id}")
    public ModelAndView view(@PathVariable Long id, ModelAndView mav) {
        mav.addObject("response", paymentService.view(id));
        mav.setViewName("payment/payment_view");
        return mav;
    }
}
