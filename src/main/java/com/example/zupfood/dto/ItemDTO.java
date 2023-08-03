package com.example.zupfood.dto;

import com.example.zupfood.enums.ItemCategory;
import com.example.zupfood.model.ItemModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ItemDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private ItemCategory itemCategory;
    private String name;
    private int quantity;

    public ItemDTO(ItemModel itemModel){
        this.itemCategory = itemModel.getItemCategory();
        this.name = itemModel.getName();
        this.quantity = itemModel.getQuantity();
    }

    public ItemModel toItemModel(){
        return new ItemModel(itemCategory, name, quantity);
    }

}
