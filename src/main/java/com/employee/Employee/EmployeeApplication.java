package com.employee.Employee;

import com.employee.Employee.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class EmployeeApplication {

	public static List<Employee> employeeList=new ArrayList<>();

	public static void main(String[] args) {

//		employeeList.add(new Employee(1,"Amaran","Backend Developer","IT",25000));
//		employeeList.add(new Employee(2,"Bhagya","Frontend Developer","IT",15000));
//		employeeList.add(new Employee(3,"Chirag","UI Designer","IT",45000));
//		employeeList.add(new Employee(4,"David","Recruiter","HR",35000));
//		employeeList.add(new Employee(5,"Amaran","Devops","IT",25000));


		SpringApplication.run(EmployeeApplication.class, args);
	}

}
