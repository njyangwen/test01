/**
 * 
 */
package com.banyuan.test04;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 * @author yw 2019年9月11日 下午2:04:16
 *
 */
public class BankFrame extends JFrame implements ActionListener{

	private JPanel contentPane;
	private Bank bank;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankFrame frame = new BankFrame();
					frame.setVisible(true);
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
	public BankFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JTextArea ta_a = new JTextArea();
		ta_a.setBounds(65, 100, 300, 400);
//		panel.add(ta_a);

		JTextArea ta_b = new JTextArea();
		ta_b.setBounds(450, 135, 300, 400);
//		panel.add(ta_b);

		JScrollPane scrollPane = new JScrollPane(ta_a);
		scrollPane.setBounds(65, 100, 300, 400);
		panel.add(scrollPane);

		JScrollPane scrollPane_1 = new JScrollPane(ta_b);
		scrollPane_1.setBounds(450, 100, 300, 400);
		panel.add(scrollPane_1);

		JLabel lblA = new JLabel("A账户情况");
		lblA.setBounds(65, 59, 61, 16);
		panel.add(lblA);

		JLabel lblB = new JLabel("B账户情况");
		lblB.setBounds(450, 59, 61, 16);
		panel.add(lblB);
		
		bank=new Bank(ta_a,ta_b,true);
		
		JButton btn_stop = new JButton("停止交易");
		btn_stop.setBounds(65, 546, 117, 29);
		panel.add(btn_stop);
		btn_stop.addActionListener(this);
		
		
		MyThread a=new MyThread("A",bank);
		MyThread b=new MyThread("B",bank);
		
		Thread t1=new Thread(a);
		Thread t2=new Thread(b);
		t1.start();
		t2.start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		bank.setFlag(false);
	}
}
