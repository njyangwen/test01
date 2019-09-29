/**
 * 
 */
package com.banyuan.test01;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

/**
 * @author yw
 * 2019年9月29日  下午1:39:45
 *
 */
public class Test01 {
	public static void main(String[] args) {
		List<People> list1=new ArrayList<>();
		
				
		People zhangsan=new People();
		zhangsan.setId(1);
		zhangsan.setName("张三");
		Address a1=new Address();
		a1.setHomeAddress("nanjing");
		a1.setCompanyAddress("shanghai");
		zhangsan.setAddress(a1);
		
		
		People lisi=new People();
		lisi.setId(2);
		lisi.setName("李四");
		Address a2=new Address();
		a2.setHomeAddress("beijing");
		a2.setCompanyAddress("shanghai");
		lisi.setAddress(a2);
		
		
		
		People wangwu=new People();
		wangwu.setId(3);
		wangwu.setName("王五");
		Address a3=new Address();
		a3.setHomeAddress("nanjing");
		a3.setCompanyAddress("hainan");
		wangwu.setAddress(a3);
		
		
		
		People zhaoliu=new People();
		zhaoliu.setId(4);
		zhaoliu.setName("赵六");
		Address a4=new Address();
		a4.setHomeAddress("beijing");
		a4.setCompanyAddress("shanghai");
		zhaoliu.setAddress(a4);
		
		
		People xiaoli=new People();
		xiaoli.setId(4);
		xiaoli.setName("小丽");
		Address a5=new Address();
		a5.setHomeAddress("hainan");
		a5.setCompanyAddress("shanghai");
		xiaoli.setAddress(a5);

		
		//zhansan ,lisi,wangwu 好友
		//zhaoliu，wangwu,lisi,xiaoli 好友
		List<People> list2=new ArrayList<>();
		list2.add(lisi);
		list2.add(wangwu);
		zhangsan.setFriends(list2);
		
		List<People> list3=new ArrayList<>();
		list3.add(lisi);
		list3.add(wangwu);
		list3.add(xiaoli);
		zhaoliu.setFriends(list3);
		
		list1.add(zhangsan);
		list1.add(zhaoliu);
		
		Gson gson=new Gson();
		String str=gson.toJson(list1);
		System.out.println("str="+str);

		
	}

}
