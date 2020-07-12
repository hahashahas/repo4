package com.connection4;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

public class DBCPTest {
	/**
	 * 
	 * @Description 测试DBCP的数据库连接技术
	 * @author FLD
	 * @throws SQLException 
	 * @date 2020年5月23日下午6:27:43
	 */
	@Test
	//方式一
	public void testGetConnextion() throws SQLException {
		//创建DBCP的数据库连接池
		BasicDataSource source=new BasicDataSource();
		//设置基本信息
		source.setDriverClassName("com.mysql.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/test");
		source.setUsername("root");
		source.setPassword("2039527370abc");
		//还可与设置其他数据库连接池管理的相关属性
		source.setInitialSize(10);
		source.setMaxActive(10);
		
		Connection conn = source.getConnection();
		System.out.println(conn);
		
	}
	
	//方式二：使用配置文件
	@Test
	public void testGetConnection1() throws Exception {
		Properties pros = new Properties();
		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
		pros.load(is);
		DataSource source = BasicDataSourceFactory.createDataSource(pros);
		Connection conn = source.getConnection();
		System.out.println(conn);
	}
}
