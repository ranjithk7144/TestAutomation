package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
 private WebDriver driver;
 
 //1. Locators:
 private By username=By.xpath("//*[@name='username']");
 private By password=By.xpath("//*[@name='password']");
 private By loginButton=By.xpath("//*[@type='submit']");
 
 //2.Constructor of the page class
 public LoginPage(WebDriver driver)
 {
this.driver=driver;	 
 }
		 
 //3.Page actions or methods
 public String getLoginPageTitle()
 {
	return driver.getTitle();
 }
 
 public void enterUsername(String usrname)
 {
	driver.findElement(username).sendKeys(usrname);
 }
 
 public void enterPassword(String pwd)
 {
	driver.findElement(password).sendKeys(pwd);
 }
 
 public void clickOnLogin()
 {
	driver.findElement(loginButton).click();
 }
 
 public String getHomePageURL()
 {
	return driver.getCurrentUrl();
 }
}
