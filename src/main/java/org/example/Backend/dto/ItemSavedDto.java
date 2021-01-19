package org.example.backend.dto;

import lombok.Data;

@Data
public class ItemSavedDto {

    private String name;
    private Double quantity;
    private Long idQuantityType;
    private Long idWarehouse;
}
