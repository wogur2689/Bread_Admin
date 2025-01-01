package com.example.bread.web.board.controller;

import com.example.bread.common.dto.PagingDto;
import com.example.bread.common.util.CommonCode;
import com.example.bread.web.board.dto.BoardDto;
import com.example.bread.web.board.entity.BoardEntity;
import com.example.bread.web.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 관리자 커뮤니티
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/boardList")
    public ModelAndView list(ModelAndView mav, @ModelAttribute("pagingDto") PagingDto pagingDto) {
        //PagingDto가 null 경우 기본값 세팅
        Page<BoardEntity> response = boardService.list(pagingDto);

        mav.addObject("response", response);
        mav.addObject("currentPage", pagingDto.getPage());
        mav.addObject("totalPages", response.getTotalPages());
        mav.setViewName("board/board_list");
        return mav;
    }

    @GetMapping("/boardView/{id}")
    public ModelAndView view(@PathVariable Long id, ModelAndView mav) {
        mav.addObject("response", boardService.view(id));
        mav.setViewName("board/board_view");
        return mav;
    }

    @GetMapping("/boardEdit/{id}")
    public ModelAndView edit(@PathVariable Long id, ModelAndView mav) {
        mav.addObject("response", boardService.view(id));
        mav.setViewName("board/board_edit");
        return mav;
    }

    @GetMapping("/boardWrite")
    public ModelAndView write(ModelAndView mav) {
        mav.setViewName("board/board_write");
        return mav;
    }

    @PostMapping("/api/{svc}")
    public ModelAndView boardApi(@PathVariable String svc, BoardDto boardDto, ModelAndView mav) {
        String code = svcSwitch(svc, boardDto);
        mav.addObject("code", code);
        mav.addObject("msg", CommonCode.getMessage(code));
        mav.setViewName("jsonView");
        return mav;
    }

    private String svcSwitch(String svc, BoardDto boardDto) {
        return switch (svc) {
            case "insert" -> boardService.insert(boardDto);
            case "update" -> boardService.update(boardDto);
            case "delete" -> boardService.delete(boardDto);
            default -> CommonCode.CODE_0000.getCode();
        };
    }
}
