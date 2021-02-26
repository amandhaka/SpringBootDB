package com.example.SpringDemoDB.respository;


import com.example.SpringDemoDB.entity.Department;
import com.example.SpringDemoDB.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department,Long> {

    //Query For getting department with most experienced Employees
    String queryForGettingMostExperiencedDepartment = "SELECT * FROM department d1 where d1.id in (\n" +
            "\n" +
            "SELECT e.department_id  AS year_of_experience\n" +
            "\n" +
            "FROM feb_employee e LEFT JOIN department d \n" +
            "\n" +
            "ON d.id=e.department_id\n" +
            "\n" +
            "GROUP BY d.d_name , e.department_id\n" +
            "\n" +
            "HAVING SUM(CAST(e.year_of_experience AS INT)) = \n" +
            "\n" +
            "\t(SELECT SUM(CAST (e1.year_of_experience AS INT)) \n" +
            "\n" +
            "\tFROM feb_employee e1 GROUP BY e1.department_id\n" +
            "\n" +
            "\tORDER BY SUM(CAST(e1.year_of_experience AS INT)) \n" +
            "\n" +
            "\tDESC FETCH FIRST 1 ROW ONLY)\n" +
            ")\n";

    @Query(value=queryForGettingMostExperiencedDepartment,nativeQuery = true)
    List<Department> getMostExperiencedDepartmentList();
}