package com.example.springboot01.pojo;

import com.example.springboot01.Dao.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 部门表
@Component
public class Department {

    private Integer id;
    private String departmentName;

    @Autowired
    private DepartmentDao departmentDao;

    public Department() {
    }

    public Department(Integer id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDepartmentNameById(Integer id) {
        return departmentDao.selectDepartmentById(id).getDepartmentName();
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
