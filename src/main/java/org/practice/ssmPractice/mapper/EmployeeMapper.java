package org.practice.ssmPractice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.practice.ssmPractice.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> getAllEmployee();
}
