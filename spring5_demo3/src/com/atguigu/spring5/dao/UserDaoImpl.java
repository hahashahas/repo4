package com.atguigu.spring5.dao;

import org.springframework.stereotype.Repository;

/**
 * @author FLD
 * @create 2020-06-20 18:27
 */
@Repository
public class UserDaoImpl implements  UserDao {

    @Override
    public void add() {
        System.out.println("dao add....");
    }
}
