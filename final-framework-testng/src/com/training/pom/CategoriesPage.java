package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoriesPage {
	private WebDriver driver;
	
	public CategoriesPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy (xpath = "//*[@id='tag-name']")
	private WebElement entername;
	
	public void enterName(String enetername1)
	{
		this.entername.clear();
		this.entername.sendKeys(enetername1);
		
	}
	
	@FindBy(xpath="//*[@id='tag-slug']")
	private WebElement enterslug;
	
	public void enterSlug(String eneterslug)
	{
		this.enterslug.clear();
		this.enterslug.sendKeys(eneterslug);
		
	}
	
	@FindBy(xpath="//*[@id='tag-description']")
	private WebElement enterdesc;
	
	public void enterDesc(String eneterdesc)
	{
		this.enterdesc.clear();
		this.enterdesc.sendKeys(eneterdesc);
		
	}
	
	@FindBy(xpath="//*[@id='submit']")
	private WebElement addnewcategory;
	
	public void addNewCategory()
	{
		this.addnewcategory.click();
	}
}
