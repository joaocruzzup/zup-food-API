package com.example.zupfood.service;

import com.example.zupfood.model.ItemMenu;
import com.example.zupfood.model.ItemCategory;
import com.example.zupfood.model.ItemOption;
import com.example.zupfood.repository.ItemMenuRepository;
import com.example.zupfood.repository.ItemCategoryRepository;
import com.example.zupfood.repository.ItemOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class ItemMenuService {

    @Autowired
    ItemMenuRepository itemMenuRepository;

    @Autowired
    ItemCategoryRepository itemCategoryRepository;

    @Autowired
    ItemOptionRepository itemOptionRepository;


    public List<ItemMenu> getAllItems() {
        return itemMenuRepository.findAll();
    }

    public Optional<ItemMenu> getItemById(Long id) {
        return itemMenuRepository.findById(id);
    }

    public ItemMenu createItem(ItemMenu item) {
        item.setUnitPrice(getItemPrice(item.getName()));
        validateTypeItemForCart(item);
        return itemMenuRepository.save(item);
    }

    public ItemMenu updateItem(Long id, ItemMenu updatedItem) {
        ItemMenu item = getItemById(id).get();

        if (updatedItem.getName() != null){
            item.setName(updatedItem.getName());
        }

        if (updatedItem.getItemCategory() != null){
            item.setItemCategory(updatedItem.getItemCategory());
        }

        if (updatedItem.getUnitPrice() != 0.00){
            item.setUnitPrice(updatedItem.getUnitPrice());
        }

        return itemMenuRepository.save(item);
    }



    public void deleteItemById(Long id) {
        itemMenuRepository.deleteById(id);
    }


    public double getItemPrice(String name) {
        ItemOption itemOption = itemOptionRepository.findByNameIgnoreCase(name);
        if (itemOption != null){
            return itemOption.getPrice();
        }
        return 0.0;
    }

    public boolean isValidTypeItemForCart(ItemMenu cardapioModel) {
        List<ItemCategory> listItemCategory = itemCategoryRepository.findAll();
        ItemOption itemOption = itemOptionRepository.findByNameIgnoreCase(cardapioModel.getName());

        for (int i = 0; i < listItemCategory.size(); i++) {
            if (listItemCategory.get(i).getName().equalsIgnoreCase(cardapioModel.getItemCategory())){
                if (itemOption != null && itemOption.getItemCategory().getName().equalsIgnoreCase(cardapioModel.getItemCategory())) {
                    return itemOption.getName().equalsIgnoreCase(cardapioModel.getName());
                }
            }
        }
        return false;
    }

    public void validateTypeItemForCart(ItemMenu item) {
        if (!isValidTypeItemForCart(item)) {
            ResponseEntity<String> response = ResponseEntity
                    .status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body("Item inválido para o tipo de pedido.");

            throw new ResponseStatusException(response.getStatusCode(), "Item inválido para o tipo de pedido.");
        }
    }

}
