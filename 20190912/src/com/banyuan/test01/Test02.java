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

/**
 * @author yw 2019年9月12日 上午9:37:18
 *
 */
public class Test02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("==udp===receive=");
		try {
			DatagramSocket ds = new DatagramSocket(10001);
			// String str="helloworld";
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			System.out.println("====aaa====");
			String str="接收成功";
			while (true) {
				ds.receive(dp);
				System.out.println(dp.getSocketAddress()+"==="+new Date()+"内容:"+new String(dp.getData(),0,dp.getLength()));
				
				DatagramPacket dp2 = new DatagramPacket(str.getBytes(), str.getBytes().length,
						InetAddress.getByName("192.168.11.22"), 10000);
				ds.send(dp2);
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
