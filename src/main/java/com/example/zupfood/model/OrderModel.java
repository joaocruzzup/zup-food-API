package com.example.zupfood.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "orderModel", cascade = CascadeType.ALL)
    private List<ItemModel> items = new ArrayList<>();

    private double totalValue;

    public void calculateTotalValue() {
        double total = 0.0;
        for (ItemModel item : items) {
            total += item.getUnitPrice() * item.getQuantity();
        }
        this.totalValue = total;
    }
}
