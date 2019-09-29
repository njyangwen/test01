/**
 * 
 */
package com.yw.test01;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author yw 2019年9月28日 下午4:03:59
 *
 */
public class DomTest {
	// 用Element方式
	public static void element(NodeList list) {
		for (int i = 0; i < list.getLength(); i++) {
			Element element = (Element) list.item(i);
			NodeList childNodes = element.getChildNodes();
			for (int j = 0; j < childNodes.getLength(); j++) {
				if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
					// 获取节点
					System.out.print(childNodes.item(j).getNodeName() + ":");
					// 获取节点值
					System.out.println(childNodes.item(j).getFirstChild().getNodeValue());
				}
			}
		}
	}

	public static void node(NodeList list) {
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			NodeList childNodes = node.getChildNodes();
			for (int j = 0; j < childNodes.getLength(); j++) {
				if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
					System.out.print(childNodes.item(j).getNodeName() + ":");
					System.out.println(childNodes.item(j).getFirstChild().getNodeValue());
				}
			}
		}
	}

	public static void main(String[] args) {
        //1.创建DocumentBuilderFactory对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //2.创建DocumentBuilder对象
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document d = builder.parse("dom.xml");
            NodeList sList = d.getElementsByTagName("student");
            //element(sList);
            node(sList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
