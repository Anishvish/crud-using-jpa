package com.jpa.crud.employee.service;

import com.jpa.crud.employee.exception.RecordNotFoundException;
import com.jpa.crud.employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee createOrUpdate(Employee employee);

    void deleteEmployeeById(Long id) throws RecordNotFoundException;

    Employee getEmployeeById(Long id) throws RecordNotFoundException;
}
