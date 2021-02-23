package com.example.SpringDemoDB.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponseDto {
    private Long id;
    private String name;
    private String departmentName;
}
