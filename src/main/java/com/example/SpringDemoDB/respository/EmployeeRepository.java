package com.example.SpringDemoDB.respository;

import com.example.SpringDemoDB.dto.EmployeeResponseDto;
import com.example.SpringDemoDB.entity.Department;
import com.example.SpringDemoDB.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
    List<Employee> findByDepartment(Department department);
}
