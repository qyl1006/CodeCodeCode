package cn.wolfcode.ssm04.controller;

import cn.wolfcode.ssm04.domain.Employee;
import cn.wolfcode.ssm04.query.EmployeeQueryObject;
import cn.wolfcode.ssm04.query.ResultPage;
import cn.wolfcode.ssm04.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;


    /**
     * list
     * @param qo
     * @param model
     * @return
     */
    @RequestMapping("list")
    public String list(@ModelAttribute("qo")EmployeeQueryObject qo, Model model){
        System.out.println("测试是否代理对象: " + employeeService.getClass());

        ResultPage resultPage = employeeService.queryAll(qo);
        model.addAttribute("resultPage", resultPage);
        return "/employee/list";
    }

    /**
     * 获取单个Employee对象 跳转到对应编辑页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("input")
    public String input(Long id, Model model) {
        if (id != null) {
            Employee employee = employeeService.get(id);
            model.addAttribute("emp", employee);
        }

        return "/employee/input";
    }

    /**
     * 新增或编辑
     * @return
     */
    @RequestMapping("saveOrUpdate")
    public String saveOrUpdate(Employee employee){
        employeeService.saveOrUpdate(employee);

        return "redirect:/employee/list.do";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("delete")
    public String delete(Long id){
        if (id != null){
            employeeService.delete(id);
        }
        return "redirect:/employee/list.do";
    }
}

