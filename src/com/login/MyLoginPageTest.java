package com.login;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyLoginPageTest {
	private WebDriver wd;
	@BeforeClass
	public void setUp(){
		wd = MyWebDriver.getInstance();
		String path =  "";
		path = XmlParseDom4.parseXML().element("SETTINGS").attributeValue("url");
		wd.get(path);
	}
	@Test
	public void testLogin(){
//		String username = "";
//		String pwd = "";
//		username = XmlParseDom4.parseXML().valueOf("//SETP[@index='1']/VALUE");
		String username  = XmlParseDom4.parseXML().selectSingleNode("//SETP[@index='1']/VALUE").toString();
		
//		String username_xpath = XmlParseDom4.parseXML().valueOf("//STEP[@index='1']/XPATH");
//		String username_xpath = XmlParseDom4.parseXML().selectSingleNode("//STEP[@index='1']/XPATH").toString();
		
//		WebElement input_username = wd.findElement(By.xpath(username_xpath));
		WebElement input_username = wd.findElement(By.id("user_name"));
		input_username.sendKeys(username);
//		pwd = XmlParseDom4.parseXML().valueOf("//STEP[@index='2']/VALUE");
//		String pwd_xpath = XmlParseDom4.parseXML().valueOf("//STEP[index='2']/XPATH");
//		String button = XmlParseDom4.parseXML().valueOf("//STEP[@index='3'/XPATH");
//		WebElement input_pwd = wd.findElement(By.xpath(pwd_xpath));
//		WebElement login_button = wd.findElement(By.xpath(button));
//		input_pwd.sendKeys(pwd);
//		login_button.click();
		
	}

}
