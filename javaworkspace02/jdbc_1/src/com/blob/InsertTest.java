package com.blob;
/**
 * 
 * @Description 使用PreparedStatement实现批量数据的操作
 * @author FLD
 * @version
 * @date 2020年5月22日下午12:49:35
 *
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.util.JDBCUtils;

public class InsertTest {
	@Test
	//批量插入方式二
	public void testInsert1(){
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			long start = System.currentTimeMillis();
			conn = JDBCUtils.getConnection();
			String sql="insert into goods(name)values(?)";
			ps = conn.prepareStatement(sql);
			for(int i=1;i<=20000;i++) {
				ps.setObject(1, "name_"+i);
				
				ps.execute();
			}
			long end = System.currentTimeMillis();
			System.out.println("时间为："+(end-start));
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
	//批量插入的方式三
	/*
	 * 1.addBatch()\executeBatch()\clearBatch()
	 * 
	 */
	public void testInsert2(){
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			long start = System.currentTimeMillis();
			conn = JDBCUtils.getConnection();
			String sql="insert into goods(name)values(?)";
			ps = conn.prepareStatement(sql);
			for(int i=1;i<=20000;i++) {
				ps.setObject(1, "name_"+i);
				//"攒"sql
				ps.addBatch();
				if(i%500==0) {
					//执行
					ps.executeBatch();
					//清空
					ps.clearBatch();
				}
			}
			long end = System.currentTimeMillis();
			System.out.println("时间为："+(end-start));
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
	//批量插入方式四，终极方案
	public void testInsert3(){
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			long start = System.currentTimeMillis();
			conn = JDBCUtils.getConnection();
			//设置不允许自动提交
			conn.setAutoCommit(false);
			String sql="insert into goods(name)values(?)";
			ps = conn.prepareStatement(sql);
			for(int i=1;i<=1000000;i++) {
				ps.setObject(1, "name_"+i);
				//"攒"sql
				ps.addBatch();
				if(i%500==0) {
					//执行
					ps.executeBatch();
					//清空
					ps.clearBatch();
				}
			}
			conn.commit();
			long end = System.currentTimeMillis();
			System.out.println("时间为："+(end-start));
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.closeResource(conn, ps);
		}
		
	}
	
}
