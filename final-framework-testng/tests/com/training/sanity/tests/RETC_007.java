package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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

public class RETC_007 {
	
	private WebDriver driver;
	private String baseUrl;
	private Basehomepage basehomepage;
	private static Properties properties;
	private ScreenShot screenShot;
	private DonecQuis donecQuis;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		basehomepage = new Basehomepage(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		donecQuis = new DonecQuis(driver);
		
	}
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException 
	{
        Actions action = new Actions(driver);
		action.moveToElement(basehomepage.newlaunchlink).build().perform();
		screenShot.captureScreenShot("First");
		basehomepage.clickdonecquislink();
		screenShot.captureScreenShot("Second");
		
		donecQuis.sendUserName("manzoor");
		screenShot.captureScreenShot("Third");
		donecQuis.sendUserEmail("manzoor@gmail.com");
		screenShot.captureScreenShot("Fourth");
		donecQuis.sendUserSubject("apartments");
		screenShot.captureScreenShot("Fifth");
		donecQuis.sendUserMessage("looking for an apartments");
		screenShot.captureScreenShot("Sixth");
		donecQuis.SendButton();
		screenShot.captureScreenShot("Seventh");
		
		String actual = donecQuis.getActualMessage();
		System.out.println("Actual Message : "+actual);
		Thread.sleep(5000);
		screenShot.captureScreenShot("Eighth");
		
		String expectedMessage = properties.getProperty("expectedMessage");
		System.out.println("Expected Message : "+expectedMessage);
		Assert.assertEquals(actual, expectedMessage);
		System.out.println("Test case passed");
		
				
	}
	
	
	
}
