package com.example.SpringDemoDB.dto;

import com.example.SpringDemoDB.entity.Department;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EmployeeRequestDto {
    private Long id;
    private String name;
    private Department department;
}