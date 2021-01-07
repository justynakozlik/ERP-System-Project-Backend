package org.example.backend.repository;

import org.example.backend.entity.QuantityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuantityTypeRepository extends JpaRepository<QuantityType, Long> {
}
