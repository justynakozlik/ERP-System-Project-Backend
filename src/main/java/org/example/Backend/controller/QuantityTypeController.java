package org.example.backend.controller;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.QuantityTypeDto;
import org.example.backend.entity.QuantityType;
import org.example.backend.repository.QuantityTypeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class QuantityTypeController {

    private final QuantityTypeRepository quantityTypeRepository;

    @PostMapping("/quantityTypes")
    public QuantityType newQuantityType(@RequestBody QuantityType newQuantityType) {
        return quantityTypeRepository.save(newQuantityType);
    }

    @GetMapping("/quantityTypes")
    public List<QuantityTypeDto> listQuantityTypes() {
        return quantityTypeRepository.findAll().stream().map(QuantityTypeDto::of).collect(Collectors.toList());
    }

    @DeleteMapping("/quantityTypes")
    public ResponseEntity deleteQuantityType(@RequestBody Long idQuantityType) {
        quantityTypeRepository.deleteById(idQuantityType);
        return ResponseEntity.ok().build();
    }
}