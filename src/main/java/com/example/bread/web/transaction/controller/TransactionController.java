package com.example.bread.web.transaction.controller;

import com.example.bread.common.util.CommonCode;
import com.example.bread.web.payment.dto.PaymentDto;
import com.example.bread.web.payment.entity.PaymentEntity;
import com.example.bread.web.payment.service.PaymentService;
import com.example.bread.web.transaction.service.TransactionService;
import jakarta.validation.constraints.NotBlank;
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
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping("/paymentList")
    public ModelAndView list(ModelAndView mav, @RequestParam(defaultValue = "1") int page) {
        Page<TransactionEEntity> response = transactionService.list(page);

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

    @GetMapping("/paymentEdit/{id}")
    public ModelAndView edit(@PathVariable Long id, ModelAndView mav) {
        mav.addObject("response", paymentService.view(id));
        mav.setViewName("payment/payment_edit");
        return mav;
    }

    @GetMapping("/paymentWrite")
    public ModelAndView write(ModelAndView mav) {
        mav.setViewName("payment/payment_write");
        return mav;
    }

    @PostMapping("/api/{svc}")
    public ModelAndView paymentApi(@PathVariable String svc, PaymentDto.PaymentRequestDto PaymentDto, ModelAndView mav) {
        String code = svcSwitch(svc, PaymentDto);
        mav.addObject("code", code);
        mav.addObject("msg", CommonCode.getMessage(code));
        mav.setViewName("jsonView");
        return mav;
    }

    private String svcSwitch(String svc, PaymentDto.PaymentRequestDto PaymentDto) {
        return switch (svc) {
            case "insert" -> paymentService.insert(PaymentDto);
            case "update" -> paymentService.update(PaymentDto);
            case "delete" -> paymentService.delete(PaymentDto);
            default -> CommonCode.CODE_0000.getCode();
        };
    }
}
