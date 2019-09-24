/**
 * 
 */
package com.banyuan.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

/**
 * @author yw
 * 2019年9月24日  下午2:04:28
 *
 */
public class MyFactory<A> {
	
	private static HashMap<String,Object> objects=new HashMap<>();
	
	
	static {
		Properties p=new Properties();
		try {
			p.load(new FileReader("object.properties"));
			Set<Entry<Object,Object>> s=p.entrySet();
			Iterator<Entry<Object,Object>> it=s.iterator();
			while(it.hasNext()) {
				Entry<Object,Object> entry=it.next();
				String key=String.valueOf(entry.getKey());
				String value=String.valueOf(entry.getValue());
				
				Object obj=null;
				
				try {
					Class c1=Class.forName(value);
					obj=c1.newInstance();
				}
				catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				objects.put(key,obj);
				
			}
			
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public   A getInstance(String name) {
		System.out.println("===MyFactory===getInstance()==");
		A a=(A) objects.get(name);
		return a;
	}

}
