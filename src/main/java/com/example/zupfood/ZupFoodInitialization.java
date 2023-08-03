package com.example.zupfood;

import com.example.zupfood.model.ItemCategory;
import com.example.zupfood.model.ItemOption;
import com.example.zupfood.service.ItemMenuService;
import com.example.zupfood.service.ItemCategoryService;
import com.example.zupfood.service.ItemOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ZupFoodInitialization implements CommandLineRunner {

    @Autowired
    ItemMenuService cardapioService;

    @Autowired
    ItemOptionService itemOptionService;

    @Autowired
    ItemCategoryService itemCategoryService;

    @Override
    public void run(String... args) throws Exception {

        if (itemCategoryService.getAllItemCategories().isEmpty()){
            createAndSaveItemCategories();
        }
        if (itemOptionService.getAllItemOptions().isEmpty()){
            createAndSaveItemOptions();
        }

    }

    private void createAndSaveItemCategories() {
        ItemCategory itemCategory1 = new ItemCategory(1L, "lanche");
        ItemCategory itemCategory2 = new ItemCategory(2L, "bebida");
        itemCategoryService.createItemCategory(itemCategory1);
        itemCategoryService.createItemCategory(itemCategory2);
    }

    private void createAndSaveItemOptions() {
        ItemOption itemOption1 = new ItemOption("x-burguer", 10.00, 1L);
        ItemOption itemOption2 = new ItemOption("x-salada", 12.00, 1L);
        ItemOption itemOption3 = new ItemOption("refrigerante", 8.00, 2L);
        ItemOption itemOption4 = new ItemOption("suco", 6.00, 2L);
        itemOptionService.createItemOption(itemOption1);
        itemOptionService.createItemOption(itemOption2);
        itemOptionService.createItemOption(itemOption3);
        itemOptionService.createItemOption(itemOption4);
    }
}
