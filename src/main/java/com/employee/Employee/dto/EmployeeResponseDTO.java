package com.employee.Employee.dto;


import com.employee.Employee.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeResponseDTO {
    private int employeeId;
    private String name;
    private String designation;
    private String department;


}
