package atguigu.java;

/**
 * @author FLD
 * @create 2020-03-23 21:25
 */
class Window1 implements Runnable{
    private static int ticket=100;
    public void run() {
        while(true){
            if(ticket>0){
                System.out.println(Thread.currentThread().getName()+":卖票，票号为："+ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w = new Window1();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();

    }
}
