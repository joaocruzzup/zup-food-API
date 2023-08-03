package com.example.zupfood.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemCartListDTO implements Serializable {

    private Long menuId;

    private double totalPrice;

    private int quantity;
}
