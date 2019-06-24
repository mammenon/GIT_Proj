package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



	 public class FindhomeScreen 
   {
	 private WebDriver driver;
		
		public FindhomeScreen(WebDriver driver)
		 {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		  }
		
		
		@FindBy(xpath="//*[@id='keyword_search']")
		private WebElement addresstextbox;
		
		public void AddressTextbox(String addresstextbox)
		{
			this.addresstextbox.clear();
			this.addresstextbox.sendKeys(addresstextbox);
		}
		
		@FindBy (xpath = "//*[@class='col-md-6 ']")
		private WebElement propertytype;
		
		public void PropertyType()
		{
			this.propertytype.click();
		}
		
		@FindBy (xpath = "//span[contains(text(),'Any Regions')]")
		private WebElement anyregion;
		
		public void AnyRegions()
		{
			this.anyregion.click();
		}
		
		@FindBy (xpath="//button[@class='button fullwidth']")
		private WebElement search1;
		
		public void Search1()
		{
			this.search1.click();
		}	
		
				
		public void NothingFound()
		{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)"); 
		}
		
    }
