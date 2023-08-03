package com.example.zupfood.repository;

import com.example.zupfood.model.ItemMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemMenuRepository extends JpaRepository<ItemMenu, Long> {
}
