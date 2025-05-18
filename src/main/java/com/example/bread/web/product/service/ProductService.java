package com.example.bread.web.product.service;

import com.example.bread.common.util.CommonCode;
import com.example.bread.web.product.dto.ProductDto;
import com.example.bread.web.product.entity.ProductEntity;
import com.example.bread.web.product.repository.ProductRepository;
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
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public Page<ProductEntity> list(int page) {
        Pageable pageable = PageRequest.of(page - 1, 10, Sort.by(Sort.Direction.DESC, "createdAt"));
        return productRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public ProductEntity view(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public String insert(ProductDto.ProductRequestDto productDto) {
        String code = CommonCode.CODE_0000.getCode();
        try {
            ProductEntity product = ProductEntity.toEntity(productDto);
            productRepository.save(product);
        } catch (Exception e) {
            e.printStackTrace();
            code = "9999";
        }
        return code;
    }

    public String update(ProductDto.ProductRequestDto productDto) {
        String code = CommonCode.CODE_0000.getCode();
        try {
            ProductEntity product = ProductEntity.toEntity(productDto);
            productRepository.save(product);
        } catch (Exception e) {
            e.printStackTrace();
            code = "9999";
        }
        return code;
    }

    public String delete(ProductDto.ProductRequestDto productDto) {
        String code = CommonCode.CODE_0000.getCode();
        try {
            ProductEntity product = ProductEntity.toEntity(productDto);
            productRepository.delete(product);
        } catch (Exception e) {
            e.printStackTrace();
            code = "9999";
        }
        return code;
    }
}
