package org.example.backend.service;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.ItemDto;
import org.example.backend.dto.WarehouseDto;
import org.example.backend.dto.WarehouseModuleDto;
import org.example.backend.entity.Warehouse;
import org.example.backend.repository.WarehouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;

    public WarehouseModuleDto getWarehouseModuleData(){
        List<Warehouse> warehouseList = warehouseRepository.findAll();
        List<WarehouseDto> warehouseDtoList = warehouseList.stream().map(WarehouseDto::of).collect(Collectors.toList());
        List<ItemDto> itemDtoList = warehouseList.get(0).getItems().stream().map(ItemDto::of).collect(Collectors.toList());
        WarehouseDto selectedWarehouseDto = WarehouseDto.of(warehouseList.get(0));
        WarehouseModuleDto warehouseModuleDto = new WarehouseModuleDto(selectedWarehouseDto, warehouseDtoList, itemDtoList);
        return warehouseModuleDto;
    }

    public WarehouseModuleDto getWarehouseModuleData(Long idWarehouse){
        List<Warehouse> warehouseList = warehouseRepository.findAll();
        List<WarehouseDto> warehouseDtoList = warehouseList.stream().map(WarehouseDto::of).collect(Collectors.toList());

        Optional<Warehouse> warehouseOptional = warehouseList.stream().filter(x -> idWarehouse.equals(x.getIdWarehouse())).findFirst();
        Warehouse selectedWarehouse = warehouseOptional.get();

        List<ItemDto> itemDtoList = selectedWarehouse.getItems().stream().map(ItemDto::of).collect(Collectors.toList());

        WarehouseModuleDto warehouseModuleDto = new WarehouseModuleDto(WarehouseDto.of(selectedWarehouse), warehouseDtoList, itemDtoList);
        return warehouseModuleDto;
    }

}
