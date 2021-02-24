package com.example.SpringDemoDB.respository;

import com.example.SpringDemoDB.entity.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department,Long> {
}
