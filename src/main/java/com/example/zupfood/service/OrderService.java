package com.example.zupfood.service;

import com.example.zupfood.model.ItemModel;
import com.example.zupfood.model.OrderModel;
import com.example.zupfood.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository repository;

    public List<OrderModel> getAll(){
        return repository.findAll();
    }

    public Optional<OrderModel> getById(Long id){
        return repository.findById(id);
    }

    public OrderModel create(OrderModel orderModel){
        orderModel.calculateTotalValue();
        return repository.save(orderModel);
    }

//    public ItemModel update(Long id){
//        return repository.save(order);
//    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
