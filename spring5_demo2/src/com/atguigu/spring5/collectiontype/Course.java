package com.atguigu.spring5.collectiontype;

/**
 * @author FLD
 * @create 2020-06-20 10:03
 */
public class Course {
    private String cname;

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cname='" + cname + '\'' +
                '}';
    }
}
