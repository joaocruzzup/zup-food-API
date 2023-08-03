package com.example.zupfood.repository;

import com.example.zupfood.model.ItemCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCartRepository extends JpaRepository<ItemCart, Long> {
}
