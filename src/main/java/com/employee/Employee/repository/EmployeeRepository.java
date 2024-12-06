package com.employee.Employee.repository;

import com.employee.Employee.model.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
