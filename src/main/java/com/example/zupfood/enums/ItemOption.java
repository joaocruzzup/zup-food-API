package com.example.zupfood.enums;

import lombok.Getter;

@Getter
public enum ItemOption {
    X_BURGUER("x-burguer", 10.00),
    X_SALADA("x-salada", 12.00),
    REFRIGERANTE("refrigerante", 8.00),
    SUCO("suco", 6.00);

    private final String name;
    private final double price;

    ItemOption(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
