package cn.wolfcode.ssm03.service;

import cn.wolfcode.ssm03.domain.Employee;
import cn.wolfcode.ssm03.query.EmployeeQueryObject;
import cn.wolfcode.ssm03.query.ResultPage;

public interface IEmployeeService {
    /**
     * 根据qo条件查询所有数据
     * @param qo
     * @return
     */
    ResultPage queryAll(EmployeeQueryObject qo);

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

    /**
     * 根据ID 获取Employee对象
     * @param id
     * @return
     */
    Employee get(Long id);
}
