package first;

public class _01 {
	public static void main(String[] args) {
		Window window = new Window();
		Thread t1=new Thread(window);
		Thread t2=new Thread(window);
		Thread t3=new Thread(window);
		t1.setName("窗口 1");
		t2.setName("窗口 2");
		t3.setName("窗口 3");
		t1.start();
		t2.start();
		t3.start();
	}
}
