package com.example.bread.web.order.controller;

import com.example.bread.web.order.entity.OrderEntity;
import com.example.bread.web.order.service.OrderService;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/paymentList")
    public ModelAndView list(ModelAndView mav, @RequestParam(defaultValue = "1") int page) {
        Page<OrderEntity> response = orderService.list(page);

        mav.addObject("response", response);
        mav.addObject("currentPage", page);
        mav.addObject("totalPages", response.getTotalPages());
        mav.setViewName("payment/payment_list");
        return mav;
    }

    @GetMapping("/paymentView/{id}")
    public ModelAndView view(@PathVariable Long id, ModelAndView mav) {
        mav.addObject("response", orderService.view(id));
        mav.setViewName("payment/payment_view");
        return mav;
    }
}
