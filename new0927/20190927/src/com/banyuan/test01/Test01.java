/**
 * 
 */
package com.banyuan.test01;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * @author yw 2019年9月27日 上午9:12:29
 *
 */
public class Test01 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/ywdb2";
			String username = "root";
			String password = "Root_123";
			Connection con = DriverManager.getConnection(url, username, password);
//			CallableStatement cs= con.prepareCall("call studentage()");
//			CallableStatement cs = con.prepareCall("call queryallstudent()");
			CallableStatement cs = con.prepareCall("call querystudent3(?)");
			cs.setObject(1, "w");
			ResultSet rs = cs.executeQuery();
//			System.out.println("id\tname\t\tage");
			while (rs.next()) {
				
				System.out.println("==="+rs.getObject(1));
//				System.out.println(rs.getObject(1) + "\t" + rs.getObject(2)
//						+ ((String.valueOf(rs.getObject(2)).length() >= 8 ? "" : "\t")) + "\t" + rs.getObject(3));
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
