package com.employee.Employee.service;

import com.employee.Employee.dto.APIResponseDTO;
import com.employee.Employee.dto.EmployeeRequestDTO;
import com.employee.Employee.dto.EmployeeResponseDTO;
import com.employee.Employee.exception.CustomException;
import com.employee.Employee.model.Employee;
import com.employee.Employee.repository.EmployeeRepository;
import com.employee.Employee.util.APIResponseUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class EmployeeServiceImpl implements EmployeeService{

  //  private final List<Employee> employeeList = EmployeeApplication.employeeList;
    private final EmployeeRepository employeeRepository;

    @Value("${employee.notfound}")
    private String employeeNotFoundMessage;

    @Value("${employee.noemployees}")
    private String noEmployeesFoundMessage;

    @Value("${response.employeeAdded}")
    private String employeeAddedMessage;

    @Value("${response.employeeUpdated}")
    private String employeeUpdatedMessage;

    @Value("${response.employeeDeleted}")
    private String employeeDeletedMessage;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public ResponseEntity<APIResponseDTO<List<EmployeeResponseDTO>>> getAllEmployeeDetails() {
        List<Employee> employees=employeeRepository.findAll();
        if (employees.isEmpty()) {
            throw new CustomException(noEmployeesFoundMessage);
        }
        List<EmployeeResponseDTO> response = employees.stream()
                .map(employee -> new EmployeeResponseDTO(
                        employee.getEmployeeId(),
                        employee.getName(),
                        employee.getDesignation(),
                        employee.getDepartment()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(APIResponseUtil.successResponse(response));
    }

    public ResponseEntity<APIResponseDTO<EmployeeResponseDTO>> getEmployeeById(int employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new CustomException(String.format(employeeNotFoundMessage, employeeId)));
        EmployeeResponseDTO responseDTO = new EmployeeResponseDTO(
                employee.getEmployeeId(),
                employee.getName(),
                employee.getDesignation(),
                employee.getDepartment());
        return  ResponseEntity.ok(APIResponseUtil.successResponse(responseDTO));
    }

    public ResponseEntity<APIResponseDTO<List<EmployeeResponseDTO>>> getFirstEmployees(int count) {
        List<Employee> employees = employeeRepository.findAll().stream()
                .limit(count)
                .collect(Collectors.toList());
        List<EmployeeResponseDTO> response = employees.stream()
                .map(employee -> new EmployeeResponseDTO(
                        employee.getEmployeeId(),
                        employee.getName(),
                        employee.getDesignation(),
                        employee.getDepartment()))
                .collect(Collectors.toList());
        return  ResponseEntity.ok(APIResponseUtil.successResponse(response));
    }

    public ResponseEntity<APIResponseDTO<String>> addEmployee(EmployeeRequestDTO employeeRequest) {
        Employee newEmployee = new Employee(
                employeeRequest.getEmployeeId(),
                employeeRequest.getName(),
                employeeRequest.getDesignation(),
                employeeRequest.getDepartment(),
                employeeRequest.getSalary());
                employeeRepository.save(newEmployee);
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(APIResponseUtil.successResponse(employeeAddedMessage));
    }

    public ResponseEntity<APIResponseDTO<String>> updateEmployee(int employeeId, EmployeeRequestDTO employeeRequest) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new CustomException(String.format(employeeNotFoundMessage, employeeId)));
        employee.setEmployeeId(employeeRequest.getEmployeeId());
        employee.setName(employeeRequest.getName());
        employee.setDesignation(employeeRequest.getDesignation());
        employee.setDepartment(employeeRequest.getDepartment());
        employeeRepository.save(employee);

        return  ResponseEntity.ok(APIResponseUtil.successResponse(employeeUpdatedMessage));
    }

    public ResponseEntity<APIResponseDTO<String>> deleteEmployee(int employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new CustomException(String.format(employeeNotFoundMessage, employeeId)));
        employeeRepository.delete(employee);
        return  ResponseEntity.ok(APIResponseUtil.successResponse(employeeDeletedMessage));
    }
}
