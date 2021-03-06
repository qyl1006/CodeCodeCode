package cn.wolfcode.ssm03.contrllor;

import cn.wolfcode.ssm03.domain.Employee;
import cn.wolfcode.ssm03.query.EmployeeQueryObject;
import cn.wolfcode.ssm03.query.ResultPage;
import cn.wolfcode.ssm03.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employee")
public class EmployeeContrllor {
    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("list")
    public String list(@ModelAttribute("qo")EmployeeQueryObject qo, Model model){
        System.out.println("测试是否有代理对象: " + employeeService.getClass());

        ResultPage resultPage = employeeService.queryAll(qo);
        model.addAttribute("resultPage", resultPage);
        return "/employee/list";
    }

    @RequestMapping("saveOrUpdate")
    public String saveOrUpdate(Employee employee){
        employeeService.saveOrUpdate(employee);

        return "redirect:/employee/list.do";
    }

    @RequestMapping("input")
    public String input(Long id, Model model){
        if (id != null){
            Employee employee = employeeService.get(id);
            model.addAttribute("emp", employee);
        }

        return "/employee/input";
    }

    @RequestMapping("delete")
    public String delete(Long id){
        if(id != null){
            employeeService.delete(id);
        }
        return "redirect:/employee/list.do";
    }
}
