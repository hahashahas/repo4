package com.atguigu.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author FLD
 * @create 2020-06-13 8:51
 */
public class Person {
    private String age;
    private String[] phones;
    private List<String> cities;
    private Map<String, Object> map;

    public Person() {
    }

    public Person(String age, String[] phones, List<String> cities, Map<String, Object> map) {
        this.age = age;
        this.phones = phones;
        this.cities = cities;
        this.map = map;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", phones=" + Arrays.toString(phones) +
                ", cities=" + cities +
                ", map=" + map +
                '}';
    }
}
