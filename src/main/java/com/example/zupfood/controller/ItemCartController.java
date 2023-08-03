package com.example.zupfood.controller;

import com.example.zupfood.dto.ItemCartListDTO;
import com.example.zupfood.model.ItemCart;
import com.example.zupfood.service.ItemCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class ItemCartController {

    @Autowired
    ItemCartService itemCartService;

    @GetMapping
    public List<ItemCart> getAllItemsInCart() {
        return itemCartService.getAllItemsInCart();
    }

    @GetMapping("/{id}")
    public Optional<ItemCart> getItemInCartById(@PathVariable Long id) {
        return itemCartService.getItemInCartById(id);
    }

    @PostMapping
    public List<ItemCart> createItemInCart(@RequestBody List<ItemCartListDTO> itemInCart) {
        return itemCartService.createItemsInCart(itemInCart);
    }

    @PutMapping("/{id}")
    public ItemCart updateItemInCart(@PathVariable Long id, @RequestBody ItemCart itemCart) {
        return itemCartService.updateItem(id, itemCart);
    }

    @DeleteMapping("/{id}")
    public void deleteItemInCartById(@PathVariable Long id) {
        itemCartService.deleteItemInCartById(id);
    }
}
