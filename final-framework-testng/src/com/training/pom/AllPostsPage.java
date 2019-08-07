package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllPostsPage {
	private WebDriver driver;
	
	public AllPostsPage (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath="//*[@class='page-title-action']")
	private WebElement clickaddnew;
	
	public void clickAddNew()
	{
		this.clickaddnew.click();
	}
	
	@FindBy (xpath="//*[@id='title']")
	private WebElement enetertitle;
	
	public void sendTitle(String entertitle)
	{
		this.enetertitle.clear();
		this.enetertitle.sendKeys(entertitle);
	}
	
	@FindBy (xpath="//*[@id='content']")
	private WebElement enetertextbox;
	
	public void sendTextbox(String entertitle)
	{
		this.enetertextbox.clear();
		this.enetertextbox.sendKeys(entertitle);
	}
	
	@FindBy (xpath="//input[@id='publish'][@value='Publish']")
	private WebElement clickpublish;
	
	public void clickPublish()
	{
		this.clickpublish.click();
	}
	
	@FindBy (xpath="//*[@id='in-category-465']")
	private WebElement clickcheckbox;
	
	public WebElement getClickcheckbox() 
	{
		return clickcheckbox;
	}

	
	
	@FindBy (xpath="//*[contains(text(),'View Post')]")
	private WebElement viewpost;
	
	public void viewPostClick()
	{
		this.viewpost.click();
	}
	
	@FindBy (xpath="//*[@id='menu-item-617']")
	private WebElement clickblog;
	
	public void clickOnBlog()
	{
		this.clickblog.click();
	}
	
}
