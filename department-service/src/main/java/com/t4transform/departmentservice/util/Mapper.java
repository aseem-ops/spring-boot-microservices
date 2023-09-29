package com.t4transform.departmentservice.util;

import com.t4transform.departmentservice.entity.Department;
import com.t4transform.departmentservice.model.DepartmentDto;

public class Mapper {
    public static DepartmentDto mapDepartmentToDepartmentDTO(Department department){
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(department.getId());
        departmentDto.setDepartmentName(department.getDepartmentName());
        departmentDto.setDepartmentCode(department.getDepartmentCode());
        departmentDto.setDepartmentDescription(department.getDepartmentName());
        return departmentDto;
    }
}
