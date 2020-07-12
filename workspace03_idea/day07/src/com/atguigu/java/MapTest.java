package com.atguigu.java;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FLD
 * @create 2020-05-09 20:16
 */
public class MapTest {
    @Test
    public void test1(){
        Map map=new HashMap();
        map.put(null,123);

    }
    @Test
    public void test2(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);
        map.put("AA",87);
        Map map1 = new HashMap();
        map1.put("CC",123);
        map1.put("DD",123);
        map.putAll(map1);
        System.out.println(map);
        Object value = map.remove("CC");
        System.out.println(value);
        System.out.println(map);
        map.clear();
        System.out.println(map.size());

    }

}
