/**
 * 
 */
package com.banyuan.test01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;
import java.util.Scanner;

/**
 * @author yw 2019年9月12日 上午9:37:18
 *
 */
public class Test01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("==udp=send==");
		try {
			DatagramSocket ds = new DatagramSocket(10000);
//			String str="中国";
			Scanner sc = new Scanner(System.in);
			while (true) {
				System.out.println("请输入内容：");
				String str = sc.nextLine();
				DatagramPacket dp = new DatagramPacket(str.getBytes(), str.getBytes().length,
						InetAddress.getByName("192.168.11.22"), 10001);
				ds.send(dp);
				byte[] buf = new byte[1024];
				DatagramPacket dp2 = new DatagramPacket(buf, buf.length);
				ds.receive(dp2);
				System.out.println(dp.getSocketAddress()+"==="+new Date()+"回传的内容:"+new String(dp2.getData(),0,dp2.getLength()));
				


			}
		}
		catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
