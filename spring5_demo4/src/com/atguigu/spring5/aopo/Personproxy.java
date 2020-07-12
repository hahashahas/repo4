package com.atguigu.spring5.aopo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author FLD
 * @create 2020-06-21 10:07
 */
@Component
@Aspect
@Order(1)
public class Personproxy {
    @Before(value="execution(* com.atguigu.spring5.aopo.User.add(..))")
    public void before(){
        System.out.println("person before");
    }
}
