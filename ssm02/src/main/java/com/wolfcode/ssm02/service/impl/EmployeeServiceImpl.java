package com.wolfcode.ssm02.service.impl;

import com.wolfcode.ssm02.domain.Employee;
import com.wolfcode.ssm02.mapper.EmployeeMapper;
import com.wolfcode.ssm02.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee getById(Long id) {
        Employee employee = employeeMapper.getById(id);
        return employee;
    }
}
