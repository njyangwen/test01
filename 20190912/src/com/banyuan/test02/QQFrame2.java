/**
 * 
 */
package com.banyuan.test02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 * @author yw 2019年9月12日 下午1:20:10
 *
 */
public class QQFrame2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private DatagramSocket ds;
	private JTextArea taSend;
	private JTextArea taReceive;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QQFrame2 frame = new QQFrame2();
//					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QQFrame2() {
		setTitle("lisiQQ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		taReceive = new JTextArea();
		taReceive.setBackground(Color.PINK);
		taReceive.setBounds(20, 50, 600, 160);
//		panel.add(textArea);

		JScrollPane scrollPane = new JScrollPane(taReceive);
		scrollPane.setBounds(20, 50, 600, 160);
		panel.add(scrollPane);

		taSend = new JTextArea();
		taSend.setBackground(Color.YELLOW);
		taSend.setBounds(20, 260, 600, 160);
//		panel.add(textArea_1);

		JScrollPane scrollPane_1 = new JScrollPane(taSend);
		scrollPane_1.setBounds(20, 260, 600, 160);
		panel.add(scrollPane_1);

		JLabel label = new JLabel("接收内容：");
		label.setBounds(20, 22, 148, 16);
		panel.add(label);

		JLabel label_1 = new JLabel("发送内容：");
		label_1.setBounds(20, 232, 148, 16);
		panel.add(label_1);

		JButton button = new JButton("发送");
		button.setBounds(400, 432, 117, 29);
		button.addActionListener(this);
		panel.add(button);

		try {
			ds = new DatagramSocket(10001);
		}
		catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setVisible(true);
		
		MyThread mt=new MyThread(ds,taReceive);
		mt.start();

		
//		while (true) {
//			byte[] buf = new byte[1024];
//			DatagramPacket dp2 = new DatagramPacket(buf, buf.length);
//			try {
//				ds.receive(dp2);
////			System.out.println(
////			dp.getSocketAddress() + "===" + new Date() + "回传的内容:" + new String(dp2.getData(), 0, dp2.getLength()));
//
//				String reContent = dp2.getSocketAddress() + "===" + new Date() + "回传的内容:"
//						+ new String(dp2.getData(), 0, dp2.getLength());
//				taReceive.append(reContent + "\n");
//
//			}
//			catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

//		String str="中国";
		String str = taSend.getText();

		DatagramPacket dp;
		try {
			dp = new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("192.168.11.22"),
					10000);
			ds.send(dp);
			taSend.setText("");
//			byte[] buf = new byte[1024];
//			DatagramPacket dp2 = new DatagramPacket(buf, buf.length);
//			ds.receive(dp2);
////			System.out.println(
////					dp.getSocketAddress() + "===" + new Date() + "回传的内容:" + new String(dp2.getData(), 0, dp2.getLength()));
//			
//			String reContent=dp.getSocketAddress() + "===" + new Date() + "回传的内容:" + new String(dp2.getData(), 0, dp2.getLength());
//			taReceive.append(reContent+"\n");

		}
		catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
