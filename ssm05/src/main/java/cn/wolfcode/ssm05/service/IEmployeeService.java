package cn.wolfcode.ssm05.service;

import cn.wolfcode.ssm05.domain.Employee;
import cn.wolfcode.ssm05.query.EmployeeQueryObject;
import cn.wolfcode.ssm05.query.ResultPage;

public interface IEmployeeService {

    /**
     * 根据查询条件查询所有 得到结果页面
     * @param qo
     * @return
     */
    ResultPage queryAll(EmployeeQueryObject qo);

    /**
     * 根据ID 获取Employee
     * @param id
     * @return
     */
    Employee get(Long id);

    /**
     * 新增或更新
     * @param employee
     */
    void saveOrUpdate(Employee employee);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);
}
