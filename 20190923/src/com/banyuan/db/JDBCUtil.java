/**
 * 
 */
package com.banyuan.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 * @author yw 2019年9月23日 上午10:05:55
 *
 */
public class JDBCUtil {
	private BaseDB db = new BaseDB();

	public void modify(String sql, Object... args) {
		Connection conn = null;
		conn = db.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			ps.executeUpdate();

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			db.DBClose(conn, ps, null);
		}

	}

	public Vector query(String sql, ResultSetDB resultSetDB,Object... args) {

		Vector data = new Vector();

		Connection conn = null;
		conn = db.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			rs = ps.executeQuery();

			data=resultSetDB.getData(rs);

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			db.DBClose(conn, ps, null);
		}
		return data;
	}
	
	
}
