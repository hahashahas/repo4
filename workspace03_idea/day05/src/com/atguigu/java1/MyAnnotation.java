package com.atguigu.java1;

/**
 * @author FLD
 * @create 2020-05-06 22:33
 */
public @interface MyAnnotation {
    String value() default "hello";
}
