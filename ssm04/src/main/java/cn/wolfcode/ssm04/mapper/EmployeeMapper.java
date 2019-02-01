package cn.wolfcode.ssm04.mapper;

import cn.wolfcode.ssm04.domain.Employee;
import cn.wolfcode.ssm04.query.EmployeeQueryObject;

import java.util.List;

public interface EmployeeMapper {
    /**
     * 查询符合条件的数据条数
     * @param qo
     * @return
     */
    int queryCount(EmployeeQueryObject qo);

    /**
     * 查询符合条件的数据集合List
     * @param qo
     * @return
     */
    List<Employee> queryAll(EmployeeQueryObject qo);

    /**
     * 获取
     * @param id
     * @return
     */
    Employee get(Long id);

    /**
     * 新增
     * @param employee
     */
    void save(Employee employee);

    /**
     * 编辑
     * @param employee
     */
    void update(Employee employee);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);
}
