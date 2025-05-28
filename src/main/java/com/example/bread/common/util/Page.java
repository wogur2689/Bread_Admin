package com.example.bread.common.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class Page {
    public static Pageable createPageable(int page) {
        return PageRequest.of(page - 1, 10, Sort.by(Sort.Direction.DESC, "createdAt"));
    }
}
