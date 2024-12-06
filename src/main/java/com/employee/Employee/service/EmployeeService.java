package com.employee.Employee.service;


import com.employee.Employee.dto.APIResponseDTO;
import com.employee.Employee.dto.EmployeeRequestDTO;
import com.employee.Employee.dto.EmployeeResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    ResponseEntity<APIResponseDTO<List<EmployeeResponseDTO>>> getAllEmployeeDetails();
    ResponseEntity<APIResponseDTO<EmployeeResponseDTO>> getEmployeeById(int employeeId);

    ResponseEntity<APIResponseDTO<List<EmployeeResponseDTO>>> getFirstEmployees(int count);
    ResponseEntity<APIResponseDTO<String>> addEmployee(EmployeeRequestDTO employeeRequest);
    ResponseEntity<APIResponseDTO<String>> updateEmployee(int employeeId, EmployeeRequestDTO employeeRequest);
    ResponseEntity<APIResponseDTO<String>> deleteEmployee(int employeeId);


}
