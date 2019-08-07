package com.training.pom;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	private WebDriver driver;
	
	public AdminLoginPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//*[@id='user_login']")
	private WebElement enterusername;
	
	public void enterUsername(String enterusername)
	{
		this.enterusername.clear();
		this.enterusername.sendKeys(enterusername);
	}
	
	@FindBy (xpath = "//*[@id='user_pass']")
	private WebElement enterpassword;
	
	public void enterPassword(String enterpassword)
	{
		this.enterpassword.clear();
		this.enterpassword.sendKeys(enterpassword);
	}
	
	@FindBy (xpath = "//*[@class='button border margin-top-10']")
	private WebElement eneterlogin;
	
	public void enterLogin()
	{
		this.eneterlogin.click();
	}
	  

}
