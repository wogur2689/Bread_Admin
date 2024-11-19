package com.example.bread.web.product.service;

import com.example.bread.common.util.CommonCode;
import com.example.bread.web.product.dto.ProductDto;
import com.example.bread.web.product.entity.ProductEntity;
import com.example.bread.web.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductEntity> list() {
        return productRepository.findAll();
    }

    public ProductEntity view(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public String insert(ProductDto productDto) {
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

    public String update(ProductDto productDto) {
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

    public String delete(ProductDto productDto) {
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
