package com.example.bread.common.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler({CustomException.class})
    public ModelAndView handleCustomException(CustomException ex) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("code", ex.getCode());
        mav.addObject("msg", ex.getMsg());
        mav.setViewName("jsonView");
        return mav;
    }
}
