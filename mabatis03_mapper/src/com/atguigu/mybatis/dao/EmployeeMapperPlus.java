package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;

/**
 * @author FLD
 * @create 2020-07-06 17:21
 */
public interface EmployeeMapperPlus {

    public Employee getEmpbyId(Integer id);
    public Employee getEmpbyStep(Integer id);
    public Employee getEmpAndDept(Integer id);

}
