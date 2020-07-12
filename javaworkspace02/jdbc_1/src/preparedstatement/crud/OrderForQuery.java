package preparedstatement.crud;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;

import com.bean.Customer;
import com.bean.Order;
import com.util.JDBCUtils;

/**
 * 
 * @Description 针对于order表的通用查询操作
 * @author FLD
 * @version
 * @date 2020年5月21日下午4:24:40
 *
 */
public class OrderForQuery {
	/**
	 * 
	 * @Description 通用的针对于Order的操作
	 * @author FLD
	 * @date 2020年5月21日下午4:55:12
	 */
	public Order orderForQuery(String sql,Object...args) {
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
				Order order = new Order();
				for(int i=0;i<columnCount;i++) {
					Object columnvalue = rs.getObject(i+1);
					//获取每个列的列名
					//获取列的列名getColumnName() //不推荐使用
					//获取列的别名getColumnLabel()
					String columnLabel = rsmd.getColumnLabel(i+1);
					//给cust指定的属性赋值,通过反射
					Field field = Order.class.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(order, columnvalue);
				}
				return order;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, ps, rs);
		}
		return null;
	}
	
	@Test
	public void testQuery1(){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn = JDBCUtils.getConnection();
			String sql="select Order_id,order_name,order_date from `order` where order_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, 1);
			rs = ps.executeQuery();
			if(rs.next()) {
				int id=(int) rs.getObject(1);
				String name=(String) rs.getObject(2);
				Date date = (Date)rs.getObject(3);
				Order order = new Order(id,name,date);
				System.out.println(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, ps, rs);
		}
		
	}
	@Test
	public void testqueryfororder() {
		String sql="select Order_id orderId,order_name orderName,order_date orderDate from `order` where order_id = ?";
		Order order = orderForQuery(sql,1);
		System.out.println(order);
	}
}
