package preparedstatement.crud;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import com.util.JDBCUtils;

/**
 * 
 * @Description 解决SQL注入问题
 * @author FLD
 * @version
 * @date 2020年5月21日下午8:26:31
 *
 */
public class PreparedStatementTest {
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
}
