/**
 * 
 */
package com.banyuan.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import com.banyuan.view.MyFrame;

/**
 * @author yw
 * 2019年9月20日  下午1:54:13
 *
 */
public class MainFrame extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 635);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 924, 52);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton button = new JButton("学生管理");
		button.addActionListener(this);
		button.setBounds(16, 6, 117, 29);
		panel.add(button);
		
		JButton button_1 = new JButton("用户管理");
		button_1.setBounds(165, 6, 117, 29);
		panel.add(button_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		MyFrame frame = new MyFrame();
//		frame.setVisible(true);
//		MyFrame frame=MyFrame.getInstance();
		StudentFrame frame=StudentFrame.getInstance();
		frame.setVisible(true);
		
	}

}
