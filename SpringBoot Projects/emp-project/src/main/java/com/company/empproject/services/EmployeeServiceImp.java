package com.company.empproject.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.empproject.entity.EmployeeEntity;
import com.company.empproject.model.Employee;
import com.company.empproject.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService{
    //List<Employee> empList = new ArrayList<>();
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public String creatEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        //empList.add(employee);
        return "Saved Successfully";
    }

    @Override
    public List<Employee> readEmployees() {
        //return empList;
        List<EmployeeEntity> employeesList = employeeRepository.findAll();
        List<Employee> employees= new ArrayList<>();

        for (EmployeeEntity employeeEntity : employeesList) {
            
            Employee emp = new Employee();
            emp.setId(employeeEntity.getId());
            emp.setName(employeeEntity.getName());
            emp.setEmail(employeeEntity.getEmail());
            emp.setPhoneNo(employeeEntity.getPhoneNo());
          
            employees.add(emp);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity empEntity = employeeRepository.findById(id).get();
        if(empEntity != null){
            employeeRepository.delete(empEntity);
            return true;
        }
        return false;
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        if(employeeEntity != null){
            employeeEntity.setName(employee.getName());
            employeeEntity.setEmail(employee.getEmail());
            employeeEntity.setPhoneNo(employee.getPhoneNo());

            employeeRepository.save(employeeEntity);
            return "Updated successfully";
        }
        return "Not found!";
    }

    @Override
    public Employee readEmployee(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
     
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity,employee);

        return employee;
    }
}
