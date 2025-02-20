package com.example.bread.web.collect.repository;

import com.example.bread.web.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectRepository extends JpaRepository<ProductEntity, Long> {

}
