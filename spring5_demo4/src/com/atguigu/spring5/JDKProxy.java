package com.atguigu.spring5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author FLD
 * @create 2020-06-20 22:33
 */
public class JDKProxy {
    public static void main(String[] args) {
        Class[] interfaces = {UserDao.class};
        UserDao dao =(UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(new UserDaoImpl()));
        int add = dao.add(1, 2);
        System.out.println(add);
    }
}


class UserDaoProxy implements InvocationHandler{

    private Object obj;
    public UserDaoProxy(Object obj){
        this.obj=obj;
    }
    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        System.out.println("方法执行之前"+method.getName()+":传递的参数..."+ Arrays.toString(args));
        Object res = method.invoke(obj, args);
        System.out.println("方法执行之后"+obj);
        return res;
    }
}