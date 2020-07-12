package com.atguigu.spring5.test;

import com.atguigu.spring5.entity.Book;
import com.atguigu.spring5.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FLD
 * @create 2020-06-21 12:17
 */
public class TestBook {
    @Test
    public void test1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
//        Book book = new Book();
//        book.setUserId("2");
//        book.setUsername("张子雄");
//        book.setUstatus("借阅");
//        bookService.addBook(book);

//        Book book = new Book();
//        book.setUserId("1");
//        book.setUsername("王力宏");
//        book.setUstatus("借阅");
//        bookService.updateBook(book);

//        bookService.delBook("2");

//        int count = bookService.findCount();
//        Book book = bookService.findOne("2");
//        System.out.println(book);
//        List<Book> books = bookService.findAll();
//        System.out.println(books);
//        List<Object[]> batchArgs=new ArrayList<>();
//        Object[] o1={"3","周杰伦","借阅"};
//        Object[] o2={"4","汪峰","借阅"};
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//        bookService.batchAdd(batchArgs);


//        List<Object[]> batchArgs=new ArrayList<>();
//        Object[] o1={"周杰伦","借阅","3"};
//        Object[] o2={"汪峰","借阅","4"};
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//        bookService.batchUpdate(batchArgs);


        List<Object[]> batchArgs=new ArrayList<>();
        Object[] o1={"3"};
        Object[] o2={"4"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        bookService.batchDelete(batchArgs);
    }
}
