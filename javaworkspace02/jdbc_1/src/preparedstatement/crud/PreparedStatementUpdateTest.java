package preparedstatement.crud;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.junit.Test;

import com.util.JDBCUtils;

import connection.ConnectTest;

/*
 * 使用PreparedStatement来替换Statement，实现对数据表的增删改查操作
 * 
 */
public class PreparedStatementUpdateTest {
	// 向customer表中添加一条记录
	@Test
	public void testInsert(){
		// 1.读取配置文件中的基本信息
		// 获取连接
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			InputStream is = ConnectTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
			Properties pros = new Properties();
			pros.load(is);
			String user = pros.getProperty("user");
			String password = pros.getProperty("password");
			String url = pros.getProperty("url");
			String driverClass = pros.getProperty("driverClass");
			// 加载驱动
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url, user, password);
			//预编译sql语句，返回preparedstatement
			String sql="insert into customers(name,email,birth)values(?,?,?)";//占位符
			ps = conn.prepareStatement(sql);
			//填充占位符
			ps.setString(1, "哪吒");
			ps.setString(2, "nezha@gmail.com");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = sdf.parse("1000-01-01");
			ps.setDate(3, new Date(date.getTime()));
			//执行sql操作
			ps.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//资源关闭
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
		
	}
	
	
	
	//修改
	@Test
	public void testUpdate(){
		//1.获取数据库连接
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtils.getConnection();
			//2.预编译sql语句，返回preparedStatement的实例
			String sql="update customers set name = ? where id = ?";
			ps = conn.prepareStatement(sql);
			//3.填充占位符
			ps.setObject(1, "莫扎特");
			ps.setObject(2, 18);
			//4.执行
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//5.资源的关闭
			JDBCUtils.closeResource(conn, ps);
		}
	}
	
	
	
	
	//通用的增删改
	public void update(String sql,Object...args){
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			for(int i=0;i<args.length;i++) {
				ps.setObject(i+1, args[i]);
			}
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.closeResource(conn, ps);
		}
	}
	
	@Test
	public void testCommonUpdate() {
		/*String sql="delete from customers where id = ?";;
		update(sql,3);*/
		String sql="update `order` set order_name = ? where order_id = ?";
		update(sql,"DD","2");
	}
}
