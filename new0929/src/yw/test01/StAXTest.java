/**
 * 
 */
package com.yw.test01;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 * @author yw 2019年9月28日 下午4:23:29
 *
 */
public class StAXTest {
	/**
	 * 有XMLDOM解析、SAX解析、StAX解析 XMLDOM：（XMLDocumentObjectModel）处理大型文件时其性能下降的非常厉害。
	 * 这个问题是由DOM的树结构所造成的，这种结构占用的内存较多， 而且DOM必须在解析文件之前把整个文档装入内存,适合对XML的随机访问；
	 * SAX：（SimpleAPIforXML）不同于DOM,SAX是事件驱动型的XML解析方式。 它顺序读取XML文件，不需要一次全部装载整个文件。
	 * 当遇到像文件开头，文档结束，或者标签开头与标签结束时， 它会触发一个事件，用户通过在其回调事件中写入处理代码来处理XML文件， 适合对XML的顺序访问；
	 * StAX：（StreamingAPIforXML）与其他方法的区别就在于应用程序能够把XML作为一个事件流来处理， 无论从性能还是可用性上都优于其他方法；
	 */

	public void runXml() {
		File f = new File("student.xml");
		try {// 首先创建一个documentbuilderfoctory的工厂
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();// 利用工厂来创建documengbuilder
			DocumentBuilder db = dbf.newDocumentBuilder();// 利用db的parse方法来解析xml文件
			Document doc = db.parse(f);// 将读出来的文件格式化
			doc.normalize();// 定义一个nodelist数组来存放xml文件中的节点（标签）
			NodeList students = doc.getElementsByTagName("student");// 从xml文件中读取数据
			for (int i = 0; i < students.getLength(); i++) {// 定义一个元素
				Element student = (Element) students.item(i);
				System.out.println(
						"stu_id:" + student.getElementsByTagName("stu_id").item(0).getFirstChild().getNodeValue());
				System.out
						.println("name:" + student.getElementsByTagName("name").item(0).getFirstChild().getNodeValue());
				System.out.println("age:" + student.getElementsByTagName("age").item(0).getFirstChild().getNodeValue());
			}
			// 向文件中写数据
			String stu_id = "001";
			String name = "zhangsan2";
			String age = "22";
			Text msg;
			// 创建元素
			Element studentNew = doc.createElement("student");// 创建子元素
			Element stuid = doc.createElement("stu_id");// 设置元素的值
			msg = doc.createTextNode(stu_id);// 将值添加给元素
			stuid.appendChild(msg);// 将元素添加到节点数组中
			studentNew.appendChild(stuid);
			Element name1 = doc.createElement("name");
			msg = doc.createTextNode(name);
			name1.appendChild(msg);
			studentNew.appendChild(name1);
			Element age1 = doc.createElement("age");
			msg = doc.createTextNode(age);
			age1.appendChild(msg);
			studentNew.appendChild(age1);// 将元素studentnew添加到document树中
			doc.getDocumentElement().appendChild(studentNew);// 进行写操作
			TransformerFactory tff = TransformerFactory.newInstance();
			Transformer tfor = tff.newTransformer();
			DOMSource dos = new DOMSource(doc);
			StreamResult result = new StreamResult(f);
			tfor.transform(dos, result);
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StAXTest ff = new StAXTest();
		ff.runXml();

	}

}
