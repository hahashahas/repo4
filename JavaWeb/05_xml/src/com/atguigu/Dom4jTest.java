package com.atguigu;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.junit.Test;

/**
 * @author FLD
 * @create 2020-05-29 18:31
 */
public class Dom4jTest {
    @Test
    public void test1() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");
        System.out.println(document);
    }
    @Test
    public void test2(){
        
    }
}
