package com.t4transform.employeeservice.repository;

import com.t4transform.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findByDepartmentCode(String departmentCode);
}
