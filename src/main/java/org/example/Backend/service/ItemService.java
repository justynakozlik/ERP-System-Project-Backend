package org.example.backend.service;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.ItemSavedDto;
import org.example.backend.entity.Item;
import org.example.backend.entity.QuantityType;
import org.example.backend.entity.Warehouse;
import org.example.backend.repository.ItemRepository;
import org.example.backend.repository.QuantityTypeRepository;
import org.example.backend.repository.WarehouseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final WarehouseRepository warehouseRepository;
    private final QuantityTypeRepository quantityTypeRepository;

    public Item saveItem(ItemSavedDto dto){
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(dto.getIdWarehouse());
        Optional<QuantityType> optionalQuantityType = quantityTypeRepository.findById(dto.getIdQuantityType());
        if(!optionalWarehouse.isPresent() || !optionalQuantityType.isPresent()){
            throw new RuntimeException("Incorrect identifiers: idWarehouse: " + dto.getIdWarehouse() + ", idQuantityType: " + dto.getIdQuantityType());
        }
        Warehouse warehouse = optionalWarehouse.get();
        QuantityType quantityType = optionalQuantityType.get();

        Item item = Item.of(dto);
        item.setQuantityType(quantityType);
        item.setWarehouse(warehouse);
        return itemRepository.save(item);
    }
}
