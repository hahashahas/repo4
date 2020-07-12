package com.atguigu.java1;

public class NetWorkTest {
	public static void main(String[] args) {
		Server server=new Server();
		Proxyserver proxyserver = new Proxyserver(server);
		proxyserver.browse();
	}
}
interface NetWork{
	public void browse();
	
}
//被代理类
class Server implements NetWork{

	@Override
	public void browse() {
		// TODO Auto-generated method stub
		System.out.println("真实的服务器访问网络");
	}
	
}
//代理类
class Proxyserver implements NetWork{

	private NetWork work;
	
	public Proxyserver(NetWork work) {
		this.work=work;
	}
	public void check() {
		System.out.println("联网之后的检查工作");
	}
	@Override
	public void browse() {
		check();
		work.browse();
	}
	
	
}