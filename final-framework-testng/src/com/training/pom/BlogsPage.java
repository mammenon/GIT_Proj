package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlogsPage {
private WebDriver driver;
	
	public BlogsPage (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath="//*[@class='post-content']//a[contains(text(),'New16 Launches16')]")
	private WebElement clickreadmore;
	
	public void clickOnReadMore()
	{
		this.clickreadmore.click();
	}
	
	@FindBy (xpath="//*[@id='comment']")
	private WebElement enetercommentexttbox;
	
	public void sendCommenTextBox(String entercommentexttbox)
	{
		this.enetercommentexttbox.clear();
		this.enetercommentexttbox.sendKeys(entercommentexttbox);
	}
	
	@FindBy (xpath="//*[@id='submit']")
	private WebElement enetersubmittbutton;
	
	public void clickSubmiteButton()
	{
		this.enetersubmittbutton.click();
	}

}
