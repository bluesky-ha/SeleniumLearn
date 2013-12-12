package com.login;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * 解析XML
 * 
 * @author Xiangdan
 *
 */
public class XmlParse {

	/**
	 * 根据节点名获取值
	 * 
	 * @param tagName 节点名称
	 * @return
	 */
	public static String parse(String tagName) {
		String result = "";
		File f = new File("configuration1.xml");
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(f);
			result = doc.getElementsByTagName(tagName).item(0).getFirstChild()
					.getNodeValue();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
}
