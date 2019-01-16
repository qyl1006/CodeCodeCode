package cn.wolfcode.ssm.service;

import cn.wolfcode.ssm.domain.Employee;
import cn.wolfcode.ssm.query.EmployeeQueryObject;
import cn.wolfcode.ssm.query.PageResult;

public interface IEmployeeService {
    void insertOrUpdate(Employee entity);
    void deleteById(Long id);

    PageResult queryAll(EmployeeQueryObject qo);

    void saveOrUpdate(Employee employee);

    Employee getById(Long id);
}
