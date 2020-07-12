package com.atguigu.spring5.collectiontype;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author FLD
 * @create 2020-06-20 9:45
 */
public class Stu {
    private String[] courses;
    private List<String> list;
    private Map<String,String> maps;
    private Set<String> sets;
    private List<Course> courselist;

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void setCourselist(List<Course> courselist) {
        this.courselist = courselist;
    }

    public void test(){
        System.out.println(Arrays.toString(courses));
        System.out.println(list);
        System.out.println(maps);
        System.out.println(sets);
        System.out.println(courselist);
    }
}
