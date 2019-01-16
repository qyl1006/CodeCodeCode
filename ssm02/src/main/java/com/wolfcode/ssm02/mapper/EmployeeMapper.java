package com.wolfcode.ssm02.mapper;

import com.wolfcode.ssm02.domain.Employee;

public interface EmployeeMapper {
    Employee getById(Long id);
}
