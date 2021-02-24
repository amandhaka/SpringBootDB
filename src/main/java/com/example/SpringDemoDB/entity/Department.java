package com.example.SpringDemoDB.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity(name="Department")
@Getter
@Setter
public class Department {
    @Id
    @GenericGenerator(name = "department_id_seq" , strategy = "increment")
    @GeneratedValue(generator="department_id_seq",strategy = GenerationType.AUTO)
    private Long id;
    private String dName;

//    @JoinColumn(referencedColumnName = "id", name = "department_Id")
//    @OneToMany
//    List<Employee> employeeList;

}
