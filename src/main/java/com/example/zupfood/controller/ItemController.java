package com.example.zupfood.controller;

import com.example.zupfood.dto.ItemDTO;
import com.example.zupfood.model.ItemModel;
import com.example.zupfood.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ItemController {

    @Autowired
    ItemService service;

    @GetMapping(path = "/item")
    public List<ItemModel> getAll(){
        return service.getAll();
    }

    @GetMapping(path = "/item/{id}")
    public Optional<ItemModel> getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping(path = "/item")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO create(@RequestBody ItemDTO itemDTO){
        return service.create(itemDTO);
    }

    @PutMapping(path = "/item/{id}")
    public ItemModel update(@PathVariable Long id, @RequestBody ItemModel itemModel){
        return service.update(id, itemModel);
    }

    @DeleteMapping(path = "/item/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
