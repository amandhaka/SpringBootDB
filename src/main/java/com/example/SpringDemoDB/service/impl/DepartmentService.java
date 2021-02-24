package com.example.SpringDemoDB.service.impl;

import com.example.SpringDemoDB.dto.DepartmentRequestDto;
import com.example.SpringDemoDB.dto.DepartmentResponseDto;

public interface DepartmentService {
    DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto);

    DepartmentResponseDto getDepartmentById(Long id);
}
