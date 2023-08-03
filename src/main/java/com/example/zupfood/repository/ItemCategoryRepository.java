package com.example.zupfood.repository;

import com.example.zupfood.model.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCategoryRepository extends JpaRepository<ItemCategory, Long> {
    ItemCategory findByNameIgnoreCase(String name);
}
