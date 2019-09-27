/**
 * 
 */
package com.banyuan.service;

import java.util.List;
import java.util.Vector;

import com.banyuan.entity.Student;
import com.banyuan.util.BaseDB;

/**
 * @author yw
 * 2019年9月20日  下午3:10:01
 *
 */
public interface StudentService {
	
	//逻辑
	public Vector getData(int curPage, int count) ;
	
	public Vector getDataByName(int curPage, int count, Student student);
	
	public List getStudentByProc(Student student);


}
