package connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

public class ConnectTest {
	@Test
	// 方式一
	public void testConnection1() throws SQLException {
		Driver driver = new com.mysql.jdbc.Driver();
		String url = "jdbc:mysql://localhost:3306/test";
		// 将用户名和密码封装在properties中
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "2039527370abc");
		Connection conn = driver.connect(url, info);
		System.out.println(conn);
	}

	// 方式2
	@Test
	public void testConnection2() throws Exception {
		// 获取Driver实现类对象，使用反射
		Class clazz = Class.forName("com.mysql.jdbc.Driver");
		Driver driver = (Driver) clazz.newInstance();
		// 提供要连接的数据库
		String url = "jdbc:mysql://localhost:3306/test";
		// 提供连接需要的用户名和密码
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "2039527370abc");
		// 获取连接
		Connection conn = driver.connect(url, info);
		System.out.println(conn);
	}

	// 方式3：使用DriverManager替换Driver
	@Test
	public void testConnection3() throws Exception {
		// 获取Driver实现类对象
		Class clazz = Class.forName("com.mysql.jdbc.Driver");
		Driver driver = (Driver) clazz.newInstance();
		// 提供另外三个连接的基本信息
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "2039527370abc";
		// 注册驱动
		DriverManager.registerDriver(driver);
		// 获取连接
		Connection connection = DriverManager.getConnection(url, user, password);
		System.out.println(connection);
	}

	// 方式四：优化
	@Test
	public void testConnection4() throws Exception {
		// 提供另外三个连接的基本信息
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "2039527370abc";
		// 获取Driver实现类对象
		Class clazz = Class.forName("com.mysql.jdbc.Driver");
		/*Driver driver = (Driver) clazz.newInstance();
		// 注册驱动
		DriverManager.registerDriver(driver);*/
		// 获取连接
		Connection connection = DriverManager.getConnection(url, user, password);
		System.out.println(connection);
	}
	//方式五：最终版,将数据库连接需要的四个基本信息声明在配置文件中，通过配置文件的方式，获取连接
	@Test
	public void getConnection5() throws Exception {
		//1.读取配置文件中的基本信息
		InputStream is = ConnectTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
		Properties pros = new Properties();
		pros.load(is);
		String user = pros.getProperty("user");
		String password = pros.getProperty("password");
		String url = pros.getProperty("url");
		String driverClass = pros.getProperty("driverClass");
		//加载驱动
		Class.forName(driverClass);
		//获取连接
		Connection connection = DriverManager.getConnection(url, user, password);
		System.out.println(connection);
	}
	
}
