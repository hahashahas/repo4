package connection;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.util.JDBCUtils;

public class TransactionTest {
/////////////////////////////////////未考虑事务/////////////////////////////////
	// 1.0
	public int update(String sql, Object... args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, ps);
		}
		return 0;
	}
	/*
	 * 针对于数据表user_table来说： AA用户给BB用户转账100 update user_table set balance = balance -
	 * 100 wheere user = 'AA' update user_table set balance = balance + 100 wheere
	 * user = 'AA'
	 */

	@Test
	public void testUpdate() {
		String sql1 = "update user_table set balance = balance - 100 where user = ?";
		update(sql1, "AA");
		// 模拟网络异常
		System.out.println(10 / 0);
		String sql2 = "update user_table set balance = balance + 100 where user = ?";
		update(sql2, "BB");
		System.out.println("转账成功");
	}

	//////////////////////////////////// 考虑了事务//////////////////////////////////
	// 2.0
	public int update(Connection conn, String sql, Object... args) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(null, ps);
		}
		return 0;
	}

	@Test
	public void testUpdateWithTx() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			conn.setAutoCommit(false);
			String sql1 = "update user_table set balance = balance - 100 where user = ?";
			update(conn, sql1, "AA");
			// 模拟网络异常
			System.out.println(10 / 0);
			String sql2 = "update user_table set balance = balance + 100 where user = ?";
			update(conn, sql2, "BB");
			System.out.println("转账成功");
			conn.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				System.out.println("转账失败");
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JDBCUtils.closeResource(conn, null);
		}

	}

	//////////////////////////////考虑事务,通用的查询操作  2.0版本////////////////////
	public <T>T getInstance(Connection conn,Class<T> clazz,String sql,Object...args) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps = conn.prepareStatement(sql);
			for(int i=0;i<args.length;i++) {
				ps.setObject(i+1, args[i]);
			}
			rs = ps.executeQuery();
			//获取结果集的元数据
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();//获取列数
			if(rs.next()) {
				T t=clazz.newInstance();
				for(int i=0;i<columnCount;i++) {
					Object columnvalue = rs.getObject(i+1);
					String columnLabel = rsmd.getColumnLabel(i+1);
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columnvalue);
				}
				return t;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(null, ps, rs);
		}
		
		return null;
	}
	
	@Test
	public void testTransactionSelect() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		System.out.println(conn.getTransactionIsolation());
		conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		conn.setAutoCommit(false);
		String sql="select user,password,balance from user_table where user = ?";
		User user = getInstance(conn,User.class,sql,"CC");
		System.out.println(user);
		
	}
	@Test
	public void testTransactionUpdate() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		conn.setAutoCommit(false);
		String sql="update user_table set balance = ? where user = ?";
		update(conn,sql,5000,"CC");
		Thread.sleep(15000);
		System.out.println("修改结束");
		
	}
}
