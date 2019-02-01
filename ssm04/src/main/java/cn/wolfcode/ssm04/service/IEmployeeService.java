package cn.wolfcode.ssm04.service;

import cn.wolfcode.ssm04.domain.Employee;
import cn.wolfcode.ssm04.query.EmployeeQueryObject;
import cn.wolfcode.ssm04.query.ResultPage;

/**
 * Employee接口
 */
public interface IEmployeeService {

    /**
     * 根据查询条件 查 页面结果集
     * @param qo
     * @return
     */
    ResultPage queryAll(EmployeeQueryObject qo);

    /**
     * 获取
     * @param id
     * @return
     */
    Employee get(Long id);

    /**
     * 新增 或 编辑
     * @param employee
     */
    void saveOrUpdate(Employee employee);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);
}
