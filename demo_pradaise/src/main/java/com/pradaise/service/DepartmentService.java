package com.pradaise.service;

import com.pradaise.dto.DepartmentDto;
import com.pradaise.entity.Department;

import java.util.List;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentdto);
    DepartmentDto getByIdDepartment(Integer id);
    List<DepartmentDto> getAllDepartments();
    DepartmentDto updateDepartment(Integer id,DepartmentDto departmentdto);
    void deleteDepartment(Integer id);
}
