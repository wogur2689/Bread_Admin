package com.example.bread.web.menu.controller;

import com.example.bread.common.exception.CustomException;
import com.example.bread.common.util.CommonCode;
import com.example.bread.web.board.dto.BoardDto;
import com.example.bread.web.menu.dto.MenuDto;
import com.example.bread.web.menu.service.MenuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/menuList")
    public ModelAndView list(ModelAndView mav) {
        mav.addObject("response", menuService.list());
        mav.setViewName("menu/menu_list");
        return mav;
    }

    @PostMapping("/api/{svc}")
    public ModelAndView boardApi(@Valid @PathVariable String svc, MenuDto.MenuRequestDto menuDto, ModelAndView mav, BindingResult result) {
        //param 검증
        if(result.hasErrors()) {
            throw new CustomException(CommonCode.CODE_9995.getCode(), CommonCode.CODE_9995.getMsg());
        }
        String code = svcSwitch(svc, menuDto);
        mav.addObject("code", code);
        mav.addObject("msg", CommonCode.getMessage(code));
        mav.setViewName("jsonView");
        return mav;
    }

    private String svcSwitch(String svc, MenuDto.MenuRequestDto menuDto) {
        return switch (svc) {
            case "insert" -> menuService.insert(menuDto);
            case "update" -> menuService.update(menuDto);
            case "delete" -> menuService.delete(menuDto);
            default -> CommonCode.CODE_0000.getCode();
        };
    }
}
