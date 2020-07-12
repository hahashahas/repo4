package com.atguigu.spring5;

/**
 * @author FLD
 * @create 2020-06-20 22:30
 */
public class UserDaoImpl implements UserDao{

    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public String update(String id) {
        return id;
    }
}
