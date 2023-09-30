package com.t4transform.employeeservice.controller;

import com.t4transform.employeeservice.conf.GenericFeignClient;
import com.t4transform.employeeservice.entity.Employee;
import com.t4transform.employeeservice.model.APIResponseDto;
import com.t4transform.employeeservice.model.DepartmentDto;
import com.t4transform.employeeservice.model.EmployeeDto;
import com.t4transform.employeeservice.service.EmployeeService;
import com.t4transform.employeeservice.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeControllerOpenFeignClient {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private GenericFeignClient genericFeignClient;

    @GetMapping(value = "/getEmployeeByDepartmentCode")
    public ResponseEntity<APIResponseDto> getByDepartmentCode(@RequestParam String departmentCode){
        Employee employee = employeeService.getEmployeeByDepartmentCode(departmentCode);
        EmployeeDto dto = Mapper.mapEmployeetoEmployeeDTO(employee);
        DepartmentDto departmentDto = genericFeignClient.getDepartmentByCode(departmentCode);
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setEmployeeDto(dto);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }



}
