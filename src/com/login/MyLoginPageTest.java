package com.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyLoginPageTest {
//	private WebDriver wd;

//	@BeforeClass
//	public void setUp() {
//		wd = MyWebDriver.getInstance();
//		String path = "";
//		// ����������URL
//		path = XmlParseDom4.parseRootElement().element("SETTINGS")
//				.attributeValue("url");
//		// �����������URL��ַ
//		wd.get(path);
//	}

//	@Test
//	public void testLogin() {
//		// ��ȡXML�ļ����û���������
//		String username = XmlParseDom4.parseNode("//STEP[@index='1']/VALUE")
//				.getText();
//		String pwd = XmlParseDom4.parseNode("//STEP[@index='2']/VALUE")
//				.getText();
//
//		// ��ȡ��������XML�ļ��е��û����������������򼰵�½��ť��xpath���ʽ
//		String username_xpath = XmlParseDom4.parseNode(
//				"//STEP[@index='1']/XPATH").getText();
//		String pwd_xpath = XmlParseDom4.parseNode("//STEP[@index='2']/XPATH")
//				.getText();
//		String btn_xpath = XmlParseDom4.parseNode("//STEP[@index='3']/XPATH")
//				.getText();
//
//		// ����������ҵ��û�������������û���
//		WebElement input_username = wd.findElement(By.xpath(username_xpath));
//		input_username.sendKeys(username);
//
//		// ����������ҵ������������������
//		WebElement input_pwd = wd.findElement(By.xpath(pwd_xpath));
//		input_pwd.sendKeys(pwd);
//
//		// ����������ҵ���½��ť�����
//		WebElement login_button = wd.findElement(By.xpath(btn_xpath));
//		login_button.click();
//
//	}

	@Test
	public void testMyFirstCase () {
		XmlParseDom4.runCase("LoginPageTestCase.xml");
		XmlParseDom4.runCase("LoginPageTestCase.xml");
		XmlParseDom4.runCase("LoginPageTestCase.xml");
	}
}
