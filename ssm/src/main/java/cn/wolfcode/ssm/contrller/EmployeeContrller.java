package cn.wolfcode.ssm.contrller;

import cn.wolfcode.ssm.domain.Employee;
import cn.wolfcode.ssm.query.EmployeeQueryObject;
import cn.wolfcode.ssm.query.PageResult;
import cn.wolfcode.ssm.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employee")
public class EmployeeContrller {
    @Autowired
    private IEmployeeService employeeService;


    @RequestMapping("list")
    public String list(@ModelAttribute("qo")EmployeeQueryObject qo, Model model){
        System.out.println("测试是否是代理对象?:" + employeeService.getClass());
        PageResult result = employeeService.queryAll(qo);
        model.addAttribute("result", result);
        return "employee/list";
    }

    @RequestMapping("saveOrUpdate")
    public String saveOrUpdate(Employee employee){
        employeeService.saveOrUpdate(employee);

        //重定向
        return "redirect:/employee/list.do";
    }

    @RequestMapping("input")
    public String input(Long id, Model model){
        if(id != null){
            Employee employee = employeeService.getById(id);
            model.addAttribute("employee", employee);
        }

        return "employee/input";
    }

}
