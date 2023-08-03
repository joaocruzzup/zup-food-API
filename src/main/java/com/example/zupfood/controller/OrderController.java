package com.example.zupfood.controller;

import com.example.zupfood.model.ItemModel;
import com.example.zupfood.model.OrderModel;
import com.example.zupfood.service.ItemService;
import com.example.zupfood.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    OrderService service;

    @GetMapping(path = "/order")
    public List<OrderModel> getAll(){
        return service.getAll();
    }

    @GetMapping(path = "/order/{id}")
    public Optional<OrderModel> getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping(path = "/order")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderModel create(@RequestBody OrderModel orderModel){
        return service.create(orderModel);
    }

//    @PutMapping(path = "/order/{id}")
//    public OrderModel update(@PathVariable Long id, @RequestBody OrderModel orderModel){
//        return service.update(id, orderModel);
//    }

    @DeleteMapping(path = "/order/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
