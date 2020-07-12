package com.atguigu.spring5.DAO;

/**
 * @author FLD
 * @create 2020-06-19 22:16
 */
public class UserImpl implements UserDAO {

    @Override
    public void update() {
        System.out.println("我是DAO");
    }
}
