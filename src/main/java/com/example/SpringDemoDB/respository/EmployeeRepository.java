package com.example.SpringDemoDB.respository;

import com.example.SpringDemoDB.dto.EmployeeResponseDto;
import com.example.SpringDemoDB.entity.Department;
import com.example.SpringDemoDB.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
    //1st Method
    List<Employee> findByDepartment(Department department);

    //2nd Method
    List<Employee> findByDepartment_Id(Long departmentId);

    //3rd Method
    @Query("FROM FebEmployee e WHERE e.department.id=?1")
    List<Employee> getEmployeeListByDepartmentId(Long departmentId);

    @Query(value="SELECT * FROM feb_employee e WHERE e.department_id=?1",nativeQuery = true)
    List<Employee> getEmployeeListByNativeQuery(Long departmentId);
}
