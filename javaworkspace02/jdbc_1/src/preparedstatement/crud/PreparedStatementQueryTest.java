package preparedstatement.crud;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.bean.Customer;
import com.bean.Order;
import com.util.JDBCUtils;


public class PreparedStatementQueryTest {
	/**
	 * 
	 * @Description 使用PreparedStatement实现不同表的通用的查询操作,返回表中的一条记录
	 * @author FLD
	 * @version
	 * @date 2020年5月21日下午6:44:22
	 *
	 */
	public <T>T getInstance(Class<T> clazz,String sql,Object...args) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn = JDBCUtils.getConnection();
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
			JDBCUtils.closeResource(conn, ps, rs);
		}
		
		return null;
	}
	/**
	 * 
	 * @Description
	 * @author FLD
	 * @date 2020年5月21日下午8:16:22
	 * @param <T>
	 * @param clazz
	 * @param sql
	 * @param args
	 * @return
	 */
	
	public <T> List<T> getForList(Class<T> clazz,String sql,Object...args){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			for(int i=0;i<args.length;i++) {
				ps.setObject(i+1, args[i]);
			}
			rs = ps.executeQuery();
			//获取结果集的元数据
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();//获取列数
			ArrayList<T> list = new ArrayList<T>();
			while(rs.next()) {
				T t=clazz.newInstance();
				for(int i=0;i<columnCount;i++) {
					Object columnvalue = rs.getObject(i+1);
					String columnLabel = rsmd.getColumnLabel(i+1);
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columnvalue);
				}
				list.add(t);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, ps, rs);
		}
		return null;
	}
	@Test
	public void testGetInstance() {
		String sql="select id,name,birth,email from customers where id = ?";
		Customer customer = getInstance(Customer.class,sql,12);
		System.out.println(customer);
		sql="select Order_id orderId,order_name orderName,order_date orderDate from `order` where order_id = ?";
		Order order = getInstance(Order.class,sql,1);
		System.out.println(order);
	}
	@Test 
	public void testGetForList() {
		String sql="select id,name,birth,email from customers where id < ?";
		List<Customer> list = getForList(Customer.class,sql,12);
		list.forEach(System.out::println);
	}
}
