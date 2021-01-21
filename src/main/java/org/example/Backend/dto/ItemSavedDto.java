package org.example.backend.dto;

import lombok.Data;

@Data
public class ItemSavedDto {

    private Long idItem;
    private String name;
    private Double quantity;
    private Long idQuantityType;
    private Long idWarehouse;
}
