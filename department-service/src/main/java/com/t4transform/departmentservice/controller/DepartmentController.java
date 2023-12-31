package com.t4transform.departmentservice.controller;

import com.t4transform.departmentservice.entity.Department;
import com.t4transform.departmentservice.model.DepartmentDto;
import com.t4transform.departmentservice.service.DepartmentService;
import com.t4transform.departmentservice.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/v1/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping(value = "createDepartment")
    public Department createDepartment(@RequestBody Department department){
         return departmentService.createDepartment(department);
    }

    @GetMapping(value = "getDepartments")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping(value = "getByDepartmentCode")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@RequestParam String departmentCode){
        Department department = departmentService.getDepartmentByDepartmentCode(departmentCode);
        return new ResponseEntity<>(Mapper.mapDepartmentToDepartmentDTO(department), HttpStatus.OK) ;
    }

}
