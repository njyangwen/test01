/**
 * 
 */
package com.banyuan.dao;

import java.util.Vector;

import com.banyuan.entity.Student;

/**
 * @author yw
 * 2019年9月23日  上午9:30:45
 *
 */
public interface StudentDao {
	public Vector getData(int curPage, int count) ;
	public Vector getDataByName(int curPage, int count, Student student);
	public void updateData(Student student);
	public void insertData(Student student);
	public void deleteData(Student student) ;

}
