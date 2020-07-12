package com.atguigu.spring5.test;

import com.atguigu.spring5.aopo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author FLD
 * @create 2020-06-21 8:32
 */
public class testaop {
    @Test
    public void testanno(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }
}
