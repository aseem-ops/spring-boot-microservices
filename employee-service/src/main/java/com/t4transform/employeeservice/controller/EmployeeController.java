package com.t4transform.employeeservice.controller;

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
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private WebClient webClient;


    @PostMapping(value = "createEmployee")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @GetMapping(value = "getEmployees")
    public List<Employee> getEmployees(){
        return employeeService.getAllEmployee();
    }

    @GetMapping(value = "getEmployeeByDepartmentCode")
    public EmployeeDto getEmployeeByDepartmentCode(@RequestParam String departmentCode){
        Employee employee = employeeService.getEmployeeByDepartmentCode(departmentCode);
        return Mapper.mapEmployeetoEmployeeDTO(employee);
    }

    @GetMapping(value = "getByDepartmentCode")
    public ResponseEntity<APIResponseDto> getByDepartmentCode(@RequestParam String departmentCode){
        Employee employee = employeeService.getEmployeeByDepartmentCode(departmentCode);
        EmployeeDto dto = Mapper.mapEmployeetoEmployeeDTO(employee);
        DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8082/getByDepartmentCode?departmentCode=IT101")
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setEmployeeDto(dto);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }



}
