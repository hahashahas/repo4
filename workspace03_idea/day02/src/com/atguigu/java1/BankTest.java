package com.atguigu.java1;

/**
 * @author FLD
 * @create 2020-03-26 19:21
 */
public class BankTest {

}
class Bank{
    private Bank(){}
    private static Bank instance=null;
    public static  Bank getInstance(){
        if(instance ==null){
            synchronized (Bank.class) {
                if(instance == null){
                    instance =new Bank();
                }
            }
        }
        return instance;
    }
}