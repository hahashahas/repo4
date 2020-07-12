package com.atguigu.spring5.Bean;

/**
 * @author FLD
 * @create 2020-06-19 22:54
 */
public class Emp {
    private String ename;
    private String gender;
    private dept dept;

    public void setDept(com.atguigu.spring5.Bean.dept dept) {
        this.dept = dept;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
