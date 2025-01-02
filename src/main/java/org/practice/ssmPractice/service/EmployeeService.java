package org.practice.ssmPractice.service;

import com.github.pagehelper.PageInfo;
import org.practice.ssmPractice.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    PageInfo<Employee> getEmployeePage(int pageNum);

    Employee getEmployeeById(int empId);

    int updateEmployee(Employee employee);

    int deleteEmployee(int empId);

    int addEmployee(Employee employee);
}
