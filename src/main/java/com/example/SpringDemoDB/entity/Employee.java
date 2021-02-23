package com.example.SpringDemoDB.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="FebEmployee")
@Getter
@Setter
public class Employee {

    @Id
    @GenericGenerator(name = "employee_id_seq" , strategy = "increment")
    @GeneratedValue(generator="employee_id_seq",strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String departmentName;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Long getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
