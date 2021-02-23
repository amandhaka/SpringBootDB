package com.example.SpringDemoDB.respository;

import com.example.SpringDemoDB.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
}
