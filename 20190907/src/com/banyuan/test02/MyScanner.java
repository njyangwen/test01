/**
 * 
 */
package com.banyuan.test02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author yw 2019年9月7日 下午2:15:32
 *
 */
public class MyScanner {

	private BufferedReader br = null;

	public MyScanner(InputStream is) {

		br = new BufferedReader(new InputStreamReader(is));

	}

	public String next() {
		String str = "";
		try {
			str = br.readLine();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	public String nextKeyBoardAll() {
		String str = "";
		StringBuilder builder=new StringBuilder();
		try {
			while(!("quit".equals((str = br.readLine())))){
				builder.append(str);
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return builder.toString();
	}
	public String nextFileAll() {
		String str = "";
		StringBuilder builder=new StringBuilder();
		try {
			while(((str = br.readLine()))!=null){
				builder.append(str).append("\r");
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return builder.toString();
	}

}
