package com.atguigu.java;

/**
 * @author FLD
 * @create 2020-03-26 15:51
 */
class Window4 extends Thread{
    private static int ticket=100;
    private static Object obj=new Object();
    public void run() {
        while(true){
            show();
        }
    }
    private static synchronized  void show(){
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
            ticket--;
        }
    }
}
public class WindowTest4 {
    public static void main(String[] args) {
        Window4 t1 = new Window4();
        Window4 t2 = new Window4();
        Window4 t3 = new Window4();

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();

    }
}
