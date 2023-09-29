package com.t4transform.departmentservice.repository;

import com.t4transform.departmentservice.entity.Department;
import com.t4transform.departmentservice.model.DepartmentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    public Department findByDepartmentCode(String departmentCode);
}
