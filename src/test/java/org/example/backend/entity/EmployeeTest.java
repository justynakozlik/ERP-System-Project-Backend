package org.example.backend.entity;

import org.example.backend.dto.EmployeeDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class EmployeeTest {

    static EmployeeDto dto;

    @BeforeAll
    public static void init(){
        dto = new EmployeeDto();
        dto.setFirstName("Justyna");
    }

    @Test
    public void givenEmployeeOfMethodWhenUseEmployeeDtoThenReturnEmployeeClassObjectWithTheSameDataAsDtoHas(){
        Employee employee = Employee.of(dto);
        Assertions.assertEquals(employee.getFirstName(), dto.getFirstName());
    }


    @Test
    public void givenUpdateEmployeeMethodWhenUseEmployeeDtoThenDataHasBeenChanged(){
        Employee employee = new Employee();
        employee.setFirstName("Ola");
        employee.updateEmployee(dto);
        Assertions.assertEquals(employee.getFirstName(), dto.getFirstName());
    }

}