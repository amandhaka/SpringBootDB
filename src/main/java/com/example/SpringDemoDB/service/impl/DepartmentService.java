package com.example.SpringDemoDB.service.impl;

import com.example.SpringDemoDB.dto.DepartmentRequestDto;
import com.example.SpringDemoDB.dto.DepartmentResponseDto;
import com.example.SpringDemoDB.entity.Department;

public interface DepartmentService {
    DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto);

    //DepartmentResponseDto getDepartmentById(Long id);

    Department getDepartmentById(Long id);
}
