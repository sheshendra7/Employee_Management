package com.pradaise.service;

import com.pradaise.dto.EmployeeDto;
import com.pradaise.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getByIdEmployee(Long id);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee(Long id,EmployeeDto updatedEmployee);
    void deleteEmployee(Long id);
}
