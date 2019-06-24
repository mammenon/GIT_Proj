package com.training.sanity.tests;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Basehomepage;
import com.training.pom.DonecQuis;
import com.training.pom.FindhomeScreen;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_009 
{
	private WebDriver driver;
	private String baseUrl;
	private Basehomepage basehomepage;
	private static Properties properties;
	private ScreenShot screenShot;
	private FindhomeScreen findhomescreen;
	
	
	

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
	findhomescreen = new FindhomeScreen(driver);
    }
	 

@Test
     public void ValidLoginTest() throws InterruptedException
     {
	       basehomepage.clicknewlaunchlink();
	       Thread.sleep(2000);
	       screenShot.captureScreenShot("First");
	       
	       findhomescreen.AddressTextbox("Electronic City");
	       driver.findElement(By.xpath("//*[@class = 'pac-container pac-logo hdpi']//div[1]//span/span")).click();
	       Thread.sleep(2000);
	       screenShot.captureScreenShot("Second");
	      
	       //WebElement ele=  driver.findElement(By.xpath("//*[@id = '_property_type' and @name = '_property_type']"));
	       //WebDriverWait wait = new WebDriverWait(driver,30);
	       //wait.until(ExpectedConditions.visibilityOf(ele));
	       
	      //Select select = new Select(driver.findElement(By.id("//*[@class='col-md-6 ']")));
	      //select.selectByIndex(2);
	       
	       //driver.findElement(By.xpath("//*[@class='col-md-6 ']")).click();
	       findhomescreen.PropertyType();
	       Thread.sleep(2000);
	       
	       //to select "plots" from list
	       driver.findElement(By.xpath("//li[@class='active-result'][@data-option-array-index='3']")).click();
	       Thread.sleep(2000);
	       screenShot.captureScreenShot("Third");
	       
	       //driver.findElement(By.xpath("//span[contains(text(),'Any Regions')]")).click();
	       findhomescreen.AnyRegions();
	       Thread.sleep(2000);
	       
	       //to select "invest in overseas"
	       driver.findElement(By.xpath("//*[@class='col-md-6 ']//*[@data-option-array-index='5']")).click();
	       Thread.sleep(2000);
	       screenShot.captureScreenShot("Fourth");
	       
	       findhomescreen.Search1();
	       Thread.sleep(2000);
	       screenShot.captureScreenShot("Fifth");
	       
	       findhomescreen.NothingFound();
	       screenShot.captureScreenShot("Sixth");
	       }
	       

@AfterMethod
       public void tearDown() throws Exception 
       {
         Thread.sleep(1000);
         driver.quit();
       }
     

}
