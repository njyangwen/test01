/**
 * 
 */
package com.banyuan.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author yw 2019年9月27日 上午9:12:29
 *
 */
public class Test02 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/ywdb2";
			String username = "root";
			String password = "Root_123";
			Connection con = DriverManager.getConnection(url, username, password);
			Statement st = con.createStatement();
//			st.executeQuery("select * from stu_info");
			String name = "zhangsan";
			String pwd = "a1234'  or '1' = '1";//拼接sql--》Sql注入（黑客）

			ResultSet rs = st.executeQuery("select * from usermanager where name= '" + name + "' and password= '" + pwd+"'");
			System.out.println("==========");
			while (rs.next()) {
//				System.out.println("==="+rs.getObject(1));
				System.out.println(rs.getObject(1) + "\t" + rs.getObject(2)
						+ ((String.valueOf(rs.getObject(2)).length() >= 8 ? "" : "\t")) + "\t" + rs.getObject(3));
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
