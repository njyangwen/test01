/**
 * 
 */
package com.banyuan.test02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author yw
 * 2019年9月7日  下午2:18:58
 *
 */
public class Test06 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		MyScanner ms=new MyScanner(System.in);
//		String s=ms.next();
		MyScanner ms;
		try {
			ms = new MyScanner(new FileInputStream("b"));
			String s=ms.nextFileAll();
			System.out.println("s="+s);
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
