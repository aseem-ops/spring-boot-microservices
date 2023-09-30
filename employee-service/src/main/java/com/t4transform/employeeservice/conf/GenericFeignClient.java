package com.t4transform.employeeservice.conf;

import com.t4transform.employeeservice.model.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface GenericFeignClient {
    @GetMapping(value = "getByDepartmentCode")
    DepartmentDto getDepartmentByCode(@RequestParam String departmentCode);
}
