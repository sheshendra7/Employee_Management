package com.pradaise.mapper;

import com.pradaise.dto.EmployeeDto;
import com.pradaise.entity.Employee;

public class EmployeeMappper {
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employeeDto.getFirstName());
        employeeDto.setLastName(employeeDto.getLastName());
        employeeDto.setEmail(employeeDto.getEmail());
        return employeeDto;
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        return employee;
    }
}
