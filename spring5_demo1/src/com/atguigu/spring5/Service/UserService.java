package com.atguigu.spring5.Service;

import com.atguigu.spring5.DAO.UserDAO;

/**
 * @author FLD
 * @create 2020-06-19 22:18
 */
public class UserService {
    private UserDAO userdao;

    public void setUserdao(UserDAO userdao) {
        this.userdao = userdao;
    }

    public void add(){
        System.out.println("我是Userservice");
        userdao.update();
    }
}
