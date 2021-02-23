package com.example.SpringDemoDB.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequestDto {
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
