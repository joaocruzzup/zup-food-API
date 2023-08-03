package com.example.zupfood.controller;

import com.example.zupfood.model.ItemCategory;
import com.example.zupfood.model.ItemMenu;
import com.example.zupfood.service.ItemMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/menu")
public class ItemMenuController {

    @Autowired
    ItemMenuService itemMenuService;

    @GetMapping
    public List<ItemMenu> getAllItems() {
        return itemMenuService.getAllItems();
    }

    @GetMapping("/{id}")
    public Optional<ItemMenu> getItemById(@PathVariable Long id) {
        return itemMenuService.getItemById(id);
    }

    @PostMapping
    public ItemMenu createItem(@RequestBody ItemMenu item) {
        return itemMenuService.createItem(item);
    }

    @PutMapping("/{id}")
    public ItemMenu updateItem(@PathVariable Long id, @RequestBody ItemMenu itemMenu) {
        return itemMenuService.updateItem(id, itemMenu);
    }

    @DeleteMapping("/{id}")
    public void deleteItemById(@PathVariable Long id) {
        itemMenuService.deleteItemById(id);
    }
}
