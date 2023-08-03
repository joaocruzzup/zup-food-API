package com.example.zupfood.service;

import com.example.zupfood.model.ItemCategory;
import com.example.zupfood.model.ItemOption;
import com.example.zupfood.repository.ItemCategoryRepository;
import com.example.zupfood.repository.ItemOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemOptionService {
    @Autowired
    private ItemOptionRepository itemOptionRepository;

    public List<ItemOption> getAllItemOptions() {
        return itemOptionRepository.findAll();
    }

    public Optional<ItemOption> getItemOptionById(Long id) {
        return itemOptionRepository.findById(id);
    }

    public ItemOption createItemOption(ItemOption itemOption) {
        return itemOptionRepository.save(itemOption);
    }

    public ItemOption updateItemOption(Long id, ItemOption updatedItemOption) {
        ItemOption itemOption = getItemOptionById(id).get();

        if (updatedItemOption.getName() != null){
            itemOption.setName(updatedItemOption.getName());
        }
        if (updatedItemOption.getItemCategory() != null){
            itemOption.setItemCategory(updatedItemOption.getItemCategory());
        }
        if (updatedItemOption.getPrice() != 0.0){
            itemOption.setPrice(updatedItemOption.getPrice());
        }


        return itemOptionRepository.save(itemOption);
    }

    public void deleteItemOption(Long id) {
        itemOptionRepository.deleteById(id);
    }
}
