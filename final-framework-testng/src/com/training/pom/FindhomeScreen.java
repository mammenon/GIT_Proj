package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
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
		
		@FindBy (xpath="//*[@name = '_property_type']")
		private WebElement dropdownlist;
		
		public void dropDownListSelection(String name)
		{
			Select select = new Select(dropdownlist);
			select.selectByValue(name);
			
		}
		
    }
