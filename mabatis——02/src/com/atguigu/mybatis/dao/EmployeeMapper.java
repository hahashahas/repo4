package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;

/**
 * @author FLD
 * @create 2020-07-05 17:12
 */
public interface EmployeeMapper {
    public Employee getEmpbyId(Integer id);
}
