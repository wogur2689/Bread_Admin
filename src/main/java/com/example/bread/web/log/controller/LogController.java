package com.example.bread.web.log.controller;

import com.example.bread.common.util.CommonCode;
import com.example.bread.web.log.dto.LogDto;
import com.example.bread.web.log.entity.LogEntity;
import com.example.bread.web.log.service.LogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 관리자 로그 관리
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/log")
public class LogController {
    private final LogService logService;

    @GetMapping("/logList")
    public ModelAndView list(ModelAndView mav, @RequestParam(defaultValue = "1") int page) {
        Page<LogEntity> response = logService.list(page);

        mav.addObject("response", response);
        mav.addObject("currentPage", page);
        mav.addObject("totalPages", response.getTotalPages());
        mav.setViewName("log/log_list");
        return mav;
    }

    @GetMapping("/logView/{id}")
    public ModelAndView view(@PathVariable Long id, ModelAndView mav) {
        mav.addObject("response", logService.view(id));
        mav.setViewName("log/log_view");
        return mav;
    }

    @GetMapping("/logEdit/{id}")
    public ModelAndView edit(@PathVariable Long id, ModelAndView mav) {
        mav.addObject("response", logService.view(id));
        mav.setViewName("log/log_edit");
        return mav;
    }

    @GetMapping("/logWrite")
    public ModelAndView write(ModelAndView mav) {
        mav.setViewName("log/log_write");
        return mav;
    }

    @PostMapping("/api/{svc}")
    public ModelAndView LogApi(@PathVariable String svc, LogDto.LogRequestDto logDto, ModelAndView mav) {
        String code = svcSwitch(svc, logDto);
        mav.addObject("code", code);
        mav.addObject("msg", CommonCode.getMessage(code));
        mav.setViewName("jsonView");
        return mav;
    }

    private String svcSwitch(String svc, LogDto.LogRequestDto LogDto) {
        return switch (svc) {
            case "insert" -> logService.insert(LogDto);
            case "update" -> logService.update(LogDto);
            case "delete" -> logService.delete(LogDto);
            default -> CommonCode.CODE_0000.getCode();
        };
    }
}
