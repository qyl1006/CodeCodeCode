package cn.wolfcode.ssm03.mapper;

import cn.wolfcode.ssm03.domain.Employee;
import cn.wolfcode.ssm03.query.EmployeeQueryObject;

import java.util.List;

public interface EmployeeMapper {
    /**
     * 根据qo条件查询总数据量
     * @param qo
     * @return
     */
    int queryCount(EmployeeQueryObject qo);

    /**
     * 根据qo条件查询所有数据的List集合
     * @param qo
     * @return
     */
    List<Employee> listAll(EmployeeQueryObject qo);

    /**
     * 新增
     * @param employee
     */
    void save(Employee employee);

    /**
     * 更新
     * @param employee
     */
    void update(Employee employee);
}
