package com.atguigu.spring5.testdemo;

import com.atguigu.spring5.Service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author FLD
 * @create 2020-06-19 22:35
 */
public class testBean {
    @Test
    public void test(){
        ApplicationContext context =new ClassPathXmlApplicationContext("bean2.xml");
        UserService userservice = context.getBean("userservice", UserService.class);
        userservice.add();

    }
}
