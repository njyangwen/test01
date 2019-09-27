/**
 * 
 */
package com.banyuan.test01;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author yw
 * 2019年9月27日  下午1:10:38
 *
 */
public class Test03 {
	private Logger logger=Logger.getLogger("com.banyuan.test01.Test03");
	
	public static void main(String[] args) {
		
//		Logger logger=Logger.getLogger("com.banyuan.test01.Test03");
//		logger.log(Level.WARNING,"hello");
		Test03 t=new Test03();
		t.test01();
		t.test02();
		
	}
	
	public void test01() {
		
		logger.log(Level.WARNING,"helloworld");

	}
	public void test02() {
		
		logger.log(Level.INFO,"helloworld====");

	}


}
