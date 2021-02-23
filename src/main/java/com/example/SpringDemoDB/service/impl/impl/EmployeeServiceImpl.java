package com.example.SpringDemoDB.service.impl.impl;

import com.example.SpringDemoDB.dto.EmployeeRequestDto;
import com.example.SpringDemoDB.dto.EmployeeResponseDto;
import com.example.SpringDemoDB.entity.Employee;
import com.example.SpringDemoDB.respository.EmployeeRepository;
import com.example.SpringDemoDB.service.impl.EmployeeService;
import lombok.Builder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeResponseDto createEmployee(EmployeeRequestDto employeeRequestDto){

        Employee employee=new Employee();

        BeanUtils.copyProperties(employeeRequestDto,employee);

        Employee savedEmployee=employeeRepository.save(employee);

        EmployeeResponseDto responseDto=new EmployeeResponseDto();

        BeanUtils.copyProperties(savedEmployee,responseDto);

        return responseDto;
    }

    @Override
    public EmployeeResponseDto getEmployeeById(Long id){
        Optional<Employee> employeeOptional=employeeRepository.findById(id);
        if(employeeOptional.isPresent()){
            //copy from employee to responseDto
            EmployeeResponseDto responseDto=new EmployeeResponseDto();
            BeanUtils.copyProperties(employeeOptional.get(),responseDto);

            return responseDto;
        }
        return null;
    }

    @Override
    public EmployeeResponseDto updateEmployeeById(long id,EmployeeRequestDto employeeRequestDto){
        Optional<Employee> employeeOptional=employeeRepository.findById(id);
        if(employeeOptional.isPresent()){
            Employee employeeFromDb=employeeOptional.get();
            employeeFromDb.setName(employeeRequestDto.getName());
            employeeFromDb.setDepartmentName(employeeRequestDto.getDepartmentName());

            Employee savedEmployee = employeeRepository.save(employeeFromDb);

            EmployeeResponseDto responseDto=new EmployeeResponseDto();
            BeanUtils.copyProperties(savedEmployee,responseDto);
            return responseDto;
        }
        return null;
    }

    @Override
    public EmployeeResponseDto deleteEmployeeById(long id){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isPresent()){
            Employee employeeFromDb = employeeOptional.get();
            EmployeeResponseDto responseDto=new EmployeeResponseDto();
            BeanUtils.copyProperties(employeeFromDb,responseDto);
            employeeRepository.deleteById(id);
            return responseDto;
        }
        return null;
    }
}
