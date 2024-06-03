package com.pradaise.controller;

import com.pradaise.dto.DepartmentDto;
import com.pradaise.service.DepartmentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    private DepartmentServiceImp departmentServiceImp;

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto saveDepartmentDto = departmentServiceImp.createDepartment(departmentDto);
        return new ResponseEntity<>(saveDepartmentDto, HttpStatus.CREATED);
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<DepartmentDto> getByIdDepartment(@PathVariable("id") Integer id){
        DepartmentDto departmentDto = departmentServiceImp.getByIdDepartment(id);
        return ResponseEntity.ok(departmentDto);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartment(){
        List<DepartmentDto> departments = departmentServiceImp.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    @PutMapping("/department/{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Integer id, @RequestBody DepartmentDto dto){
        DepartmentDto departmentDto = departmentServiceImp.updateDepartment(id,dto);
        return ResponseEntity.ok(departmentDto);
    }

    @DeleteMapping("/department/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Integer id){
        departmentServiceImp.deleteDepartment(id);
        return ResponseEntity.ok("Deleted Department");
    }
}
