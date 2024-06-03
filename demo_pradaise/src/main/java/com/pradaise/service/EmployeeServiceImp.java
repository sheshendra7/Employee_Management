package com.pradaise.service;

import com.pradaise.Exception.ResourceNotFoundException;
import com.pradaise.dto.EmployeeDto;
import com.pradaise.entity.Employee;
import com.pradaise.mapper.EmployeeMappper;
import com.pradaise.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImp implements EmployeeService {

@Autowired
private final EmployeeRepository employeeRepository ;

    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        System.out.println("Employee Service"+"Fist Name = "+employeeDto.getFirstName()+"Last Name =  "+employeeDto.getLastName()+"Email = "+employeeDto.getEmail());
        Employee employee = EmployeeMappper.mapToEmployee(employeeDto);
        System.out.println("Employee Mapper"+"Fist Name = "+employee.getFirstName()+"Last Name =  "+employee.getLastName()+"Email = "+employee.getEmail());
        Employee savedEmployee = employeeRepository.save(employee);
        System.out.println("Saved Employee"+"Fist Name = "+savedEmployee.getFirstName()+"Last Name =  "+savedEmployee.getLastName()+"Email = "+savedEmployee.getEmail());
        return EmployeeMappper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto  getByIdEmployee(Long id) {
//        Employee employeeLi = null;
//        try {
//            employeeLi = employeeRepository.findById(id).orElseThrow(() ->
//                    new ResourceNotFoundException("Not Found" + id));
//        } catch (ResourceNotFoundException Exc) {
//            System.out.println(Exc);
//        }
//        return EmployeeMappper.mapToEmployeeDto(employeeLi);
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Not Found"+id)
        );
        return EmployeeMappper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
       List<Employee> listOfEmployee = employeeRepository.findAll();
//        List<EmployeeDto> listOfEmployeeDto = new ArrayList<>();
//        for(Employee emp : listOfEmployee) {
//            listOfEmployeeDto.add(EmployeeMappper.mapToEmployeeDto(emp));
//        }
//        return listOfEmployeeDto;

        return listOfEmployee.stream().map((employee) -> EmployeeMappper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
//        Optional<Employee> employeeOptional = employeeRepository.findById(id);
//        if(employeeOptional.isPresent()){
//            Employee employeeExisting = employeeOptional.get();
//            employeeExisting.setFirstName(updatedEmployee.getFirstName());
//            employeeExisting.setLastName(updatedEmployee.getLastName());
//            employeeExisting.setEmail(updatedEmployee.getEmail());
//            return EmployeeMappper.mapToEmployeeDto(employeeRepository.save(employeeExisting));
//        }else{
//            throw new RuntimeException("Employee Not Found");
//        }
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Not Found"+id)
        );
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        Employee employee1 = employeeRepository.save(employee);

        return EmployeeMappper.mapToEmployeeDto(employee1);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Not Found"+id)
        );
        employeeRepository.deleteById(id);
    }
}
