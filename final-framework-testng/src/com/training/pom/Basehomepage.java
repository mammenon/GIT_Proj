package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Basehomepage {
private WebDriver driver; 
	
	public Basehomepage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[contains(text(),'New Launch ')]")
	public WebElement newlaunchlink;
	
	@FindBy(xpath="//*[@title='Donec quis']//img")
	private WebElement donecquislink;
	
	
	public void clicknewlaunchlink()
	{
		newlaunchlink.click();
	}
	
	public void clickdonecquislink()
	{
		donecquislink.click();
		
	}
	

}
