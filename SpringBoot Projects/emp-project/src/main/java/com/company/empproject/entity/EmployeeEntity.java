package com.company.empproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="emp_table") //create a table of name if not exists
public class EmployeeEntity {

    @Id //make id as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto assign id value to data
    private Long id;

    private String name;
    private String email;
    private String phoneNo;
}
