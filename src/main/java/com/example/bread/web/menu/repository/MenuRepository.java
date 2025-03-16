package com.example.bread.web.menu.repository;

import com.example.bread.web.menu.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Long> {

    // 특정 메뉴의 하위 메뉴 조회
    List<MenuEntity> findByParent(MenuEntity parent);

    //Lazy Loading 방지
    @Query("SELECT m FROM MenuEntity m LEFT JOIN FETCH m.children WHERE m.parent IS NULL")
    List<MenuEntity> findRootMenusWithChildren();
}
