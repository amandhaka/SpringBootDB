package com.example.SpringDemoDB.controller;

import com.example.SpringDemoDB.dto.EmployeeRequestDto;
import com.example.SpringDemoDB.dto.EmployeeResponseDto;
import com.example.SpringDemoDB.entity.Employee;
import com.example.SpringDemoDB.service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public EmployeeResponseDto createEmployee(@RequestBody EmployeeRequestDto employeeRequestDto){
        return employeeService.createEmployee(employeeRequestDto);
    }

    @GetMapping(value="/{id}")
    public EmployeeResponseDto getEmployeeById(@PathVariable("id") long id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public EmployeeResponseDto updateEmployee(@PathVariable("id") long id, @RequestBody EmployeeRequestDto employeeRequestDto){
        return employeeService.updateEmployeeById(id,employeeRequestDto);
    }

    @DeleteMapping("/{id}")
    public EmployeeResponseDto deleteEmployee(@PathVariable("id") long id){
        return employeeService.deleteEmployeeById(id);
    }
}
