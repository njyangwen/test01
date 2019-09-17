/**
 * 
 */
package com.banyuan.test02;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 * @author yw 2019年9月16日 下午1:40:04
 *
 */
public class ClientFrame2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextArea taSend;
	private JTextArea taReceive;
	private Socket s;
	private PrintWriter pw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ClientFrame2 frame = new ClientFrame2();
//		frame.setVisible(true);
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ClientFrame1 frame = new ClientFrame1();
//					frame.setVisible(true);
//				}
//				catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the frame.
	 */
	public ClientFrame2() {
		setTitle("client2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(23, 169, 554, 187);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 17, 374, 135);
		panel.add(scrollPane);

		taSend = new JTextArea();
		taSend.setBackground(Color.ORANGE);
		scrollPane.setViewportView(taSend);

		JButton btnSend = new JButton("好友群发");
		btnSend.addActionListener(this);
		btnSend.setBackground(Color.PINK);
		btnSend.setBounds(408, 36, 117, 73);
		panel.add(btnSend);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(23, 16, 554, 141);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 5, 542, 130);
		panel_1.add(scrollPane_1);

		taReceive = new JTextArea();
		scrollPane_1.setViewportView(taReceive);
		setVisible(true);

		try {
			s = new Socket("192.168.11.22", 10000, InetAddress.getByName("192.168.11.22"), 10002);
			System.out.println("client===socket===");
			System.out.println("port=" + s.getPort() + ",localPort=" + s.getLocalPort());
//			OutputStream os = s.getOutputStream();
//			pw = new PrintWriter(os, true);

			InputStream is = s.getInputStream();
			while (true) {
				is = s.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				String str = br.readLine();
				if (str != null) {
//					System.out.println("port=" + s.getPort() + ",localPort=" + s.getLocalPort() + "接收的内容" + str);
					taReceive.append("port=" + s.getPort() + ",localPort=" + s.getLocalPort() + "接收的内容" + str+"\n");
				}
			}

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

	@Override
	public void actionPerformed(ActionEvent e1) {

		System.out.println("===client socket==1==send=click=");
//			Socket s=new Socket("192.168.11.22",10000);
//			System.out.println("port="+s.getPort()+",localPort="+s.getLocalPort());
//			OutputStream os=s.getOutputStream();
//			PrintWriter pw=new PrintWriter(os,true);
//			pw.println("hello");
//		pw.println(taSend.getText());
		try {
//			s = new Socket("192.168.11.22", 10000,InetAddress.getByName("192.168.11.22"),10001);
			System.out.println("client===socket===");
			System.out.println("port=" + s.getPort() + ",localPort=" + s.getLocalPort());
			OutputStream os = s.getOutputStream();
			pw = new PrintWriter(os, true);
			pw.println(taSend.getText());
			pw.flush();
//			pw.close();
//			s.close();

		}
		catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		taSend.setText("");

	}
}
