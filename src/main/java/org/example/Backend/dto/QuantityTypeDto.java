package org.example.backend.dto;

import lombok.Data;
import org.example.backend.entity.QuantityType;

@Data
public class QuantityTypeDto {

    private Long idQuantityType;
    private String name;

    public static QuantityTypeDto of(QuantityType quantityType){
        QuantityTypeDto dto = new QuantityTypeDto();
        dto.setIdQuantityType(quantityType.getIdQuantityType());
        dto.setName(quantityType.getName());
        return dto;
    }
}
