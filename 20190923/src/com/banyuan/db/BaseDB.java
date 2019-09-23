/**
 * 
 */
package com.banyuan.db;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;

/**
 * @author yw 2019年9月20日 下午3:12:46
 *
 */
public class BaseDB {

	public Connection getConnection() {
		Connection conn = null;

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 读取db.properties
			Properties p = new Properties();
			p.load(new FileReader("db.properties"));
			String url = p.getProperty("url");
			String username = p.getProperty("username");
			String password = p.getProperty("password");
			conn = DriverManager.getConnection(url, username, password);

		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}
	
	
	public void DBClose(Connection conn,Statement ps,ResultSet rs) {
		
		if (rs != null) {
			try {
				rs.close();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}

	public Vector getData(int curPage, int count) {
		Vector data = new Vector();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 读取db.properties
			Properties p = new Properties();
			p.load(new FileReader("db.properties"));
			String url = p.getProperty("url");
			String username = p.getProperty("username");
			String password = p.getProperty("password");
			conn = DriverManager.getConnection(url, username, password);
			// 分页
			String sql = "select * from stu_info limit ?,?";
			ps = conn.prepareStatement(sql);
			// 1 2 3
			ps.setObject(1, (curPage - 1) * count); // 0,3 3,3 6,3
													// 0,2 2,2 4,2
			ps.setObject(2, count);

			rs = ps.executeQuery();

//			System.out.println("id\tname\tage\tbirthday\tsex");
			while (rs.next()) {
//				System.out.println(rs.getObject(1)+" "+rs.getObject(2)+" "+rs.getObject(3)+" "+rs.getObject(4)+" "+rs.getObject(5));
				Vector line = new Vector();
				line.add(rs.getObject(1));
				line.add(rs.getObject(2));
				line.add(rs.getObject(3));
				line.add(rs.getObject(4));
				line.add(rs.getObject(5));

				data.add(line);

			}

		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (rs != null) {
				try {
					rs.close();
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return data;
	}

}
