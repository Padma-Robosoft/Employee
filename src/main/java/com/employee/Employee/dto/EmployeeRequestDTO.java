package com.employee.Employee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeRequestDTO {
    private int employeeId;
    private String name;
    private String designation;
    private String department;
    private double salary;

}
