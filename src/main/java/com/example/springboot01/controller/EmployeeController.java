package com.example.springboot01.controller;

import com.example.springboot01.Dao.DepartmentDao;
import com.example.springboot01.Dao.EmployeeDao;
import com.example.springboot01.pojo.Department;
import com.example.springboot01.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/employee")
    public String employee(Model model) {
        Collection<Employee> employees = employeeDao.getAllEmployees();
        model.addAttribute("employees", employees);
        return "list";
    }

    @RequestMapping("/add")
    public String addEmployee(Model model) {
        Collection<Department> departments = departmentDao.selectAllDepartment();
        model.addAttribute("departments", departments);
        return "add";
    }

    @RequestMapping("/toadd")
    public String toAdd(Employee employee) {
        int id = employee.getDepartment().getId();
        String departmentName = departmentDao.selectDepartmentById(id).getDepartmentName();
        employee.getDepartment().setDepartmentName(departmentName);
        employeeDao.updateEmployee(employee);
        return "redirect:/employee";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("employee", employee);
        Collection<Department> departments = departmentDao.selectAllDepartment();
        model.addAttribute("departments", departments);

        return "update";
    }

    @RequestMapping("/toupdate")
    public String toUpdate(Employee employee) {
        int id = employee.getDepartment().getId();
        String departmentName = departmentDao.selectDepartmentById(id).getDepartmentName();
        employee.getDepartment().setDepartmentName(departmentName);
        employeeDao.updateEmployee(employee);
        return "redirect:/employee";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        employeeDao.deleteEmployeeById(id);
        return "redirect:/employee";
    }
}
