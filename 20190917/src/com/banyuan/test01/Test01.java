/**
 * 
 */
package com.banyuan.test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author yw
 * 2019年9月17日  下午1:22:36
 *
 */
public class Test01 {
	public static void main(String[] args) {
		try {
			System.setOut(new PrintStream("baiduwenku.txt"));
//			URL url=new URL("http://192.168.11.22:14809/webtest01/helloworld.html");
			//http://sports.sina.com.cn/basketball/nba/2019-09-17/doc-iicezzrq6397471.shtml
			URL url=new URL("https://wenku.baidu.com/view/dff4aac29ec3d5bbfd0a74f0.html");
			System.out.println("Authority="+url.getAuthority());
			System.out.println("host="+url.getHost());
			System.out.println("content="+url.getContent());
			System.out.println("path="+url.getPath());
			System.out.println("===============");
			URLConnection conn =url.openConnection();
			InputStream is=conn.getInputStream();
			BufferedReader br=new BufferedReader(new InputStreamReader(is));
			String line=null;
			while((line=br.readLine())!=null) {
				System.out.println(line);
			}
			System.out.println("===============");

		
		}
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
