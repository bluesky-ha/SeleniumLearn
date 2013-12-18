package com.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * ����firefox driver
 * @author Cherry.Zhu
 *
 */

public class MyWebDriver {

	private static WebDriver mWd;

	public static WebDriver getInstance() {
		if (mWd == null) {
			mWd = new FirefoxDriver();
		}
		return mWd;
	}
}
