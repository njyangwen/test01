/**
 * 
 */
package com.banyuan.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.banyuan.service.StudentService;
import com.banyuan.service.impl.StudentServiceImpl;
import com.banyuan.util.MyFactory;

/**
 * @author yw 2019年9月20日 上午10:11:52
 *
 */
public class StudentFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private JTextField tfCurPage;
	private JTextField tfCount;
	private Vector data;
	private Vector colName;

	//单例设计模式，每个窗口只打开一个
	private static StudentFrame mf=new StudentFrame();
	
	public static StudentFrame getInstance() {
		return mf;
	}

	/**
	 * Create the frame.
	 */
	private StudentFrame() {
		setVisible(true);
		setTitle("学生信息表");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 796, 517);
		setSize(796, 517);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(30, 102, 733, 359);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 721, 347);
		panel.add(scrollPane);

//		StudentService ss=new StudentServiceImpl();
		StudentService ss=new MyFactory<StudentService>().getInstance("studentService");
		data = ss.getData(1, 3);
		colName = new Vector();
		colName.add("id");
		colName.add("name");
		colName.add("age");
		colName.add("birthday");
		colName.add("sex");

		table = new JTable(data, colName);
		scrollPane.setViewportView(table);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(30, 26, 733, 68);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel label = new JLabel("跳转到第");
		label.setBounds(6, 24, 61, 16);
		panel_1.add(label);

		tfCurPage = new JTextField();
		tfCurPage.setHorizontalAlignment(SwingConstants.CENTER);
		tfCurPage.setText("1");
		tfCurPage.setBounds(67, 19, 61, 26);
		panel_1.add(tfCurPage);
		tfCurPage.setColumns(10);

		JLabel label_1 = new JLabel("页");
		label_1.setBounds(140, 24, 61, 16);
		panel_1.add(label_1);

		JLabel label_2 = new JLabel("每页");
		label_2.setBounds(182, 24, 41, 16);
		panel_1.add(label_2);

		tfCount = new JTextField();
		tfCount.setHorizontalAlignment(SwingConstants.CENTER);
		tfCount.setText("3");
		tfCount.setBounds(236, 19, 61, 26);
		panel_1.add(tfCount);
		tfCount.setColumns(10);

		JLabel label_3 = new JLabel("条");
		label_3.setBounds(309, 24, 61, 16);
		panel_1.add(label_3);

		JButton btnQuery = new JButton("跳转");
		btnQuery.addActionListener(this);
		btnQuery.setBounds(376, 19, 117, 29);
		panel_1.add(btnQuery);
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// tfCurPage.getText()
		String strCurPage = tfCurPage.getText();
		String strCount = tfCount.getText();
		//if (strCurPageString.trim().length() == 0) {
		boolean flag=Pattern.matches("\\d+", strCurPage);
		
		if(!flag) {
			String message = "请输入要跳转的页面号";
			JOptionPane.showMessageDialog(null, message);
		}
	}
}
