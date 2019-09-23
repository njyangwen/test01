/**
 * 
 */
package com.banyuan.service.impl;

import java.util.Vector;

import com.banyuan.dao.StudentDao;
import com.banyuan.dao.impl.StudentDaoImpl;
import com.banyuan.entity.Student;
import com.banyuan.service.StudentService;

/**
 * @author yw
 * 2019年9月20日  下午3:10:01
 *
 */
public class StudentServiceImpl implements StudentService{
	
	//逻辑
	public Vector getData(int curPage, int count) throws RuntimeException{
//		BaseDB sdb=new BaseDB();
		StudentDao dao=new StudentDaoImpl();
		Vector d=dao.getData(curPage, count);
		//curPage范围0 -1   >总页数?
//		return sdb.getData(curPage, count);
		return d;
	}

	@Override
	public Vector getDataByName(int curPage, int count, Student student) {
		
		//判断页面的数值是否在有效范围curPage>0
		
		//符合条件，调用dao层功能
		StudentDao dao=new StudentDaoImpl();
		Vector d=dao.getDataByName(curPage, count,student);
		
		return d;
	}

}
