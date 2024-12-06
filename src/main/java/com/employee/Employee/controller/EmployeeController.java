package com.employee.Employee.controller;

import com.employee.Employee.dto.APIResponseDTO;
import com.employee.Employee.dto.EmployeeRequestDTO;
import com.employee.Employee.dto.EmployeeResponseDTO;
import com.employee.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<APIResponseDTO<List<EmployeeResponseDTO>>> getAllEmployeeDetails(){
        return employeeService.getAllEmployeeDetails();
    }

    @GetMapping("/details")
    public ResponseEntity<APIResponseDTO<EmployeeResponseDTO>> getEmployeeById(@RequestHeader("employee-id") int employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping("/first")
    public ResponseEntity<APIResponseDTO<List<EmployeeResponseDTO>>> getFirstEmployees(@RequestParam(defaultValue = "3") int count) {
        return employeeService.getFirstEmployees(count);
    }

    @GetMapping("/header")
    public ResponseEntity<String> getEmployeeRoleFromHeader(@RequestHeader(value = "X-Employee-Role", defaultValue = "Unknown") String role) {
        return ResponseEntity.ok("Employee Role from Header: " + role);
    }

    @PostMapping
    public ResponseEntity<APIResponseDTO<String>> addEmployee(@RequestBody EmployeeRequestDTO employeeRequest){
        return employeeService.addEmployee(employeeRequest);
    }

    @PutMapping
    public ResponseEntity<APIResponseDTO<String>> updateEmployee(@RequestHeader("employee-id") int employeeId, @RequestBody EmployeeRequestDTO employeeRequest){
        return employeeService.updateEmployee(employeeId, employeeRequest);
    }

    @DeleteMapping
    public ResponseEntity<APIResponseDTO<String>> deleteEmployee(@RequestHeader("employee-id") int employeeId){
        return employeeService.deleteEmployee(employeeId);
    }
}
