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
 * 解析XML
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
	// // 处理CLICK单击操作
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
	 * 用于测试某一条测试用例
	 * 
	 * @param casePath
	 *            ：测试用例文件路径
	 */
	public static void runCase(String casePath) {
		System.out.println("测试用例 XML 文件位置 ::" + casePath);
		File file = new File(casePath);
		/** 如果測試用例不存在，返回 */
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
		/** 获取设置信息 */
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

		/** 獲取測試信息 */
		Element testElm = suiteElm.element("TEST");
		System.out.println("测试用例名称为 ::" + testElm.attributeValue("name"));
		int timeout = 0;
		if (testElm.attributeValue("timeout") != null) {
			// 用例级别的 timeout 设置 , 覆盖了默认设置！
			timeout = new Integer(testElm.attributeValue("timeout")).intValue();
			System.out.println("延时设置，timeout="
					+ testElm.attributeValue("timeout") + "秒");
		}

		/** 循环獲取測試步驟 */
		List<Element> stepNodes = testElm.element("STEPS").elements();
		Iterator<Element> iterator = stepNodes.iterator();
		System.out.println("总共测试步骤：" + stepNodes.size());
		Element elm = null;
		while (iterator != null && iterator.hasNext()) {// while 循环开始
			elm = iterator.next();
			System.out.println("------------------------------>");
			System.out.println("step index=" + elm.attributeValue("index"));
			System.out.println("step name=" + elm.attributeValue("name"));
			System.out.println("step type=" + elm.attributeValue("type"));
			String type = elm.attributeValue("type");
			if (type == null) {
				System.out.println("必须定义 type 属性，请检查 XML 测试用例。");
				break;
			}
			if (type.equals("Type.CLICK")) {
				// 处理 Click 单击操作
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
							+ "\n 步骤执行失败，测试执行被中止 , 测试元素为 :\n" + elm.asXML());
					break;
				}
			} else if (type.equals("Type.INPUT")) {
				// 处理 Input 在输入框执行输入操作
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
							+ "\n 步骤执行失败，测试执行被中止 , 测试元素为 :\n" + elm.asXML());
					break;
				}
			}
		}// 循环解析测试步骤；while 循环结束

	}

}
