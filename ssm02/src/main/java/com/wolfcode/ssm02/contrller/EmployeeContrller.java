package com.wolfcode.ssm02.contrller;

import com.wolfcode.ssm02.domain.Employee;
import com.wolfcode.ssm02.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employee")
public class EmployeeContrller {
    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("input")
    public String input(Long id, Model model){
        System.out.println(employeeService.getClass());
        id = 1L;

        if (id != null){
            Employee employee = employeeService.getById(id);
            model.addAttribute("employee", employee);
        }
        return "/employee/input";
    }
}
