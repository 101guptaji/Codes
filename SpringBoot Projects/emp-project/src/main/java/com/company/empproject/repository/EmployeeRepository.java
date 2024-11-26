package com.company.empproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.empproject.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository <EmployeeEntity, Long> {
    //contains CRUD methods = save, delete, finbyId, findall
    
    //cutom method
    //List<EmployeeEntity> findByName(String name);
}
