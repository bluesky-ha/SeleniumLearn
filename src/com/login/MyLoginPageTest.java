package com.login;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyLoginPageTest {
	private WebDriver wd;
	@BeforeClass
	public void setUp(){
		wd = MyWebDriver.getInstance();
		String path = "";
		path = XmlParseDom4.parseXML().attributeValue("url");
		wd.get(path);
	}
	@Test
	public void testLogin(){
		String username = "";
		String pwd = "";
		username = XmlParseDom4.parseXML().element(arg0)
	}

}
