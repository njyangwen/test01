/**
 * 
 */
package com.banyuan.test;

import java.util.Vector;

import com.banyuan.entity.Student;
import com.banyuan.entity.Teacher;
import com.banyuan.service.StudentService;
import com.banyuan.service.TeacherService;
import com.banyuan.util.MyFactory;

/**
 * @author yw
 * 2019年9月24日  下午2:50:14
 *
 */
public class Test01 {
	public static void main(String[] args) {
//		MyFactory<StudentService> mf=new MyFactory<>();
		
//		ArrayList al;
		
//		Object obj= MyFactory.getInstance("studentService");
		StudentService service=(StudentService)MyFactory.getInstance("studentService");
		System.out.println("service="+service);
		
		Vector v=service.getData(1, 3);
		System.out.println("v="+v);
		
		Student stu=new Student();
		stu.setName("zhang");
		Vector v2=service.getDataByName(1, 3, stu);
		System.out.println("v2="+v2);
		
		System.out.println("*******************************");
		
		TeacherService service2=(TeacherService)MyFactory.getInstance("teacherService");
		System.out.println("service2="+service2);
		
		Vector v3=service2.getData(1, 3);
		System.out.println("v3="+v3);
		
		Teacher tea=new Teacher();
		tea.setName("zhang");
		Vector v4=service2.getDataByName(1, 3, tea);
		System.out.println("v4="+v4);
		
	}

}
