package cn.wolfcode.ssm.mapper;

import cn.wolfcode.ssm.domain.Employee;
import cn.wolfcode.ssm.query.EmployeeQueryObject;

import java.util.List;

public interface EmployeeMapper {
    void insert(Employee entity);
    void updateByKey(Employee entity);
    void deleteById(Long id);

    Employee getById(Long id);

    //查询总共多少条数据
    Integer queryCount(EmployeeQueryObject qo);

    List<Employee> queryAll(EmployeeQueryObject qo);


}
