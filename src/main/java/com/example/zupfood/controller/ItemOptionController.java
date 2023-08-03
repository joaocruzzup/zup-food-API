package com.example.zupfood.controller;

import com.example.zupfood.model.ItemCategory;
import com.example.zupfood.model.ItemMenu;
import com.example.zupfood.model.ItemOption;
import com.example.zupfood.service.ItemCategoryService;
import com.example.zupfood.service.ItemOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/option")
public class ItemOptionController {

    @Autowired
    ItemOptionService itemOptionService;

    @GetMapping
    public List<ItemOption> getAllItems() {
        return itemOptionService.getAllItemOptions();
    }

    @GetMapping("/{id}")
    public Optional<ItemOption> getItemById(@PathVariable Long id) {
        return itemOptionService.getItemOptionById(id);
    }

    @PostMapping
    public ItemOption createItem(@RequestBody ItemOption item) {
        return itemOptionService.createItemOption(item);
    }

    @PutMapping("/{id}")
    public ItemOption updateItem(@PathVariable Long id, @RequestBody ItemOption itemOption) {
        return itemOptionService.updateItemOption(id, itemOption);
    }

    @DeleteMapping("/{id}")
    public void deleteItemById(@PathVariable Long id) {
        itemOptionService.deleteItemOption(id);
    }
}
