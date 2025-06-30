package com.example.bread.web.board.service;

import com.example.bread.common.exception.CustomException;
import com.example.bread.common.util.CommonCode;
import com.example.bread.web.board.dto.BoardDto;
import com.example.bread.web.board.entity.BoardEntity;
import com.example.bread.web.board.reposiory.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public Page<BoardEntity> list(int page) {
        Pageable pageable = PageRequest.of(page - 1, 10, Sort.by(Sort.Direction.DESC, "createdAt"));
        return boardRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public BoardEntity view(Long id) {
        return boardRepository.findById(id).orElseThrow();
    }

    @Transactional
    public String insert(BoardDto.BoardRequestDto boardDto) {
        String code = CommonCode.CODE_0000.getCode();
        try {
            BoardEntity board = BoardEntity.toEntity(boardDto);
            boardRepository.save(board);
        } catch (DataAccessException | NullPointerException e) {
            code = "9999";
        }
        return code;
    }

    @Transactional
    public String update(BoardDto.BoardRequestDto boardDto) {
        String code = CommonCode.CODE_0000.getCode();
        try {
            BoardEntity board = boardRepository.findById(boardDto.getId())
                    .orElseThrow(() -> new CustomException("9999", "해당 게시글이 존재하지 않습니다."));

            board.update(boardDto);
        } catch (DataAccessException | NullPointerException e) {
            e.printStackTrace();
            code = "9999";
        }
        return code;
    }

    @Transactional
    public String delete(BoardDto.BoardRequestDto boardDto) {
        String code = CommonCode.CODE_0000.getCode();
        try {
            BoardEntity board = BoardEntity.toEntity(boardDto);
            boardRepository.delete(board);
        } catch (DataAccessException | NullPointerException e) {
            e.printStackTrace();
            code = "9999";
        }
        return code;
    }
}
