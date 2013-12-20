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
//		// 解析出测试URL
//		path = XmlParseDom4.parseRootElement().element("SETTINGS")
//				.attributeValue("url");
//		// 在浏览器输入URL地址
//		wd.get(path);
//	}

//	@Test
//	public void testLogin() {
//		// 获取XML文件中用户名和密码
//		String username = XmlParseDom4.parseNode("//STEP[@index='1']/VALUE")
//				.getText();
//		String pwd = XmlParseDom4.parseNode("//STEP[@index='2']/VALUE")
//				.getText();
//
//		// 获取出定义在XML文件中的用户名输入框，密码输入框及登陆按钮的xpath表达式
//		String username_xpath = XmlParseDom4.parseNode(
//				"//STEP[@index='1']/XPATH").getText();
//		String pwd_xpath = XmlParseDom4.parseNode("//STEP[@index='2']/XPATH")
//				.getText();
//		String btn_xpath = XmlParseDom4.parseNode("//STEP[@index='3']/XPATH")
//				.getText();
//
//		// 在浏览器中找到用户名输入框并输入用户名
//		WebElement input_username = wd.findElement(By.xpath(username_xpath));
//		input_username.sendKeys(username);
//
//		// 在浏览器中找到密码输入框并输入密码
//		WebElement input_pwd = wd.findElement(By.xpath(pwd_xpath));
//		input_pwd.sendKeys(pwd);
//
//		// 在浏览器中找到登陆按钮并点击
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
