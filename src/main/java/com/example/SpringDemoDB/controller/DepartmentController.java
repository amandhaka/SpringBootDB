package com.example.SpringDemoDB.controller;

import com.example.SpringDemoDB.dto.DepartmentJoinEmployeeResponseDto;
import com.example.SpringDemoDB.dto.DepartmentRequestDto;
import com.example.SpringDemoDB.dto.DepartmentResponseDto;
import com.example.SpringDemoDB.dto.EmployeeResponseDto;
import com.example.SpringDemoDB.entity.Department;
import com.example.SpringDemoDB.service.impl.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Department getDepartmentById(@PathVariable ("id") Long id){
        return departmentService.getDepartmentById(id);
    }

    @PutMapping("/{id}")
    public DepartmentResponseDto updateDepartment(@PathVariable("id") Long departmentId,@RequestBody DepartmentRequestDto departmentRequestDto){
        return departmentService.updateDepartment(departmentId,departmentRequestDto);
    }

    //Getting Most Experienced Employee From Department
    @GetMapping("/{id}/employee/mostExperienced")
    public List<EmployeeResponseDto> getListOfEmployeeWithMostExperienceWithinDepartment(@PathVariable("id") Long departmentId){
        return departmentService.getMostExperiencedEmployeeWithinDepartment(departmentId);
    }

    //Getting Most Experienced Department
    @GetMapping("/mostExperienced")
    public List<DepartmentJoinEmployeeResponseDto> getDepartmentMostExperienced(){
        return departmentService.getDepartmentWithMostExperience();
    }
}


  /*
    @GetMapping(value="/{id}")
    public DepartmentResponseDto getDepartmentById(@PathVariable("id") Long id){
        return departmentService.getDepartmentById(id);
    }
  */