package com.atguigu.mybatis.test;

import com.atguigu.mybatis.bean.Department;
import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.DepartmentMapper;
import com.atguigu.mybatis.dao.EmployeeMapper;
import com.atguigu.mybatis.dao.EmployeeMapperPlus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author FLD
 * @create 2020-07-05 14:39
 */
public class mybatistest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }
    @Test
    public void test1() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        Employee e = sqlSession.selectOne("com.atguigu.mybatis.EmolyeeMapper.selectEmp", 1);
        System.out.println(e);

        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee empbyId = mapper.getEmpbyId(1);
        System.out.println(empbyId);
        sqlSession.close();
    }
    @Test
    public void test3() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//            Employee employee = new Employee(null, "abc", "aaa", "1");
//            mapper.addEmp(employee);
//            System.out.println(employee.getId());
//            Employee employee = new Employee(2, "ccc", "ccc", "1");
//            mapper.updateEmp(employee);
//            mapper.delEmp(2);
//            Employee tom = mapper.getEmpbyIdandName(1, "tom");
//            Map<String,Object> map=new HashMap<>();
//            map.put("id",1);
//            map.put("lastName","tom");
//            Employee tom = mapper.getEmpbyMap(map);
//            System.out.println(tom);

//            List<Employee> empByLastNameLike = mapper.getEmpByLastNameLike("%b%");
//            System.out.println(empByLastNameLike);

//            Map<String, Object> empByIdReturnMap = mapper.getEmpByIdReturnMap(1);
//            System.out.println(empByIdReturnMap);
            Map<Integer, Employee> empByLastNameLikeReturnMap = mapper.getEmpByLastNameLikeReturnMap("%b%");
            System.out.println(empByLastNameLikeReturnMap);
            //sqlSession.commit();
        }finally{
            sqlSession.close();
        }
    }

    @Test
    public void test4() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
//            Employee empbyId = mapper.getEmpbyId(1);
//            System.out.println(empbyId);
//            Employee empAndDept = mapper.getEmpAndDept(1);
            Employee empbyIdStep = mapper.getEmpbyStep(1);
            System.out.println(empbyIdStep);
            System.out.println(empbyIdStep.getDept());
        }finally{
            sqlSession.close();
        }
    }


    @Test
    public void test5() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            Department deptByIdPlus = mapper.getDeptByIdPlus(1);
            System.out.println(deptByIdPlus);
            System.out.println(deptByIdPlus.getEmps());
        }finally{
            sqlSession.close();
        }
    }

}
