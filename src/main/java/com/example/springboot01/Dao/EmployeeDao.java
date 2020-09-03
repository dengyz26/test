package com.example.springboot01.Dao;

import com.example.springboot01.pojo.Department;
import com.example.springboot01.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    private static Integer id = 1006;

    static {
        employees = new HashMap<>();

        employees.put(1001, new Employee(1001, "AA", "111@qq.com", 1, new Department(101, "教学部")));
        employees.put(1002, new Employee(1002, "BB", "222@qq.com", 1, new Department(102, "市场部")));
        employees.put(1003, new Employee(1003, "CC", "333@qq.com", 0, new Department(103, "教研部")));
        employees.put(1004, new Employee(1004, "DD", "444@qq.com", 1, new Department(104, "运营部")));
        employees.put(1005, new Employee(1005, "EE", "555@qq.com", 0, new Department(105, "后勤部")));
    }

    public void updateEmployee(Employee employee) {
        if(employee.getId() == null) {
            employee.setId(id++);
        }
        employees.put(employee.getId(), employee);
    }

    public Collection<Employee> getAllEmployees() {
        for (Employee e : employees.values()) {
            System.out.println(e);
        }
        return employees.values();
    }

    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    public void deleteEmployeeById(Integer id) {
        employees.remove(id);
    }
}
