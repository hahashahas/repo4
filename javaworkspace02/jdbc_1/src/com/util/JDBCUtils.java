package com.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;



import connection.ConnectTest;

/**
 * 
 * @Description 操作数据库的工具类
 * @author FLD
 * @version
 * @date 2020年5月21日上午1:29:38
 *
 */
public class JDBCUtils {
	public static Connection getConnection() throws Exception{
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
	public static void closeResource(Connection conn,PreparedStatement ps) {
		try {
			if(ps!=null)
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(conn!=null)
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void closeResource(Connection conn,PreparedStatement ps,ResultSet rs) {
		try {
			if(ps!=null)
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(conn!=null)
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(rs!=null)
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
