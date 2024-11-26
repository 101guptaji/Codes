package com.company.empproject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.company.empproject.model.Employee;

@Service
public interface EmployeeService {
    String creatEmployee(Employee employee);
    List<Employee> readEmployees();
    boolean deleteEmployee(Long id);
    String updateEmployee(Long id, Employee employee);
    Employee readEmployee(Long id);
}
