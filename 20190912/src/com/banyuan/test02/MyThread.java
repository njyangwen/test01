/**
 * 
 */
package com.banyuan.test02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

import javax.swing.JTextArea;

/**
 * @author yw
 * 2019年9月16日  上午9:37:47
 *
 */
public class MyThread extends Thread {
	private DatagramSocket ds;
	private JTextArea taReceive;
	
	public MyThread(DatagramSocket ds,JTextArea taReceive) {
		this.ds=ds;
		this.taReceive=taReceive;
	}

	public void run() {
		while (true) {
			byte[] buf = new byte[1024];
			DatagramPacket dp2 = new DatagramPacket(buf, buf.length);
			try {
				ds.receive(dp2);
//			System.out.println(
//			dp.getSocketAddress() + "===" + new Date() + "回传的内容:" + new String(dp2.getData(), 0, dp2.getLength()));

				String reContent = dp2.getSocketAddress() + "===" + new Date() + "回传的内容:"
						+ new String(dp2.getData(), 0, dp2.getLength());
				taReceive.append(reContent + "\n");

			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
