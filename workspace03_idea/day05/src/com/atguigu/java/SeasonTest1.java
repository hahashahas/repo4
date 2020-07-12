package com.atguigu.java;

/**
 * 使用enum关键字
 * 定义的枚举类默认继承于class java.lang.Enum
 * @author FLD
 * @create 2020-05-06 17:40
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        //tostring
        System.out.println(summer);
        //System.out.println(Season1.class.getSuperclass());
        System.out.println();
        //values()
        Season1[] values = Season1.values();
        for(int i=0;i<values.length;i++){
            System.out.println(values[i]);
        }
        Thread.State[] values1 = Thread.State.values();
        for(int i=0;i<values1.length;i++){
            System.out.println(values1[i]);
        }
        //如果没有objname的枚举对象，则抛异常
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
        winter.show();
    }
}
interface Info{
    void show();
}
//enum枚举类
enum Season1 implements Info{
    //提供当前枚举类的多个对象,多个对象之间用逗号隔开，末尾对象分号结束
    SPRING("春天","春暖花开"){
        public void show() {
            System.out.println("春天在哪里");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        public void show() {
            System.out.println("夏天在哪里");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        public void show() {
            System.out.println("秋天在哪里");
        }
    },
    WINTER("冬天","冰天雪地"){
        public void show() {
            System.out.println("冬天在哪里");
        }
    };

    //声明Season对象的属性
    private final String seasonName;
    private final String seasonDesc;

    //私有化类的构造器,并给对象属性赋值
    private Season1(String seasonName,String seasonDesc){
        this.seasonName=seasonName;
        this.seasonDesc=seasonDesc;
    }
    //其他诉求，获取枚举类对象的多个属性

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public void show() {
        System.out.println("这是一个季节");
    }
}
