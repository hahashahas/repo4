package com.blob;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.bean.Customer;
import com.util.JDBCUtils;

/**
 * 
 * @Description 使用PreparedStatement操作Blod类型的数据
 * @author FLD
 * @version
 * @date 2020年5月21日下午11:08:17
 *
 */
public class BlobTest {
	@Test
	//向数据表customers中插入blob类型的字段
	public void getConnection() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		String sql="insert into customers(name,email,birth,photo)values(?,?,?,?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, "啦啦啦啦");
		ps.setObject(2, "12211@12.com");
		ps.setObject(3, "1982-09-08");
		FileInputStream is = new FileInputStream(new File("pic1.png"));
		ps.setBlob(4, is);
		ps.execute();
		JDBCUtils.closeResource(conn, ps);
	}
	//查询数据表customers中的blob类型的字段
	@Test
	public void testQuery() {
		Connection conn=null;
		PreparedStatement ps=null;
		InputStream is=null;
		FileOutputStream fos=null;
		ResultSet rs=null;
		try {
			conn = JDBCUtils.getConnection();
			String sql="select id,name,email,birth,photo from customers where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 21);
			is = null;
			fos = null;
			rs = ps.executeQuery();
			if(rs.next()) {
				/*int id = rs.getInt(1);
				String name = rs.getString(2);
				String email= rs.getString(3);
				Date birth = rs.getDate(4);*/
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email= rs.getString("email");
				Date birth = rs.getDate("birth");
				
				Customer cust = new Customer(id,name,email,birth);
				System.out.println(cust);
				//将blob类型的字段下载下来，以文件的方式保存在本地
				Blob photo = rs.getBlob("photo");
				is = photo.getBinaryStream();
				fos=new FileOutputStream("pic2.png");
				byte[] buffer=new byte[1024];
				int len;
				
				while((len = is.read(buffer))!=-1) {
					fos.write(buffer,0,len);
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(is!=null)
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(fos!=null)
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JDBCUtils.closeResource(conn, ps, rs);
		}
		
	}
}
