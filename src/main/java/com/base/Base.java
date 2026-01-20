package com.base;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.utilities.ConfigReader;

public class Base {
	protected static SoftAssert softAssert;
	static Playwright playwright;
	static Browser browser;
	static BrowserContext bc;
	public static Page page;
	static Properties prop;

	@BeforeSuite
	public static void init() {
		softAssert = new SoftAssert();
		prop = ConfigReader.configReader();
		String browserName = prop.getProperty("browser");

		playwright = Playwright.create();

		switch (browserName) {
		case "chrome":
			browser = playwright.chromium().launch(new LaunchOptions().setChannel(browserName).setHeadless(false));
			break;
		case "firefox":
			browser = playwright.firefox().launch(new LaunchOptions().setHeadless(false));
			break;
		case "safari":
			browser = playwright.webkit().launch(new LaunchOptions().setHeadless(false));
			break;
		default:
			System.out.println("Wrong Browser Name...!");
			break;
		}
	}

	@BeforeMethod
	public Page browserInvoke() {
		String url = prop.getProperty("url");
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) dimension.getHeight() - 140;
		int width = (int) dimension.getWidth() - 60;

		bc = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
		page = bc.newPage();
		page.navigate(url);
		return page;
	}

	@AfterMethod
	public void tearDown() {
		softAssert.assertAll();
		if (page != null) {
			page.close();
		}
		if (bc != null) {
			bc.close();
		}
	}

	@AfterSuite
	public void close() {
		if (browser != null) {
			browser.close();
		}
		if (playwright != null) {
			playwright.close();
		}
	}
}