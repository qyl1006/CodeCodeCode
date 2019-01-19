package com.wolfcode.ssm02.service;

import com.wolfcode.ssm02.domain.Employee;
import com.wolfcode.ssm02.query.EmployeeQueryObject;
import com.wolfcode.ssm02.query.ResultPage;

import java.util.List;

public interface IEmployeeService {
    /**
     * 根据ID获取employee对象
     * @param id
     * @return
     */
    Employee getById(Long id);

    /**
     * 更新或新增
     * @param employee
     */
    void saveOrUpdate(Employee employee);


    /**
     * 根据条件查询 得到pageResult
     * @param qo
     * @return
     */
    ResultPage queryAll(EmployeeQueryObject qo);

    /**
     * 删除操作(都是假删除 只是改变状态)
     * @param id
     */
    void deleteById(Long id);
}
