package com.java.employeeManager.repository;

import com.java.employeeManager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//findBy getBy , readBy
}
