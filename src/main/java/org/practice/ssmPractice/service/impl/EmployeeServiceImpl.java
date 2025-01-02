package org.practice.ssmPractice.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.practice.ssmPractice.mapper.EmployeeMapper;
import org.practice.ssmPractice.pojo.Employee;
import org.practice.ssmPractice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    public List<Employee> getAllEmployee() {

        return employeeMapper.getAllEmployee();
    }

    @Override
    public PageInfo<Employee> getEmployeePage(int pageNum) {
        PageHelper.startPage(pageNum, 3);
        List<Employee> list = employeeMapper.getAllEmployee();
        PageInfo<Employee> pageInfo = new PageInfo<>(list, 5);
        return pageInfo;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = employeeMapper.getEmployeeById(id);
        return employee;
    }

    @Override
    public int updateEmployee(Employee employee) {
        return employeeMapper.updateEmployee(employee);
    }

    @Override
    public int deleteEmployee(int empId) {

        return employeeMapper.deleteEmployee(empId);
    }

    @Override
    public int addEmployee(Employee employee) {

        return employeeMapper.addEmployee(employee);
    }
}
