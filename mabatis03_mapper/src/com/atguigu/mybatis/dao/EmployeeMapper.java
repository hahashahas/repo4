package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author FLD
 * @create 2020-07-05 17:12
 */
public interface EmployeeMapper {
    public Employee getEmpbyId(Integer id);
    public Employee getEmpbyIdandName(@Param("id") Integer id,@Param("lastName") String lastName);
    public Employee getEmpbyMap(Map<String,Object> map);
    public void addEmp(Employee employee);
    public void updateEmp(Employee employee);
    public void delEmp(Integer id);
    public List<Employee> getEmpByLastNameLike(String lastName);
    public Map<String,Object> getEmpByIdReturnMap(Integer id);
    @MapKey("id")
    public Map<Integer,Employee> getEmpByLastNameLikeReturnMap(String lastName);
}
