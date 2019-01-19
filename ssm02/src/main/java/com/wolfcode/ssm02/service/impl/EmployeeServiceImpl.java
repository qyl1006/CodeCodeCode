package com.wolfcode.ssm02.service.impl;

import com.wolfcode.ssm02.domain.Employee;
import com.wolfcode.ssm02.mapper.EmployeeMapper;
import com.wolfcode.ssm02.query.EmployeeQueryObject;
import com.wolfcode.ssm02.query.ResultPage;
import com.wolfcode.ssm02.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee getById(Long id) {
        Employee employee = employeeMapper.getById(id);
        return employee;
    }

    @Override
    public void saveOrUpdate(Employee employee) {
        if (employee.getId() == null){
            //新增
            employeeMapper.insert(employee);
        }else {
            //更新
            employeeMapper.update(employee);
        }
    }

    @Override
    public ResultPage queryAll(EmployeeQueryObject qo) {
        int count = employeeMapper.queryCount(qo);
        if (count == 0){
            return ResultPage.EMPTY_PAGE;
        }
        List<?> data = employeeMapper.queryAll(qo);
        return new ResultPage(qo.getCurrentPage(), qo.getPageSize(), count, data);
    }

    @Override
    public void deleteById(Long id) {
        employeeMapper.deleteById(id);
    }
}
