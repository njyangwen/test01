/**
 * 
 */
package com.banyuan.test01;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author yw
 * 2019年9月16日  上午9:58:58
 *
 */
public class Test02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println("===client socket==1==");
			Socket s=new Socket("192.168.11.22",10000);
			System.out.println("port="+s.getPort()+",localPort="+s.getLocalPort());
			OutputStream os=s.getOutputStream();
			PrintWriter pw=new PrintWriter(os,true);
			pw.println("hello");
			
		}
		catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
