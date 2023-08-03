package com.example.zupfood.model;

import com.example.zupfood.enums.ItemCategory;
import com.example.zupfood.enums.ItemOption;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderModel orderModel;

    @Enumerated(EnumType.STRING)
    private ItemCategory itemCategory;

    private String name;

    private double unitPrice;

    private int quantity;

    public ItemModel(ItemCategory itemCategory, String name, int quantity) {
        this.itemCategory = itemCategory;
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = getItemPriceByName(name);
    }

    private double getItemPriceByName(String name) {
        for (ItemOption itemOption : ItemOption.values()) {
            if (itemOption.getName().equalsIgnoreCase(name)) {
                return itemOption.getPrice();
            }
        }
        return 0.0;
    }

}
