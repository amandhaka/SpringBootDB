package com.example.SpringDemoDB.service.impl;

import com.example.SpringDemoDB.dto.DepartmentJoinEmployeeResponseDto;
import com.example.SpringDemoDB.dto.DepartmentRequestDto;
import com.example.SpringDemoDB.dto.DepartmentResponseDto;
import com.example.SpringDemoDB.dto.EmployeeResponseDto;
import com.example.SpringDemoDB.entity.Department;

import java.util.List;

public interface DepartmentService {

    DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto);

    Department getDepartmentById(Long id);

    DepartmentResponseDto updateDepartment(Long departmentId, DepartmentRequestDto departmentRequestDto);

    List<EmployeeResponseDto> getMostExperiencedEmployeeWithinDepartment(Long departmentId);

    List<DepartmentJoinEmployeeResponseDto> getDepartmentWithMostExperience();
}