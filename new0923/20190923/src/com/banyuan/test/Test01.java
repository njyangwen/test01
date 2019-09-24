/**
 * 
 */
package com.banyuan.test;

import com.banyuan.service.StudentService;
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
		StudentService obj=new MyFactory<StudentService>().getInstance("studentService");
		System.out.println("obj="+obj);
	}

}
