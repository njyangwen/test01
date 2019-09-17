/**
 * 
 */
package com.banyuan.test04;

import java.util.Random;

import javax.swing.JTextArea;

/**
 * @author yw 2019年9月11日 下午1:46:41
 *
 */
public class Bank {

	private int moneyA = 500;
	private int moneyB = 500;
	private JTextArea jta_a;
	private JTextArea jta_b;
	private boolean flag;// true:正常交易 false：停止交易

	public Bank(JTextArea jta_a, JTextArea jta_b,boolean flag) {
		this.jta_a = jta_a;
		this.jta_b = jta_b;
		this.flag=flag;
	}
	
	public void setFlag(boolean flag)
	{
		this.flag=flag;
	}

	// A-->B
	public synchronized void giveMoneyAB() {
		if (flag) {
			try {
				Thread.sleep(500);
			}
			catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (moneyA > 0) {
				Random r = new Random();
				int money = r.nextInt(moneyA + 1);
				moneyA -= money;
				moneyB += money;
				// System.out.println("A--->B"+"转了"+money+"钱。"+"moneyA="+moneyA+",moneyB="+moneyB);
				jta_a.append("A--->B" + "转了" + money + "元钱。moneyA=" + moneyA + "\n");
				jta_b.append("A--->B" + "转了" + money + "元钱。moneyB=" + moneyB + "\n");
			} else {
				notify();
				try {
					wait();
				}
				catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	// B-->A
	public synchronized void giveMoneyBA() {
		if (flag) {
			try {
				Thread.sleep(500);
			}
			catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if (moneyB > 0) {
				Random r = new Random();
				int money = r.nextInt(moneyB + 1);
				moneyB -= money;
				moneyA += money;
//			System.out.println("B--->A"+"转了"+money+"钱。"+"moneyA="+moneyA+",moneyB="+moneyB);
				jta_a.append("B--->A" + "转了" + money + "元钱。moneyA=" + moneyA + "\n");
				jta_b.append("B--->A" + "转了" + money + "元钱。moneyB=" + moneyB + "\n");

			} else {
				notify();
				try {
					wait();
				}
				catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
