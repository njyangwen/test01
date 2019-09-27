/**
 * 
 */
package com.banyuan.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.banyuan.dao.TeacherDao;
import com.banyuan.entity.Teacher;
import com.banyuan.util.BaseDB;
import com.banyuan.util.JDBCUtil;
import com.banyuan.util.ResultSetDB;

/**
 * @author yw 2019年9月23日 上午9:32:10
 *
 */
public class TeacherDaoImpl implements TeacherDao {

	private BaseDB db = new BaseDB();

	private JDBCUtil jdbcutil = new JDBCUtil();
	
	
	private ResultSetDB resultSetDB = new ResultSetDB() {

		@Override
		public Vector getData(ResultSet rs) {
			Vector d = new Vector();
			try {
				while (rs.next()) {
					Vector line = new Vector();
					line.add(rs.getObject(1));
					line.add(rs.getObject(2));
					

					d.add(line);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return d;

		}

	};

	public void updateData(Teacher teacher) {

		String sql = "update teacher set name=? where id=? ";
		jdbcutil.modify(sql, teacher.getName(), teacher.getId());

	}

	public void insertData(Teacher teacher) {

		String sql = "insert into teacher(name) values(?)";

		jdbcutil.modify(sql, teacher.getName());

	}

	public void deleteData(Teacher teacher) {
		String sql = "delete from teacher where id=?";
		jdbcutil.modify(sql, teacher.getId());
	}
	
	
	public Vector getDataByName(int curPage, int count, Teacher teacher) {
		System.out.println("===StudentDaoImpl==getDataByName(int curPage, int count, Student student)==");
		
		Vector data = new Vector();

		String sql = "select * from teacher  where name like ?  limit ?,?";		

		data = jdbcutil.query(sql, resultSetDB, teacher.getName()+"%",(curPage - 1) * count, count);

		return data;
		
	}

	@Override
	public Vector getData(int curPage, int count) {
		
		System.out.println("===StudentDaoImpl==Vector getData(int curPage, int count)==");

		Vector data = new Vector();

		String sql = "select * from stu_info limit ?,?";
		
		data = jdbcutil.query(sql, resultSetDB, (curPage - 1) * count, count);

		return data;

	}

}
