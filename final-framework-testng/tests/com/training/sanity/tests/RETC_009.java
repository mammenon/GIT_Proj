package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.training.generics.ScreenShot;
import com.training.pom.Basehomepage;
import com.training.pom.FindhomeScreen;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_009 
{
	private WebDriver driver;
	private static Properties properties;
	private Basehomepage basehomepage;
	private String baseUrl;
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
    public void setUp()
    {
	 driver = DriverFactory.getDriver(DriverNames.CHROME);
	 basehomepage = new Basehomepage(driver);
	 baseUrl = properties.getProperty("baseUrl");
	 screenShot = new ScreenShot(driver);
	 driver.get(baseUrl);
	 findhomescreen = new FindhomeScreen(driver);
	 }


}
