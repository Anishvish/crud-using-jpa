package com.jpa.crud.employee.service.impl;

import com.jpa.crud.employee.exception.RecordNotFoundException;
import com.jpa.crud.employee.model.Employee;
import com.jpa.crud.employee.repository.EmployeeRepository;
import com.jpa.crud.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee createOrUpdate(Employee employee) {

        Optional<Employee> employeeData = repository.findById(employee.getEmpNo());
        if (employeeData.isPresent()) {
            Employee newEntity = employeeData.get();
            newEntity.setJob(employee.getJob());
            newEntity.setSalary(employee.getSalary());
            newEntity.setDeptNo(employee.getDeptNo());
            newEntity.setErName(employee.getErName());
            return repository.save(employee);
        } else {
            return repository.save(employee);
        }
    }

    @Override
    public void deleteEmployeeById(Long id) throws RecordNotFoundException {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    @Override
    public Employee getEmployeeById(Long id) throws RecordNotFoundException {
        Optional<Employee> employee = repository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else
            throw new RecordNotFoundException("No employee record exist for given id");
    }
}
