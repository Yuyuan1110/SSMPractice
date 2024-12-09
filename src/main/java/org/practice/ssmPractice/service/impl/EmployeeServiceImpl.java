package org.practice.ssmPractice.service.impl;

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
}
