package com.example.zupfood.controller;

import com.example.zupfood.model.ItemCart;
import com.example.zupfood.model.ItemCategory;
import com.example.zupfood.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class ItemCategoryController {

    @Autowired
    ItemCategoryService itemCategoryService;

    @GetMapping
    public List<ItemCategory> getAllItems() {
        return itemCategoryService.getAllItemCategories();
    }

    @GetMapping("/{id}")
    public Optional<ItemCategory> getItemById(@PathVariable Long id) {
        return itemCategoryService.getItemCategoryById(id);
    }

    @PostMapping
    public ItemCategory createItem(@RequestBody ItemCategory item) {
        return itemCategoryService.createItemCategory(item);
    }

    @PutMapping("/{id}")
    public ItemCategory updateItem(@PathVariable Long id, @RequestBody ItemCategory itemCategory) {
        return itemCategoryService.updateItemCategory(id, itemCategory);
    }

    @DeleteMapping("/{id}")
    public void deleteItemById(@PathVariable Long id) {
        itemCategoryService.deleteItemCategory(id);
    }
}
