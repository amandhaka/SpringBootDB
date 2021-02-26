package com.example.SpringDemoDB.respository;

import com.example.SpringDemoDB.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {

    List<Employee> findByDepartment_Id(Long departmentId);

    @Query(value="SELECT * FROM feb_employee e WHERE e.department_id=?1",nativeQuery = true)
    List<Employee> getEmployeeListByNativeQuery(Long departmentId);


    String queryForMostExperiencedEmployee = "SELECT * FROM feb_employee e " +

            "WHERE year_of_experience IN " +

            "(SELECT MAX(year_of_experience) FROM feb_employee e)";

    @Query(value=queryForMostExperiencedEmployee,nativeQuery = true)
    List<Employee> getEmployeeWithMostExperienceByNativeQuery();


    String getQueryForMostExperiencedEmployeeFromDepartment="SELECT * FROM feb_employee e WHERE " +

            "e.department_id=?1 AND e.year_of_experience IN " +

            "( SELECT MAX(e1.year_of_experience) FROM feb_employee e1 WHERE e1.department_id=?1)";

    @Query(value=getQueryForMostExperiencedEmployeeFromDepartment,nativeQuery = true)
    List<Employee> getMostExperienceEmployeeFromDepartment(Long departmentId);

}