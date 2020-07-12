package com.atguigu.spring5.testdemo;

import com.atguigu.spring5.Book;
import com.atguigu.spring5.Orders;
import com.atguigu.spring5.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author FLD
 * @create 2020-06-19 14:31
 */
public class testspring5 {
    @Test
    public void testadd(){
        ApplicationContext context= new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.add();
    }
    @Test
    public void testBook1(){
        ApplicationContext context= new ClassPathXmlApplicationContext("bean1.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
        book.testDemo();
    }
    @Test
    public void testorder(){
        ApplicationContext contest=new ClassPathXmlApplicationContext("bean1.xml");
        Orders order = contest.getBean("orders", Orders.class);
        order.ordertest();

    }
}
