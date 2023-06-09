package com.jpa.crud.employee.controller;

import com.jpa.crud.employee.exception.RecordNotFoundException;
import com.jpa.crud.employee.model.Employee;
import com.jpa.crud.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getListOfEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public Employee createOrUpdateEmployee(@RequestBody Employee employee) {
        return employeeService.createOrUpdate(employee);
    }

    @DeleteMapping("/{id}")
    private HttpStatus deleteEmployeeById(@PathVariable("id") Long id) throws RecordNotFoundException {
        employeeService.deleteEmployeeById(id);
        return HttpStatus.OK;
    }

    @GetMapping("/{id}")
    private Employee getEmployeeById(@PathVariable("id") Long id) throws RecordNotFoundException {
        return employeeService.getEmployeeById(id);
    }
}
