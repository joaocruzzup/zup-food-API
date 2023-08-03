package com.example.zupfood.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ItemOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ItemCategory itemCategory;

    public ItemOption(String name, double price, Long itemCategoryId) {
        this.name = name;
        this.price = price;
        this.itemCategory = new ItemCategory();
        itemCategory.setId(itemCategoryId);
    }
}
