package org.practice.ssmPractice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.practice.ssmPractice.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> getAllEmployee();

    Employee getEmployeeById(int empId);

    int updateEmployee(Employee employee);

    int deleteEmployee(int empId);

    int addEmployee(Employee employee);
}
