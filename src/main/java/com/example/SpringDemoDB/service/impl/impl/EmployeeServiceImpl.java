package com.example.SpringDemoDB.service.impl.impl;

import com.example.SpringDemoDB.dto.DepartmentResponseDto;
import com.example.SpringDemoDB.dto.EmployeeRequestDto;
import com.example.SpringDemoDB.dto.EmployeeResponseDto;
import com.example.SpringDemoDB.entity.Department;
import com.example.SpringDemoDB.entity.Employee;
import com.example.SpringDemoDB.respository.DepartmentRepository;
import com.example.SpringDemoDB.respository.EmployeeRepository;
import com.example.SpringDemoDB.service.impl.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public EmployeeResponseDto createEmployee(EmployeeRequestDto employeeRequestDto){

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeRequestDto,employee);
        Optional<Department> departmentOptional = departmentRepository.findById(employeeRequestDto.getDepartment().getId());

        if(departmentOptional.isPresent()){
            employee.setDepartment(departmentOptional.get());
        } else {
            Department department=new Department();
            department.setDName(employeeRequestDto.getDepartment().getDName());
            employee.setDepartment(department);
        }

        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeResponseDto responseDto = new EmployeeResponseDto();
        BeanUtils.copyProperties(savedEmployee,responseDto);
        DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto();
        departmentResponseDto.setId(savedEmployee.getDepartment().getId());
        departmentResponseDto.setDName(savedEmployee.getDepartment().getDName());
        responseDto.setDepartment(departmentResponseDto);

        return responseDto;
    }

    @Override
    public EmployeeResponseDto getEmployeeById(Long id){

        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if(employeeOptional.isPresent()){
            EmployeeResponseDto responseDto = new EmployeeResponseDto();
            BeanUtils.copyProperties(employeeOptional.get(),responseDto);

            return responseDto;
        }

        return null;
    }

    @Override
    public EmployeeResponseDto updateEmployeeById(long id,EmployeeRequestDto employeeRequestDto){

        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if(employeeOptional.isPresent()){
            Employee employeeFromDb = employeeOptional.get();
            employeeFromDb.setName(employeeRequestDto.getName());
            Optional<Department> departmentOptional = departmentRepository.findById(employeeRequestDto.getDepartment().getId());

            if(departmentOptional.isPresent()){
                employeeFromDb.setDepartment(departmentOptional.get());
            } else {
                Department department = new Department();
                department.setDName(employeeRequestDto.getDepartment().getDName());
                employeeFromDb.setDepartment(department);
            }

            Employee savedEmployee = employeeRepository.save(employeeFromDb);
            EmployeeResponseDto responseDto = new EmployeeResponseDto();
            BeanUtils.copyProperties(savedEmployee,responseDto);
            responseDto.setDepartmentFromEntity(savedEmployee.getDepartment());

            return responseDto;
        }

        return null;
    }

    @Override
    public EmployeeResponseDto deleteEmployeeById(long id){

        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if(employeeOptional.isPresent()){
            Employee employeeFromDb = employeeOptional.get();
            EmployeeResponseDto responseDto = new EmployeeResponseDto();
            BeanUtils.copyProperties(employeeFromDb,responseDto);
            employeeRepository.deleteById(id);

            return responseDto;
        }

        return null;
    }
    @Override
    public List<EmployeeResponseDto> getEmployeeListByDepartment(Long departmentId){

        List<Employee> employeeList = employeeRepository.getEmployeeListByNativeQuery(departmentId);
        List<EmployeeResponseDto> employeeResponseDtoList = new ArrayList<>();

        for(Employee employee:employeeList){

            EmployeeResponseDto responseDto = new EmployeeResponseDto();
            BeanUtils.copyProperties(employee,responseDto);
            responseDto.setDepartmentFromEntity(employee.getDepartment());
            employeeResponseDtoList.add(responseDto);

        }

        return employeeResponseDtoList;

    }

    //Get Employee with Most Experience
    @Override
    public List<EmployeeResponseDto> getEmployeeListByExperience(){

        List<Employee> employeeList = employeeRepository.getEmployeeWithMostExperienceByNativeQuery();
        List<EmployeeResponseDto> employeeResponseDtoList=new ArrayList<>();

        for(Employee employee:employeeList){

            EmployeeResponseDto responseDto = new EmployeeResponseDto();
            BeanUtils.copyProperties(employee,responseDto);
            responseDto.setDepartmentFromEntity(employee.getDepartment());
            employeeResponseDtoList.add(responseDto);

        }

        return employeeResponseDtoList;
    }
}
