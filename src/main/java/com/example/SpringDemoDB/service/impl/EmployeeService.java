package com.example.SpringDemoDB.service.impl;

import com.example.SpringDemoDB.dto.EmployeeRequestDto;
import com.example.SpringDemoDB.dto.EmployeeResponseDto;

public interface EmployeeService {
    EmployeeResponseDto createEmployee(EmployeeRequestDto employeeRequestDto);
    EmployeeResponseDto getEmployeeById(Long id);
    EmployeeResponseDto updateEmployeeById(long id, EmployeeRequestDto employeeRequestDto);
    EmployeeResponseDto deleteEmployeeById(long id);
}
