/**
 * 
 */
package com.banyuan.service.impl;

import java.util.Vector;

import com.banyuan.dao.TeacherDao;
import com.banyuan.entity.Teacher;
import com.banyuan.service.TeacherService;
import com.banyuan.util.MyFactory;

/**
 * @author yw
 * 2019年9月20日  下午3:10:01
 *
 */
public class TeacherServiceImpl implements TeacherService{
	
	private TeacherDao teacherDao=	(TeacherDao)MyFactory.getInstance("teacherDao");

	
	//逻辑
	public Vector getData(int curPage, int count) throws RuntimeException{
//		BaseDB sdb=new BaseDB();
//		StudentDao dao=new StudentDaoImpl();
		Vector d=teacherDao.getData(curPage, count);
		//curPage范围0 -1   >总页数?
//		return sdb.getData(curPage, count);
		return d;
	}

	@Override
	public Vector getDataByName(int curPage, int count, Teacher teacher) {
		
		//判断页面的数值是否在有效范围curPage>0
		
		//符合条件，调用dao层功能
//		StudentDao dao=new StudentDaoImpl();
		TeacherDao teacherDao=	(TeacherDao)MyFactory.getInstance("teacherDao");
		
		Vector d=teacherDao.getDataByName(curPage, count,teacher);
		
		return d;
	}

}
