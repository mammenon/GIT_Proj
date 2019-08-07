package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
	private WebDriver driver;
	
	public DashBoardPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath="//*[@id='adminmenu']/li[3]")
	private WebElement mouseoverposts;
	
	
	public WebElement getMouseoverposts() 
	{
		return mouseoverposts;
	}
	
	@FindBy(xpath="//*[@id='adminmenu']/li[3]")
	private WebElement clickposts;
	
	
	public void clickPosts()
	{
		this.clickposts.click();
	}

	@FindBy(xpath = "//*[@id='adminmenu']/li[3]/ul/li[4]/a")
	private WebElement clickcategories;
	
	   public WebElement getClickcategories() 
	{
		return clickcategories;
	}

	@FindBy(xpath ="//*[@id='adminmenu']/li[3]/ul/li[2]/a")
	private WebElement clickallposts;
	
	
	public WebElement getClickallposts() 
	{
		return clickallposts;
	}

}
