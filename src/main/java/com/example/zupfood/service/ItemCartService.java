package com.example.zupfood.service;

import com.example.zupfood.dto.ItemCartListDTO;
import com.example.zupfood.model.ItemCart;
import com.example.zupfood.repository.ItemCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ItemCartService {

    @Autowired
    ItemCartRepository itemCartRepository;

    @Autowired
    ItemMenuService cardapioService;

    public List<ItemCart> getAllItemsInCart() {
        return itemCartRepository.findAll();
    }

    public Optional<ItemCart> getItemInCartById(Long id) {
        return itemCartRepository.findById(id);
    }

    public List<ItemCart> createItemsInCart(List<ItemCartListDTO> itemCartDTOList) {
        List<ItemCart> savedItems = new ArrayList<>();
        for (ItemCartListDTO itemDTO: itemCartDTOList) {
            ItemCart itemCartModel = new ItemCart();
            itemCartModel.setCardapioModel(cardapioService.getItemById(itemDTO.getMenuId()).orElse(null));
            itemCartModel.setQuantity(itemDTO.getQuantity());
            itemCartModel.calculeTotalPrice();
            savedItems.add(createItemInCart(itemCartModel));
        }
        return savedItems;
    }

    public ItemCart createItemInCart(ItemCart itemCartModel){
        return itemCartRepository.save(itemCartModel);
    }

    public ItemCart updateItem(Long id, ItemCart updatedItem) {
        ItemCart item = getItemInCartById(id).get();

        if (updatedItem.getCardapioModel() != null){
            item.setCardapioModel(updatedItem.getCardapioModel());
        }

        if (updatedItem.getQuantity() != 0.00){
            item.setQuantity(updatedItem.getQuantity());
            item.calculeTotalPrice();
        }

        if (updatedItem.getTotalPrice() != 0.0){
            item.setTotalPrice(updatedItem.getTotalPrice());
        }



        return itemCartRepository.save(item);
    }

    public void deleteItemInCartById(Long id) {
        itemCartRepository.deleteById(id);
    }

}
