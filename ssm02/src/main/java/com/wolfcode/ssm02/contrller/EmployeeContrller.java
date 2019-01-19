package com.wolfcode.ssm02.contrller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.wolfcode.ssm02.domain.Employee;
import com.wolfcode.ssm02.query.EmployeeQueryObject;
import com.wolfcode.ssm02.query.ResultPage;
import com.wolfcode.ssm02.service.IEmployeeService;
import org.apache.ibatis.jdbc.Null;
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

    /**
     * 列表
     * @param qo
     * @param model
     * @return
     */
    @RequestMapping("list")
    public String list(@ModelAttribute("qo")EmployeeQueryObject qo, Model model){
        ResultPage resultPage = employeeService.queryAll(qo);
        model.addAttribute("pageResult", resultPage);
        return "/employee/list";
    }

    /**
     * 新增或更新
     * @param employee
     * @return
     */
    @RequestMapping("saveOrUpdate")
    public String saveOrUpdate(Employee employee){
        employeeService.saveOrUpdate(employee);
        return "redirect:/employee/list.do";
    }

    /**
     * 编辑或新增
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("input")
    public String input(Long id, Model model){
        System.out.println(employeeService.getClass());
        if (id != null){
            Employee employee = employeeService.getById(id);
            model.addAttribute("employee", employee);
        }
        return "/employee/input";
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping("delete")
    public String delete(Long id){
        if (id != null){
            employeeService.deleteById(id);
        }
        return "redirect:/employee/list.do";
    }
}
