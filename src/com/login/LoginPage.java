package com.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
	private WebDriver wd ;
	
	public  void login() throws InterruptedException {
		wd = MyWebDriver.getInstance();
		String PathUrl = "http://newcs.adchina.com/";
		String UserName = "test_cs";
		String PWD = "testpassword";
		wd.get(PathUrl);

		WebElement InputUserName = wd.findElement(By.id("user_name"));
		InputUserName.sendKeys(UserName);

		WebElement InputPwd = wd.findElement(By.id("password"));
		InputPwd.sendKeys(PWD);
		WebElement LoginBtn = wd.findElement(By.xpath("//input[@type='submit']"));
		LoginBtn.click();
		WebDriverWait wait = new WebDriverWait(wd, 120);
		wait.until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver wd) {
				return wd.findElement(By.xpath("//table/tbody"));
		
			}
		});
		Thread.sleep(6000);
	}
}


