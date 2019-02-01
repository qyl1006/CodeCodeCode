package cn.wolfcode.ssm04.service.impl;

import cn.wolfcode.ssm04.domain.Employee;
import cn.wolfcode.ssm04.mapper.EmployeeMapper;
import cn.wolfcode.ssm04.query.EmployeeQueryObject;
import cn.wolfcode.ssm04.query.ResultPage;
import cn.wolfcode.ssm04.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeImpl implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public ResultPage queryAll(EmployeeQueryObject qo) {
        int dataCount = employeeMapper.queryCount(qo);
        if (dataCount == 0){
            return ResultPage.EMPLY_PAGE;
        }

        List<Employee> data = employeeMapper.queryAll(qo);
        return new ResultPage(qo.getCurrentPage(), qo.getPageSize(), dataCount, data);
    }

    @Override
    public Employee get(Long id) {
        return employeeMapper.get(id);
    }

    @Override
    public void saveOrUpdate(Employee employee) {
        if (employee.getId() == null){
            //新增
            employeeMapper.save(employee);
        }else {
            //编辑
            employeeMapper.update(employee);
        }
    }

    @Override
    public void delete(Long id) {
        employeeMapper.delete(id);
    }
}
