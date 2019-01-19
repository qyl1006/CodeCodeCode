package cn.wolfcode.ssm03.service.impl;

import cn.wolfcode.ssm03.domain.Employee;
import cn.wolfcode.ssm03.mapper.EmployeeMapper;
import cn.wolfcode.ssm03.query.EmployeeQueryObject;
import cn.wolfcode.ssm03.query.ResultPage;
import cn.wolfcode.ssm03.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public ResultPage queryAll(EmployeeQueryObject qo) {
        int count = employeeMapper.queryCount(qo);
        if (count == 0){
            return ResultPage.EMPLY_PAGE;
        }

        List<Employee> data = employeeMapper.listAll(qo);
        return new ResultPage(qo.getCurrentPage(), qo.getPageSize(), count, data);
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
}
