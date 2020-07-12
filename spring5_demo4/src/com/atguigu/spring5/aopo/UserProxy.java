package com.atguigu.spring5.aopo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.sound.midi.SoundbankResource;

/**
 * @author FLD
 * @create 2020-06-21 8:20
 */
@Component
@Aspect
@Order(3)
public class UserProxy {
    @Pointcut(value="execution(* com.atguigu.spring5.aopo.User.add(..))")
    public void pointdemo(){

    }
    @Before(value="pointdemo()")
    public void before(){
        System.out.println("before");
    }

    @After(value="execution(* com.atguigu.spring5.aopo.User.add(..))")
    public void after(){
        System.out.println("after");
    }
    @AfterReturning(value="execution(* com.atguigu.spring5.aopo.User.add(..))")
    public void afterreturning(){
        System.out.println("afterreturning");
    }
    @AfterThrowing(value="execution(* com.atguigu.spring5.aopo.User.add(..))")
    public void afterthrowing(){
        System.out.println("afterthrowing");
    }
    @Around(value="execution(* com.atguigu.spring5.aopo.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前");
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后");
    }
}
