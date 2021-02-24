package com.example.SpringDemoDB.service.impl.impl;

import com.example.SpringDemoDB.dto.DepartmentRequestDto;
import com.example.SpringDemoDB.dto.DepartmentResponseDto;
import com.example.SpringDemoDB.entity.Department;
import com.example.SpringDemoDB.entity.Employee;
import com.example.SpringDemoDB.respository.DepartmentRepository;
import com.example.SpringDemoDB.respository.EmployeeRepository;
import com.example.SpringDemoDB.service.impl.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto){
        Department department=new Department();
        BeanUtils.copyProperties(departmentRequestDto,department);
        Department savedDepartment=departmentRepository.save(department);
        DepartmentResponseDto responseDto=new DepartmentResponseDto();
        BeanUtils.copyProperties(responseDto,savedDepartment);
        return responseDto;
    }

//    @Override
//    public DepartmentResponseDto getDepartmentById(Long id){
//        Optional<Department> departmentOptional=departmentRepository.findById(id);
//        if(departmentOptional.isPresent()){
//            DepartmentResponseDto responseDto=new DepartmentResponseDto();
//            BeanUtils.copyProperties(departmentOptional.get(),responseDto);
//            return responseDto;
//        }
//        return null;
//    }
    @Override
    public Department getDepartmentById(Long id){
       return departmentRepository.findById(id).get();
    }

    @Override
    @Transactional
    public DepartmentResponseDto updateDepartment(Long departmentId,DepartmentRequestDto departmentRequestDto){
        Department department=departmentRepository.findById(departmentId).get();
        List<Employee> employeeList=employeeRepository.findByDepartment_Id(departmentId);

        department.setDName(departmentRequestDto.getDName());

        Department savedDepartment=departmentRepository.save(department);

        employeeList.forEach(employee-> {
            employee.setCode(departmentRequestDto.getDepartmentCode());
        });
        employeeRepository.saveAll(employeeList);

        DepartmentResponseDto responseDto=new DepartmentResponseDto();
        BeanUtils.copyProperties(savedDepartment,responseDto);
        return responseDto;


    }
}

