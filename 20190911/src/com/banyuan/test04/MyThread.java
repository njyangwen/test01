/**
 * 
 */
package com.banyuan.test04;

import javax.swing.JTextArea;

/**
 * @author yw 2019年9月11日 下午1:51:23
 *
 */
public class MyThread implements Runnable {

	private Bank bank;
	private String name;
//	private JTextArea jta_a;
//	private JTextArea jta_b;

	public MyThread(String name, Bank bank) {
		this.name = name;
		this.bank = bank;
		

	}

	public void run() {
		for (;;) {
			if ("A".equals(name)) {
				bank.giveMoneyAB();
			} else {
				bank.giveMoneyBA();
			}
		}

	}
}
