package org.example.backend.controller;

import lombok.RequiredArgsConstructor;
import org.example.backend.entity.QuantityType;
import org.example.backend.repository.QuantityTypeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuantityTypeController {

    private final QuantityTypeRepository quantityTypeRepository;

    @PostMapping("/quantityTypes")
    public QuantityType newQuanttyType(@RequestBody QuantityType newQuanttyType) {
        return quantityTypeRepository.save(newQuanttyType);
    }

    @GetMapping("/quantityTypes")
    public List<QuantityType> listQuantityTypes() {
        return quantityTypeRepository.findAll();
    }

    @DeleteMapping("/quantityTypes")
    public ResponseEntity deleteQuantityType(@RequestBody Long idQuantityType) {
        quantityTypeRepository.deleteById(idQuantityType);
        return ResponseEntity.ok().build();
    }
}