package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Department;

/**
 * @author FLD
 * @create 2020-07-06 23:25
 */
public interface DepartmentMapper {
    public Department getDeptById(Integer id);
    public Department getDeptByIdPlus(Integer id);
}
