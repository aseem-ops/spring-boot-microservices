package com.t4transform.employeeservice.util;

import com.t4transform.employeeservice.entity.Employee;
import com.t4transform.employeeservice.model.EmployeeDto;

public class Mapper {
    public static EmployeeDto mapEmployeetoEmployeeDTO(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setDepartmentCode(employee.getDepartmentCode());
        return employeeDto;
    }
}
