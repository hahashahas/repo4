package com.atguigu.java1;
/*
 * 
 * 接口使用
 */
public class USBText {
	public static void main(String[] args) {
		Computer com= new Computer();
		//创建了接口的非匿名实现类的非匿名对象
		Flash flash = new Flash();
		com.transferData(flash);
		//创建了接口的非匿名实现类的匿名对象
		com.transferData(new Printer());
		//创建接口的匿名实现类的非匿名对象
		USB phone =new USB() {
			@Override
			public void start() {
				System.out.println("手机开始工作");
			}

			@Override
			public void stop() {
				System.out.println("手机结束工作");
			}
			
		};
		com.transferData(phone);
		//创建接口的匿名实现类的匿名对象
		com.transferData(new USB() {

			@Override
			public void start() {
				// TODO Auto-generated method stub
				System.out.println("手机开始工作");
			}

			@Override
			public void stop() {
				// TODO Auto-generated method stub
				System.out.println("手机结束工作");
			}
			
		});
	}
}
interface USB{
	
	void start();
	
	void stop();
	
}
class Flash implements USB{

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("U盘开启工作");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("U盘关闭工作");
	}
	
}
class Printer implements USB{

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("打印机开启工作");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("打印机关闭工作");
	}
	
}
class Computer{
	public void transferData(USB usb) {
		usb.start();
		System.out.println("传输数据的细节");
		usb.stop();
	}
}





