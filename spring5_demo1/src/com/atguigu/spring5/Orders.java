package com.atguigu.spring5;

/**
 * @author FLD
 * @create 2020-06-19 20:26
 */
public class Orders {
    private  String oname;
    private  String address;

    public Orders(String oname, String address) {
        this.oname = oname;
        this.address = address;
    }
    public void ordertest(){
        System.out.println(oname+"::"+address);
    }
}
