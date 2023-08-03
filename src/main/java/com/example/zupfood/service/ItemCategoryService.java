package com.example.zupfood.service;

import com.example.zupfood.model.ItemCategory;
import com.example.zupfood.repository.ItemCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemCategoryService {
    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

    public List<ItemCategory> getAllItemCategories() {
        return itemCategoryRepository.findAll();
    }

    public Optional<ItemCategory> getItemCategoryById(Long id) {
        return itemCategoryRepository.findById(id);
    }

    public ItemCategory createItemCategory(ItemCategory itemCategory) {
        return itemCategoryRepository.save(itemCategory);
    }

    public ItemCategory updateItemCategory(Long id, ItemCategory updatedItemCategory) {
        ItemCategory itemCategory = getItemCategoryById(id).get();

        if (updatedItemCategory.getName() != null){
            itemCategory.setName(updatedItemCategory.getName());
        }

        return itemCategoryRepository.save(itemCategory);
    }

    public void deleteItemCategory(Long id) {
        itemCategoryRepository.deleteById(id);
    }
}
