package com.example.bread.web.board.service;

import com.example.bread.common.dto.PagingDto;
import com.example.bread.common.util.CommonCode;
import com.example.bread.web.board.dto.BoardDto;
import com.example.bread.web.board.entity.BoardEntity;
import com.example.bread.web.board.reposiory.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.ObjectUtils;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Page<BoardEntity> list(PagingDto pagingDto) {
        Pageable pageable = PageRequest.of(pagingDto.getPage() - 1, pagingDto.getSize());
        return boardRepository.findAll(pageable);
    }

//    public Integer[] getPageList(Integer curPageNum) {
//        Integer[] pageList = new Integer[BLOCK_PAGE_NUM_COUNT];
//
//        //총 게시글 개수
//        Double postsTotalCount = Double.valueOf(this.getBoardCount());
//        //총 게시글 기준으로 계산한 마지막 페이지 번호 계산 (올림으로 계산)
//        Integer totalLastPageNum = (int)(Math.ceil((postsTotalCount/PAGE_POST_COUNT)));
//        //현재 페이지를 기준으로 블럭의 마지막 페이지 번호 계산
//        Integer blockLastPageNum = (totalLastPageNum > curPageNum + BLOCK_PAGE_NUM_COUNT)
//                ? curPageNum +BLOCK_PAGE_NUM_COUNT
//                : totalLastPageNum;
//        //페이지 시작 번호 조정
//        curPageNum = (curPageNum <= 3) ? 1 : curPageNum -2;
//        //페이지 번호 할당
//        for(int val = curPageNum, idx = 0; val <= blockLastPageNum; val++, idx++) {
//            pageList[idx] = val;
//        }
//
//        return pageList;
//    }

    public BoardEntity view(Long id) {
        return boardRepository.findById(id).orElseThrow();
    }

    public String insert(BoardDto boardDto) {
        String code = CommonCode.CODE_0000.getCode();
        try {
            BoardEntity board = BoardEntity.toEntity(boardDto);
            boardRepository.save(board);
        } catch (Exception e) {
            e.printStackTrace();
            code = "9999";
        }
        return code;
    }

    public String update(BoardDto boardDto) {
        String code = CommonCode.CODE_0000.getCode();
        try {
            BoardEntity board = BoardEntity.toEntity(boardDto);
            boardRepository.save(board);
        } catch (Exception e) {
            e.printStackTrace();
            code = "9999";
        }
        return code;
    }

    public String delete(BoardDto boardDto) {
        String code = CommonCode.CODE_0000.getCode();
        try {
            BoardEntity board = BoardEntity.toEntity(boardDto);
            boardRepository.delete(board);
        } catch (Exception e) {
            e.printStackTrace();
            code = "9999";
        }
        return code;
    }
}
