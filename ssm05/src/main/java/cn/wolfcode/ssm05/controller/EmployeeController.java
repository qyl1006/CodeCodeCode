package cn.wolfcode.ssm05.controller;

import cn.wolfcode.ssm05.domain.Employee;
import cn.wolfcode.ssm05.query.EmployeeQueryObject;
import cn.wolfcode.ssm05.query.ResultPage;
import cn.wolfcode.ssm05.service.IEmployeeService;
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
     * list数据
     * @param qo
     * @param model
     * @return
     */
    @RequestMapping("list")
    public String list(@ModelAttribute("qo")EmployeeQueryObject qo, Model model){
        ResultPage resultPage = employeeService.queryAll(qo);

        model.addAttribute("resultPage", resultPage);
        return "/employee/list";
    }

    /**
     *  跳转到input.jsp页面
     * @param id
     * @return
     */
    @RequestMapping("input")
    public String input(Long id, Model model){
        if (id != null){
            Employee employee = employeeService.get(id);
            model.addAttribute("emp", employee);
        }
        return "/employee/input";
    }

    /**
     * 更新或新增
     * @param employee
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
        employeeService.delete(id);
        return "redirect:/employee/list.do";
    }
}
