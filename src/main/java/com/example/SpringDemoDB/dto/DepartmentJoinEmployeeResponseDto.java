package com.example.SpringDemoDB.dto;

import com.example.SpringDemoDB.entity.Employee;
import lombok.Data;

import java.util.List;

@Data
public class DepartmentJoinEmployeeResponseDto {
    private Long id;
    private String departmentName;
    private Long totalSumOfYearOfExperience;
    private List<Employee> employeeList;
}
