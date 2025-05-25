package com.example.bread.web.board.service;

import com.example.bread.common.util.CommonCode;
import com.example.bread.web.board.dto.BoardDto;
import com.example.bread.web.board.entity.BoardEntity;
import com.example.bread.web.board.reposiory.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Page<BoardEntity> list(int page) {
        Pageable pageable = PageRequest.of(page - 1, 10, Sort.by(Sort.Direction.DESC, "createdAt"));
        return boardRepository.findAll(pageable);
    }

    public BoardEntity view(Long id) {
        return boardRepository.findById(id).orElseThrow();
    }

    public String insert(BoardDto.BoardRequestDto boardDto) {
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

    public String update(BoardDto.BoardRequestDto boardDto) {
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

    public String delete(BoardDto.BoardRequestDto boardDto) {
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
