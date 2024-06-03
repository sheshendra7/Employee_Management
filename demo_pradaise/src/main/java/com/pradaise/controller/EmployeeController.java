package com.pradaise.controller;

import com.pradaise.dto.EmployeeDto;
import com.pradaise.service.EmployeeService;
import com.pradaise.service.EmployeeServiceImp;
import com.sun.tools.jconsole.JConsoleContext;
import com.sun.tools.jconsole.JConsolePlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImp employeeServiceImp;




     @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto dto){
         EmployeeDto savedEmployee = employeeServiceImp.createEmployee(dto);
         System.out.println("Controller Fist Name = "+dto.getFirstName()+"Last Name =  "+dto.getLastName()+"Email = "+dto.getEmail());
         return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
     }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> getByIdEmployee(@PathVariable("id") Long id){
         EmployeeDto employeeDto = employeeServiceImp.getByIdEmployee(id);
         return ResponseEntity.ok(employeeDto);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
         List<EmployeeDto> employees = employeeServiceImp.getAllEmployees();
         return ResponseEntity.ok(employees);
    }


    @PutMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id,@RequestBody EmployeeDto dto){
         EmployeeDto employeeDto = employeeServiceImp.updateEmployee(id, dto);
         return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
         employeeServiceImp.deleteEmployee(id);
         return ResponseEntity.ok("Deleted Employee");
    }

}
