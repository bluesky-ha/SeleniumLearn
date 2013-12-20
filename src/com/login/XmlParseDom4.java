package com.login;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * ����XML
 * 
 * @author Cherry.Zhu
 * 
 */
public class XmlParseDom4 {

	// public static Element root;

	// public static Element parseRootElement() {
	// Document document = null;
	// File f = new File("LoginPageTestCase.xml");
	// SAXReader saxReader = new SAXReader();
	// try {
	// document = saxReader.read(f);
	// } catch (DocumentException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// root = document.getRootElement();
	// return root;
	//
	// }
	//
	// public static Node parseNode(String xml_xpath) {
	// Node node = parseRootElement().selectSingleNode(xml_xpath);
	// return node;
	//
	// }

	// public static void parseXml() {
	// List<Element> stepNodes = root.element("STEPS").elements();
	// Element elm = null;
	// Iterator<Element> iterator = null;
	// while (iterator != null && iterator.hasNext()) {
	// elm = iterator.next();
	// String type = elm.attributeValue("type");
	// if (type.equals("Type.CLICK")) {
	// // ����CLICK��������
	// try {
	// Thread.sleep(3000);
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// }
	// }

	/**
	 * ���ڲ���ĳһ����������
	 * 
	 * @param casePath
	 *            �����������ļ�·��
	 */
	public static void runCase(String casePath) {
		System.out.println("�������� XML �ļ�λ�� ::" + casePath);
		File file = new File(casePath);
		/** ����yԇ���������ڣ����� */
		if (!file.exists()) {
			return;
		}

		Document document = null;
		try {
			document = new SAXReader().read(file);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		if (document == null) {
			return;
		}

		Element suiteElm = document.getRootElement();
		WebDriver wd = MyWebDriver.getInstance();
		/** ��ȡ������Ϣ */
		Element settings = suiteElm.element("SETTINGS");
		if (settings != null) {
			// String browser = settings.attributeValue("browser");
			// String seleniumServer =
			// settings.attributeValue("seleniumServer");
			// String seleniumPort =
			// settings.attributeValue("seleniumPort");
			String url = settings.attributeValue("url");
			wd.get(url);
		}

		/** �@ȡ�yԇ��Ϣ */
		Element testElm = suiteElm.element("TEST");
		System.out.println("������������Ϊ ::" + testElm.attributeValue("name"));
		int timeout = 0;
		if (testElm.attributeValue("timeout") != null) {
			// ��������� timeout ���� , ������Ĭ�����ã�
			timeout = new Integer(testElm.attributeValue("timeout")).intValue();
			System.out.println("��ʱ���ã�timeout="
					+ testElm.attributeValue("timeout") + "��");
		}

		/** ѭ���@ȡ�yԇ���E */
		List<Element> stepNodes = testElm.element("STEPS").elements();
		Iterator<Element> iterator = stepNodes.iterator();
		System.out.println("�ܹ����Բ��裺" + stepNodes.size());
		Element elm = null;
		while (iterator != null && iterator.hasNext()) {// while ѭ����ʼ
			elm = iterator.next();
			System.out.println("------------------------------>");
			System.out.println("step index=" + elm.attributeValue("index"));
			System.out.println("step name=" + elm.attributeValue("name"));
			System.out.println("step type=" + elm.attributeValue("type"));
			String type = elm.attributeValue("type");
			if (type == null) {
				System.out.println("���붨�� type ���ԣ����� XML ����������");
				break;
			}
			if (type.equals("Type.CLICK")) {
				// ���� Click ��������
				try {
					Thread.sleep(timeout * 1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					String xpath = elm.element("XPATH").getText();
					WebElement element = wd.findElement(By.xpath(xpath));
					element.click();
				} catch (Exception e) {
					System.out.println(e.getMessage()
							+ "\n ����ִ��ʧ�ܣ�����ִ�б���ֹ , ����Ԫ��Ϊ :\n" + elm.asXML());
					break;
				}
			} else if (type.equals("Type.INPUT")) {
				// ���� Input �������ִ���������
				try {
					Thread.sleep(timeout * 1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					String xpath = elm.element("XPATH").getText();
					WebElement element = wd.findElement(By
							.xpath(xpath));
					String value = elm.element("VALUE").getText();
					element.sendKeys(value);
				} catch (Exception e) {
					System.out.println(e.getMessage()
							+ "\n ����ִ��ʧ�ܣ�����ִ�б���ֹ , ����Ԫ��Ϊ :\n" + elm.asXML());
					break;
				}
			}
		}// ѭ���������Բ��裻while ѭ������

	}

}
