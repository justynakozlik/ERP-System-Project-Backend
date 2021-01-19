package org.example.backend.entity;

import lombok.Data;
import org.example.backend.dto.ItemSavedDto;

import javax.persistence.*;

@Entity
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItem;

    @Column
    private String name;

    @Column
    private Double quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idQuantityType")
    private QuantityType quantityType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idWarehouse")
    private Warehouse warehouse;

    public static Item of(ItemSavedDto dto) {
        Item item = new Item();
        item.setName(dto.getName());
        item.setQuantity(dto.getQuantity());
        return item;
    }
}
