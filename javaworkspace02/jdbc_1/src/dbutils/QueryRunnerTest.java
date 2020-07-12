package dbutils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.bean.Customer;
import com.util4.JDBCUtils;

public class QueryRunnerTest {
	@Test
	// 测试插入
	public void testInsert() {
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection3();
			String sql = "insert into customers(name,email,birth)values(?,?,?)";
			int insertCount = runner.update(conn, sql, "蔡徐坤", "caixukun163.com", "1997-09-08");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}

	}

	// 测试查询
	// BeanHander
	@Test
	public void testQuery1() {
		Connection conn = null;
		Customer customer = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection3();
			String sql = "select id,name,email,birth from customers where id = ?";
			BeanHandler<Customer> hander = new BeanHandler<>(Customer.class);
			customer = runner.query(conn, sql, hander, 22);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}

	}

	@Test
	// BeanListHandler
	public void testQuery2() {
		Connection conn = null;
		List<Customer> list = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection3();
			String sql = "select id,name,email,birth from customers where id < ?";
			BeanListHandler<Customer> hander = new BeanListHandler<>(Customer.class);
			list = runner.query(conn, sql, hander, 22);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}

		list.forEach(System.out::println);
	}

	// MapHander
	@Test
	public void testQuery3() {
		Connection conn = null;
		Customer customer = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection3();
			String sql = "select id,name,email,birth from customers where id = ?";
			MapHandler hander = new MapHandler();
			Map<String, Object> map = runner.query(conn, sql, hander, 22);
			System.out.println(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}
	}

	// ScalarHandler查询特殊值
	@Test
	public void testQuery4() {
		Connection conn = null;
		Customer customer = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection3();
			String sql = "select count(*) from customers";
			ScalarHandler hander = new ScalarHandler();
			Long count = (Long) runner.query(conn, sql, hander);
			System.out.println(count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}
	}

	@Test
	public void testQuery5() {
		Connection conn = null;
		Customer customer = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection3();
			String sql = "select max(birth) from customers";
			ScalarHandler hander = new ScalarHandler();
			Date maxBirth = (Date) runner.query(conn, sql, hander);
			System.out.println(maxBirth);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}
	}
}
