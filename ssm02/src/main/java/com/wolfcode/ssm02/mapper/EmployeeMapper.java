package com.wolfcode.ssm02.mapper;

import com.wolfcode.ssm02.domain.Employee;
import com.wolfcode.ssm02.query.EmployeeQueryObject;

import java.util.List;

public interface EmployeeMapper {
    Employee getById(Long id);

    void insert(Employee employee);

    void update(Employee employee);

    int queryCount(EmployeeQueryObject qo);

    List<?> queryAll(EmployeeQueryObject qo);

    void deleteById(Long id);
}
