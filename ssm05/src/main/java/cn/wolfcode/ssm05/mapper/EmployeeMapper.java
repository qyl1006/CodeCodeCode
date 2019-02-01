package cn.wolfcode.ssm05.mapper;

import cn.wolfcode.ssm05.domain.Employee;
import cn.wolfcode.ssm05.query.EmployeeQueryObject;

import java.util.List;

public interface EmployeeMapper {

    /**
     * 根据查询条件 查询主数据条数
     * @param qo
     * @return
     */
    int queryCount(EmployeeQueryObject qo);

    /**
     * 根据查询条件 查询总数据
     * @param qo
     * @return
     */
    List<Employee> queryAll(EmployeeQueryObject qo);

    /**
     * 根据ID 获取Employee对象
     * @param id
     * @return
     */
    Employee get(Long id);

    /**
     * 保存
     * @param employee
     */
    void save(Employee employee);

    /**
     * 更新
     * @param employee
     */
    void update(Employee employee);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);
}
