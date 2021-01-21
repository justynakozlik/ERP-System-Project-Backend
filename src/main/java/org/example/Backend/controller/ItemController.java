package org.example.backend.controller;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.EmployeeDto;
import org.example.backend.dto.ItemDto;
import org.example.backend.dto.ItemSavedDto;
import org.example.backend.entity.Employee;
import org.example.backend.entity.Item;
import org.example.backend.repository.ItemRepository;
import org.example.backend.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    private final ItemService itemService;

    @PostMapping("/items")
    public ItemDto newItem(@RequestBody ItemSavedDto dto) {
        return ItemDto.of(itemService.saveItem(dto));
    }

    @GetMapping("/items")
    public List<ItemDto> listItems() {
        return itemRepository.findAll()
                .stream()
                .map(ItemDto::of)
                .collect(Collectors.toList());
    }

    @GetMapping("/items/{idItem}")
    public ItemDto getItem(@PathVariable Long idItem) throws InterruptedException {
        Thread.sleep(500);
        Optional<Item> optionalItem = itemRepository.findById(idItem);
        return ItemDto.of(optionalItem.get());
    }

    @DeleteMapping("/items")
    public ResponseEntity deleteItem(@RequestBody Long idItem) {
        itemRepository.deleteById(idItem);
        return ResponseEntity.ok().build();
    }
}
