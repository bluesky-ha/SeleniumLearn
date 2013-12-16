package com.login;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlParseDom4 {
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

}
