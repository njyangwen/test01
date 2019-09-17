/**
 * 
 */
package com.banyuan.test01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import com.banyuan.test02.Friends;
import com.banyuan.test02.MyThread;

/**
 * @author yw 2019年9月16日 上午9:53:21
 *
 */
public class Test01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println("===server socket=port=10000=");
			ServerSocket ss = new ServerSocket(10000);
			Vector<Socket> sockets = new Vector<>();
			Vector<Friends> friendsList=new Vector<>();
			Friends f1=new Friends(10001,10002);
			Friends f2=new Friends(10001,10004);
			Friends f3=new Friends(10002,10003);
//			Friends f4=new Friends(10002,10001);
			
			friendsList.add(f1);
			friendsList.add(f2);
			friendsList.add(f3);
			
			// 张三10001，<李四10002，socket>
//	          <赵六10004，socket>
//			Hashtable<Integer, Hashtable<Integer, Socket>> friends = new Hashtable<>();
//			localport  10001  10002  10003  10004  
//	           张三    李四    王五    赵六
			// 好友
//			张三   李四      
//		          赵六
//			赵六   张三
//
//			李四  张三
//		         王五  
			
//			王五   李四
			
//			friends.put(key, value)
						
			while (true) {
				System.out.println("==accepte===");
				Socket s = ss.accept();
				sockets.add(s);
				
//				//张三
//				if(s.getLocalPort()==10001) {
//					
//				}
				
//				InputStream is = s.getInputStream();
//				BufferedReader br = new BufferedReader(new InputStreamReader(is));
//				String str = br.readLine();
//				System.out.println("port=" + s.getPort() + ",localPort=" + s.getLocalPort() + "接收的内容" + str);
////				s.close();
//				br.close();

				MyThread mt = new MyThread(s, sockets,friendsList);
				mt.start();
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
