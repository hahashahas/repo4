package atguigu.java;

/**
 * 测试Thread常用方法
 * @author FLD
 * @create 2020-03-23 17:29
 */
class HelloThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <100; i++) {
            if(i%2==0){
                /*try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority()+"   "+i);
            }
            /*if(i%20==0){
                yield();
            }*/
        }
    }
    public HelloThread(String name){
        super(name);
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread h1=new HelloThread("Thread:1");
        //h1.setName("线程一");
        h1.setPriority(10);
        h1.start();
        //给主线程命名
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(1);
        for (int i = 0; i <100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority()+"   "+i);
            }
            /*if(i==20){
                try {
                    h1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/
        }
        //System.out.println(h1.isAlive());
    }
}
