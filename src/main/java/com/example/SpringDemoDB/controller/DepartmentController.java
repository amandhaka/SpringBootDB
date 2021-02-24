package com.example.SpringDemoDB.controller;

import com.example.SpringDemoDB.dto.DepartmentRequestDto;
import com.example.SpringDemoDB.dto.DepartmentResponseDto;
import com.example.SpringDemoDB.service.impl.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public DepartmentResponseDto createDepartment(@RequestBody DepartmentRequestDto departmentRequestDto){
        return departmentService.createDepartment(departmentRequestDto);
    }
    @GetMapping(value="/{id}")
    public DepartmentResponseDto getDepartmentById(@PathVariable("id") Long id){
        return departmentService.getDepartmentById(id);
    }
}
