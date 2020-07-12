package com.atguigu.java1;

/**
 * @author FLD
 * @create 2020-05-06 20:02
 */
public class AnnotationTest {
    public static void main(String[] args) {

    }
}
@MyAnnotation()
class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public void walk(){
        System.out.println("人走路");
    }
    public void eat(){
        System.out.println("人吃饭");
    }
}
interface Info{
    void show();
}
class Student extends Person implements Info{
    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    @Override
    public void show() {

    }
}
