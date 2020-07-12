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
import com.util.JDBCUtils;

/**
 * 
 * @Description 针对于Customers表的查询操作
 * @author FLD
 * @version
 * @date 2020年5月21日上午10:03:00
 *
 */

public class CustomerForQuery {
	
	
	
	/**
	 * 
	 * @Description 针对于customers表的通用查询操作
	 * @author FLD
	 * @throws Exception 
	 * @date 2020年5月21日下午3:55:19
	 */
	public Customer queryForCustomers(String sql,Object...args){
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
				Customer cust=new Customer();
				for(int i=0;i<columnCount;i++) {
					Object columnvalue = rs.getObject(i+1);
					//获取每个列的列名
					//String columnName = rsmd.getColumnName(i+1);
					String columnLabel = rsmd.getColumnLabel(i+1);
					//给cust指定的属性赋值,通过反射
					Field field = Customer.class.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(cust, columnvalue);
				}
				return cust;
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
		//执行并返回结果集
		ResultSet resultSet=null;
		try {
			conn = JDBCUtils.getConnection();
			String sql="select id,name,email,birth from customers where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, 1);
			resultSet = ps.executeQuery();
			//处理结果集
			if(resultSet.next()) {//next()判断结果集的下一条是否有数据
				//获取当前这条数据的各个字段值
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String email = resultSet.getString(3);
				Date birth = resultSet.getDate(4);
				//System.out.println("id="+id+",name="+name+",email="+email+",birth="+birth);
				//Object[] date=new Object[] {id,name,email,birth};
				//推荐：将数据封装成一个对象
				Customer customer = new Customer(id,name,email,birth);
				System.out.println(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭资源
			JDBCUtils.closeResource(conn, ps, resultSet);
		}
		
	}
	@Test
	public void testqueryforcustomers() {
		String sql="select id,name,birth,email from customers where id = ?";
		Customer customer = queryForCustomers(sql,13);
		System.out.println(customer);
	}
}
