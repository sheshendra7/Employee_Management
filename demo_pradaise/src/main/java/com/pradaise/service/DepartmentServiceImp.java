package com.pradaise.service;

import com.pradaise.Exception.ResourceNotFoundException;
import com.pradaise.dto.DepartmentDto;
import com.pradaise.entity.Department;
import com.pradaise.mapper.DepartmentMapper;
import com.pradaise.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImp implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentServiceImp(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentdto) {
        Department department = DepartmentMapper.mapToDepartment(departmentdto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getByIdDepartment(Integer id) {
        Department department = departmentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Not Found Department"+id)
        );
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> listOfDepartment = departmentRepository.findAll();
        return listOfDepartment.stream().map((department) -> DepartmentMapper.mapToDepartmentDto(department)).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Integer id, DepartmentDto departmentdto) {
       Department department = departmentRepository.findById(id).orElseThrow(
               () -> new ResourceNotFoundException("Not Found Department"+id)
       );
       department.setDepartmentName(departmentdto.getDepartmentName());
       department.setDepartmentDescription(departmentdto.getDepartmentDescription());

       return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public void deleteDepartment(Integer id) {
        Department department = departmentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Not Found Department"+id)
        );
        departmentRepository.deleteById(id);
    }
}
