package com.example.SpringDemoDB.service.impl.impl;

import com.example.SpringDemoDB.dto.DepartmentRequestDto;
import com.example.SpringDemoDB.dto.DepartmentResponseDto;
import com.example.SpringDemoDB.dto.EmployeeResponseDto;
import com.example.SpringDemoDB.entity.Department;
import com.example.SpringDemoDB.entity.Employee;
import com.example.SpringDemoDB.respository.DepartmentRepository;
import com.example.SpringDemoDB.respository.EmployeeRepository;
import com.example.SpringDemoDB.service.impl.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto){

        Department department = new Department();
        BeanUtils.copyProperties(departmentRequestDto,department);
        Department savedDepartment = departmentRepository.save(department);
        DepartmentResponseDto responseDto = new DepartmentResponseDto();
        BeanUtils.copyProperties(responseDto,savedDepartment);
        return responseDto;

    }

    @Override
    public Department getDepartmentById(Long id){
        return departmentRepository.findById(id).get();
    }

    @Override
    @Transactional
    public DepartmentResponseDto updateDepartment(Long departmentId,DepartmentRequestDto departmentRequestDto){

        Department department = departmentRepository.findById(departmentId).get();
        List<Employee> employeeList = employeeRepository.findByDepartment_Id(departmentId);
        department.setDName(departmentRequestDto.getDName());
        Department savedDepartment = departmentRepository.save(department);
        employeeList.forEach(employee-> {
            employee.setCode(departmentRequestDto.getDepartmentCode());
        });
        employeeRepository.saveAll(employeeList);
        DepartmentResponseDto responseDto = new DepartmentResponseDto();
        BeanUtils.copyProperties(savedDepartment,responseDto);
        return responseDto;

    }

    //Get Most Experience Employee Within Department
    @Override
    public List<EmployeeResponseDto> getMostExperiencedEmployeeWithinDepartment(Long departmentId){

        List<Employee> employeeList = employeeRepository.getMostExperienceEmployeeFromDepartment(departmentId);
        List<EmployeeResponseDto> employeeResponseDtoList = new ArrayList<>();

        for(Employee employee: employeeList){

            EmployeeResponseDto responseDto = new EmployeeResponseDto();
            Department department = employee.getDepartment();
            BeanUtils.copyProperties(employee,responseDto);
            responseDto.setDepartmentFromEntity(department);
            employeeResponseDtoList.add(responseDto);

        }

        return employeeResponseDtoList;

    }

    //Get Department with Max of sum of year of experience of employees
    @Override
    public List<DepartmentResponseDto> getDepartmentWithMostExperience(){

        List<Department> departmentList = departmentRepository.getMostExperiencedDepartmentList();
        List<DepartmentResponseDto> responseDtoList = new ArrayList<>();

        for(Department department : departmentList){

            DepartmentResponseDto  responseDto = new DepartmentResponseDto();
            BeanUtils.copyProperties(department,responseDto);
            responseDtoList.add(responseDto);

        }

        return responseDtoList;

    }
}