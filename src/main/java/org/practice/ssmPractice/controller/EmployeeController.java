package org.practice.ssmPractice.controller;

import com.github.pagehelper.PageInfo;
import jakarta.servlet.ServletContext;
import org.practice.ssmPractice.pojo.Employee;
import org.practice.ssmPractice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/page/{pageNum}")
    public String getEmployeePage(@PathVariable("pageNum") int pageNum,  Model model){
        PageInfo<Employee> page = employeeService.getEmployeePage(pageNum);
        model.addAttribute("page", page);
        return "employee_list";
    }

    @GetMapping("/employee/update/{id}")
    public String updateEmployee(@PathVariable("id") int id, Model model){
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee_update";
    }

    @PutMapping(value = "/employee/update")
    public RedirectView updateEmployee(Employee employee, Model model){
        System.out.println("employee: " + employee);
        int returnInt = employeeService.updateEmployee(employee);
        RedirectView redirectView = new RedirectView("/spring/mvc/employee/page/1");
        redirectView.setStatusCode(HttpStatus.SEE_OTHER);
        return redirectView;
    }

    @DeleteMapping("/employee/delete/{empId}")
    public RedirectView deleteEmployee(@PathVariable("empId") int empId, Model model){
        int returnInt = employeeService.deleteEmployee(empId);
        RedirectView redirectView = new RedirectView("/spring/mvc/employee/page/1");
        redirectView.setStatusCode(HttpStatus.SEE_OTHER);
        return redirectView;
    }

    @GetMapping("/employee/add")
    public String addEmployee(Model model){
        return "employee_add";
    }

    @PostMapping("/employee/add")
    public String addEmployee(Employee employee, Model model){

//        System.out.println("employee: " + employee);
        employeeService.addEmployee(employee);

        return "redirect:/employee/page/1";
    }

    @GetMapping("/employee")
    public String getAllEmployee(Model model) {
        List<Employee> list = employeeService.getAllEmployee();
        System.out.println(list);
        model.addAttribute("list", list);
        return "employee_list";
    }

}
