/**
 * 
 */
package com.banyuan.service;

import java.util.Vector;

import com.banyuan.db.BaseDB;
import com.banyuan.entity.Student;

/**
 * @author yw
 * 2019年9月20日  下午3:10:01
 *
 */
public interface StudentService {
	
	//逻辑
	public Vector getData(int curPage, int count) ;
	
	public Vector getDataByName(int curPage, int count, Student student);

}
