package com.login;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 * Ω‚ŒˆXML
 * @author Cherry.Zhu
 *
 */
public class XmlParseDom4 {
	/**
	 * @param xml_xpath
	 * @return
	 */
	public static Element parseXML(){
		Document document = null;
		File f = new File("LoginPageTestCase.xml");
		SAXReader saxReader = new SAXReader();
		try {
			document = saxReader.read(f);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Element root = document.getRootElement();
		return root;
		
	}
	public static Node parseNode(String xml_xpath){
		Node node = XmlParseDom4.parseXML().selectSingleNode(xml_xpath);
		return node;
		
	}

}
