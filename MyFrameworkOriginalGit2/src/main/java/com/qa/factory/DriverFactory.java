package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver= new ThreadLocal<>();

	//This method is used to initialize thread local driver based on the given browser

	public WebDriver init_driver(String browser)
	{
		System.out.println("Browser value is :" +browser);

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());	
		}
		else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());	
		}
		else {
			System.out.println("Please pass the correct browser" +browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}
	//Used to get the driver with thread local

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}
