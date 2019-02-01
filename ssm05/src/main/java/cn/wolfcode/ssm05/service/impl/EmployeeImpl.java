package cn.wolfcode.ssm05.service.impl;

import cn.wolfcode.ssm05.domain.Employee;
import cn.wolfcode.ssm05.mapper.EmployeeMapper;
import cn.wolfcode.ssm05.query.EmployeeQueryObject;
import cn.wolfcode.ssm05.query.ResultPage;
import cn.wolfcode.ssm05.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeImpl implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    public ResultPage queryAll(EmployeeQueryObject qo) {
        int pageCount = employeeMapper.queryCount(qo);
        if (pageCount == 0){
            return ResultPage.EMPLY_PAGE;
        }
        List<Employee> data = employeeMapper.queryAll(qo);
        return new ResultPage(qo.getCurrentPage(), qo.getPageSize(), pageCount, data);
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
            //更新
            employeeMapper.update(employee);
        }
    }

    @Override
    public void delete(Long id) {
        employeeMapper.delete(id);
    }
}
