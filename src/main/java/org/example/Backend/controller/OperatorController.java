package org.example.backend.controller;

import lombok.RequiredArgsConstructor;
import org.example.backend.entity.Operator;
import org.example.backend.repository.OperatorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OperatorController {

    private final OperatorRepository operatorRepository;

    @PostMapping("/operators")
    Operator newOperator(@RequestBody Operator newOperator){
        return operatorRepository.save(newOperator);
    }

    @GetMapping("/operators")
    List<Operator> listOperators(){
        return operatorRepository.findAll();
    }

    @DeleteMapping("/operators")
    ResponseEntity deleteOperator(@RequestBody Long idOperator){
        operatorRepository.deleteById(idOperator);
        return ResponseEntity.ok().build();
    }
}
