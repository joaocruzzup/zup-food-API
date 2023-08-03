package com.example.zupfood.service;

import com.example.zupfood.dto.ItemDTO;
import com.example.zupfood.enums.ItemOption;
import com.example.zupfood.enums.ItemCategory;
import com.example.zupfood.model.ItemModel;
import com.example.zupfood.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class ItemService {

    @Autowired
    ItemRepository repository;

    private static final Map<ItemCategory, List<ItemOption>> itemMap = new HashMap<>();

    static {
        itemMap.put(ItemCategory.BEBIDA, Arrays.asList(ItemOption.X_BURGUER, ItemOption.X_SALADA));
        itemMap.put(ItemCategory.LANCHE, Arrays.asList(ItemOption.SUCO, ItemOption.REFRIGERANTE));
    }

    //GetAll
    public List<ItemModel> getAll(){
        return repository.findAll();
    }

    // GetByID
    public Optional<ItemModel> getById(Long id){
        return repository.findById(id);
    }

    // Create
    public ItemDTO create(ItemDTO itemDTO){

        if (!isValidTypeItemForOrder(itemDTO.toItemModel())) {
            ResponseEntity<String> response = ResponseEntity
                    .status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body("Item inválido para o tipo de pedido.");

            throw new ResponseStatusException(response.getStatusCode(), "Item inválido para o tipo de pedido.");
        }

        ItemModel itemSaved = repository.save(itemDTO.toItemModel());
        return new ItemDTO(itemSaved);
    }

    //Update
    public ItemModel update(Long id, ItemModel itemModel){
        ItemModel order = getById(id).get();

        if (itemModel.getItemCategory() != null){
            order.setItemCategory(itemModel.getItemCategory());
        }

        if (itemModel.getName() != null){
            order.setName(itemModel.getName());
        }


        if (!isValidTypeItemForOrder(order)) {
            ResponseEntity<String> response = ResponseEntity
                    .status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body("Item inválido para o tipo de pedido.");

            throw new ResponseStatusException(response.getStatusCode(), "Item inválido para o tipo de pedido.");
        }

        return repository.save(order);
    }

    // Delete
    public void delete(Long id){
        repository.deleteById(id);
    }

    // Method isValidTypeItemForOrDER
    public boolean isValidTypeItemForOrder(ItemModel itemModel) {
        ItemCategory itemCategory = itemModel.getItemCategory();
        String typeItemName = itemModel.getName().toLowerCase();

        return (itemCategory == ItemCategory.BEBIDA && (typeItemName.equals(ItemOption.SUCO.getName()) || typeItemName.equals(ItemOption.REFRIGERANTE.getName()))) ||
                (itemCategory == ItemCategory.LANCHE && (typeItemName.equals(ItemOption.X_BURGUER.getName()) || typeItemName.equals(ItemOption.X_SALADA.getName())));
    }

}
