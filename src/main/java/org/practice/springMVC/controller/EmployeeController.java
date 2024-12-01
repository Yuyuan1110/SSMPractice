package org.practice.springMVC.controller;

import org.practice.springMVC.dao.EmployeeDao;
import org.practice.springMVC.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employee")
    public String getAllEmployees(Model model) {
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("employees", all);
        return "employee_list";
    }
//
//    @PostMapping("/employee")
//    public String addEmployee(Employee employee, Model model) {
//        employeeDao.save(employee);
//        model.addAttribute("employees", employeeDao.getAll());
//        return "employee_list";
//    }
    @PostMapping("/employee")
    public String addEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("employee/{id}")
    public String toUpdateEmployee(@PathVariable("id") int id, Model model) {
        Employee emp = employeeDao.getById(id);
        System.out.println(emp.toString());
        model.addAttribute("employee", emp);
        return "employee_update";
    }

    @PutMapping("employee")
    public String updateEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") int id, Model model) {
        employeeDao.deleteById(id);
        System.out.println(employeeDao.toString());
        return "redirect:/employee";
    }
}
