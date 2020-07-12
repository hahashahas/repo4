package first;

public class Window implements Runnable{
	private static int tickers=1;
	@Override
	public void run() {
		/*for(int i=1;i<=20;i++) {
			System.out.println(Thread.currentThread().getName()+"卖出第"+i+"张票");
		}*/
		while(tickers<=20) {
			synchronized(this) {
				if(tickers<=20) {
					System.out.println(Thread.currentThread().getName()+"卖出第"+tickers+"张票");
					tickers++;
				}else {
					break;
				}
			}
		}
	}
}
