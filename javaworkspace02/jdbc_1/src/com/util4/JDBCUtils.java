package com.util4;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	public static Connection getConnection() throws Exception {
		// 1.读取配置文件中的基本信息
		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
		Properties pros = new Properties();
		pros.load(is);
		String user = pros.getProperty("user");
		String password = pros.getProperty("password");
		String url = pros.getProperty("url");
		String driverClass = pros.getProperty("driverClass");
		// 加载驱动
		Class.forName(driverClass);
		// 获取连接
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}

	/**
	 * 
	 * @Description 关闭连接和Statement的操作
	 * @author FLD
	 * @date 2020年5月21日上午1:35:43
	 * @param conn
	 * @param ps
	 */
	public static void closeResource(Connection conn, PreparedStatement ps) {
		try {
			if (ps != null)
				ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void closeResource(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (ps != null)
				ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Description 使用C3p0的数据库连接技术
	 * @author FLD
	 * @date 2020年5月23日下午3:47:58
	 * @return
	 * @throws Exception
	 */
	// 连接池只须一个就行
	private static ComboPooledDataSource cpds = new ComboPooledDataSource("hellc3p0");

	public static Connection getConnection1() throws Exception {
		Connection conn = cpds.getConnection();
		return conn;
	}

	/**
	 * 
	 * @Description 使用dbcp的数据库连接技术
	 * @author FLD
	 * @date 2020年5月23日下午6:51:06
	 * @return
	 * @throws Exception
	 */

	private static DataSource source;
	static {
		try {
			Properties pros = new Properties();
			InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
			pros.load(is);
			source = BasicDataSourceFactory.createDataSource(pros);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection2() throws Exception {

		Connection conn = source.getConnection();
		return conn;
	}
	/**
	 * 使用druid数据库连接池技术
	 */
	private static DataSource source1;
	static {
		try {
			Properties pros = new Properties();
			InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
			pros.load(is);
			source1 = DruidDataSourceFactory.createDataSource(pros);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection3() throws Exception {
		
		Connection conn = source1.getConnection();
		return conn;
	}
}
