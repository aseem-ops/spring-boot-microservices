package com.t4transform.employeeservice.service;

import com.t4transform.employeeservice.entity.Employee;
import com.t4transform.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeByDepartmentCode(String departmentCode){
        return employeeRepository.findByDepartmentCode(departmentCode);
    }
}
