package cn.wolfcode.ssm.service.impl;

import cn.wolfcode.ssm.domain.Employee;
import cn.wolfcode.ssm.mapper.EmployeeMapper;
import cn.wolfcode.ssm.query.EmployeeQueryObject;
import cn.wolfcode.ssm.query.PageResult;
import cn.wolfcode.ssm.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public void insertOrUpdate(Employee entity) {

    }

    @Override
    public void deleteById(Long id) {
        System.out.println("test");
    }

    @Override
    public PageResult queryAll(EmployeeQueryObject qo) {
        Integer count = employeeMapper.queryCount(qo);
        if(count == 0){
            return PageResult.EMPTY_PAGE;
        }
        List<Employee> data = employeeMapper.queryAll(qo);

        return new PageResult(qo.getCurrentPage(), qo.getPageSize(),count, data);
    }

    @Override
    public void saveOrUpdate(Employee employee) {
        if(employee.getId() == null){
            //新增
            employeeMapper.insert(employee);
        }else {
            //更新
            employeeMapper.updateByKey(employee);
        }
    }


    /**
     * 根据ID获取Employee对象
     * @param id
     * @return
     */
    @Override
    public Employee getById(Long id) {
        return employeeMapper.getById(id);
    }
}
