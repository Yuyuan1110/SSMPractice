package org.practice.springMVC.dao;

import org.practice.springMVC.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;

    static {
        employees = new HashMap<Integer, Employee>();

        employees.put(1001, new Employee(1001, "John", "john@abc.com", 1));
        employees.put(1002, new Employee(1002, "Peter", "peter@abc.com", 1));
        employees.put(1003, new Employee(1003, "Rosie", "rosie@abc.com", 0));
        employees.put(1004, new Employee(1004, "Yuyuan", "yuyuan@abc.com", 1));
        employees.put(1005, new Employee(1005, "Kevin", "kebin@abc.com", 1));
    }

    private static int initId = 1006;
    public void save(Employee employee){
        if(employee.getId() == 0){
            employee.setId(initId++);
        }
        employees.put(employee.getId(), employee);
    }

    public Collection<Employee> getAll(){
        return employees.values();
    }

    public Employee getById(int id){
        return employees.get(id);
    }

    public void deleteById(int id){
        employees.remove(id);
    }
}
