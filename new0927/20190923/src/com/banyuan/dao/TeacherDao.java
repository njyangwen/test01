/**
 * 
 */
package com.banyuan.dao;

import java.util.Vector;

import com.banyuan.entity.Teacher;

/**
 * @author yw
 * 2019年9月23日  上午9:30:45
 *
 */
public interface TeacherDao {
	public Vector getData(int curPage, int count) ;
	public Vector getDataByName(int curPage, int count, Teacher teacher);
	public void updateData(Teacher teacher);
	public void insertData(Teacher teacher);
	public void deleteData(Teacher teacher) ;

}
