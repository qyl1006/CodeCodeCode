package com.wolfcode.ssm02.service;

import com.wolfcode.ssm02.domain.Employee;

public interface IEmployeeService {
    /**
     * 根据ID获取employee对象
     * @param id
     * @return
     */
    Employee getById(Long id);
}
