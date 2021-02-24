package com.example.SpringDemoDB.dto;

import com.example.SpringDemoDB.entity.Department;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponseDto {
    private Long id;
    private String name;
    private DepartmentResponseDto department;
    public DepartmentResponseDto setDepartmentFromEntity(Department departmentEntity){
        DepartmentResponseDto departmentResponseDto=new DepartmentResponseDto();
        departmentResponseDto.setId(departmentEntity.getId());
        departmentResponseDto.setDName(departmentEntity.getDName());
        this.department=departmentResponseDto;
        return departmentResponseDto;
    }

}
