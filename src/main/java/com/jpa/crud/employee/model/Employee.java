package com.jpa.crud.employee.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empNo;
    private String erName;
    private Integer salary;
    private String job;
    private Integer deptNo;
}
