package atguigu.java;

/**
 * @author FLD
 * @create 2020-03-23 14:57
 */
class MyThread extends Thread{
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        MyThread t1= new MyThread();
        MyThread t2= new MyThread();
        t1.start();
        t2.start();
        for(int i=0;i<100;i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
