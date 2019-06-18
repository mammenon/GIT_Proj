package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Basehomepage;
import com.training.pom.DonecQuis;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_008 {
	private WebDriver driver;
	private String baseUrl;
	private Basehomepage basehomepage;
	private static Properties properties;
	private ScreenShot screenShot;
	private DonecQuis donecQuis;
	
	@BeforeClass
	   public static void setUpBeforeClass() throws IOException 
	{
	   properties = new Properties();
	   FileInputStream inStream = new FileInputStream("./resources/others.properties");
	   properties.load(inStream);
	   
	}
	
	
	@BeforeMethod
	    public void setUp() throws Exception 
	{
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		basehomepage = new Basehomepage(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		donecQuis = new DonecQuis(driver);
	}
	
		
	@Test
	public void validLoginTest() throws InterruptedException 
	{
        Actions action = new Actions(driver);
		action.moveToElement(basehomepage.newlaunchlink).build().perform();
		screenShot.captureScreenShot("First");
		basehomepage.clickdonecquislink();
		screenShot.captureScreenShot("Second");
		
		donecQuis.SalePrice("400000");
		screenShot.captureScreenShot("Third");
		
		donecQuis.DownPayment("20000");
		screenShot.captureScreenShot("Fourth");
		
		donecQuis.LoanTerm("20");
		screenShot.captureScreenShot("Fifth");
		
		donecQuis.IntrestRate("7.25");
		screenShot.captureScreenShot("Sixth");
		
		donecQuis.CalculateButton();
		screenShot.captureScreenShot("Seventh");		
		donecQuis.scrollMethod();		
		//JavascriptExecutor je = (JavascriptExecutor) driver;
		//WebElement element = driver.findElement(By.xpath("//*[@id='interest']"));
		//je.executeScript("arguments[0].scrollIntoView(true);",element); 
		
		String actual = donecQuis.getMonthlyPayment();
		System.out.println("Actual Message : "+actual);
		Thread.sleep(2000);
		screenShot.captureScreenShot("Eighth");
		
		String monthlyPayment = properties.getProperty("monthlyPayment");
		System.out.println("Expected Message : "+monthlyPayment);
		Assert.assertEquals(actual, monthlyPayment);
		System.out.println("Test case passed");
		
	}
	
	@AfterMethod
    public void tearDown() throws Exception 
   {
	 Thread.sleep(1000);
	 driver.quit();
   }
	
	
	
}

		
	
	


