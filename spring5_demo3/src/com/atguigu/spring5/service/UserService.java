package com.atguigu.spring5.service;

import com.atguigu.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author FLD
 * @create 2020-06-20 18:00
 */
@Service
public class UserService {
    @Value(value="abc")
    private String name;

    @Autowired
    @Qualifier(value = "userDaoImpl")
    private UserDao userDao;

//    @Resource
//    private UserDao userDao;




    public void add(){
        userDao.add();
        System.out.println("add...");
    }
}
