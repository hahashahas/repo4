package com.atguigu.mybatis.bean;

import java.util.List;

/**
 * @author FLD
 * @create 2020-07-06 17:47
 */
public class Department {
    private Integer id;
    private String departmentName;
    private List<Employee> emps;

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    public Integer getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
