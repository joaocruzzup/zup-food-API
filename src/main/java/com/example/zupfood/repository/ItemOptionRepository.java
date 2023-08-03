package com.example.zupfood.repository;


import com.example.zupfood.model.ItemCategory;
import com.example.zupfood.model.ItemOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemOptionRepository extends JpaRepository<ItemOption, Long> {
    ItemOption findByNameIgnoreCase(String name);
}
