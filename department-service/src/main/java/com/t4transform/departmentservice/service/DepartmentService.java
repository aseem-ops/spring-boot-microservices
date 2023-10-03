package com.t4transform.departmentservice.service;

import com.t4transform.departmentservice.entity.Department;
import com.t4transform.departmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department createDepartment(Department department) {
        Department departmentObj = departmentRepository.save(department);
        return departmentObj;
    }

    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    public Department getDepartmentByDepartmentCode(String departmentCode){
        return departmentRepository.findByDepartmentCode(departmentCode);
    }

}
