package com.example.zupfood.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ItemCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ItemMenu cardapioModel;

    private double totalPrice;

    private int quantity;

    public void calculeTotalPrice() {
        this.totalPrice = quantity * cardapioModel.getUnitPrice();
    }

}
