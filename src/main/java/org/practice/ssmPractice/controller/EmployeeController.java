package org.practice.ssmPractice.controller;

import jakarta.servlet.ServletContext;
import org.practice.ssmPractice.pojo.Employee;
import org.practice.ssmPractice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class EmployeeController {

//    @Autowired
//    private ServletContext servletContext;

    @Autowired
    private EmployeeService employeeService;

//    @RequestMapping("/test")
//    public String test() {
//        ApplicationContext springContext = (ApplicationContext) servletContext.getAttribute("employeeService");
//        System.out.println(springContext);
//        return "index";
//    }


    @GetMapping("/employee")
    public String getAllEmployee(Model model) {
        List<Employee> list = employeeService.getAllEmployee();
        model.addAttribute("list", list);
        return "employee_list";
    }

    ;
}
