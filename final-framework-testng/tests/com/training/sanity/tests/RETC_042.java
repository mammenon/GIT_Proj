package com.training.sanity.tests;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPage;
import com.training.pom.AllPostsPage;
import com.training.pom.CategoriesPage;
import com.training.pom.DashBoardPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_042 
{
	private WebDriver driver;
	private AdminLoginPage adminloginpage;
	private ScreenShot screenShot;
	private static Properties properties;
	private String baseUrl;
	private DashBoardPage dashboardpage;
	private CategoriesPage categoriespage;
	private AllPostsPage allpostspage;
  
	@BeforeClass
	   public static void setUpBeforeClass() throws Exception 
	{
	   properties = new Properties();
	   FileInputStream inStream = new FileInputStream("./resources/others.properties");
	   properties.load(inStream);
	   
	}
	
	
@BeforeMethod
    public void setUp() throws Exception 
{
	driver = DriverFactory.getDriver(DriverNames.CHROME);
	adminloginpage = new AdminLoginPage(driver);
	baseUrl = properties.getProperty("baseURL");
	screenShot = new ScreenShot(driver); 
	dashboardpage = new DashBoardPage(driver);
	categoriespage = new CategoriesPage(driver);
	allpostspage = new AllPostsPage(driver);
	
	// open the browser 
	driver.get(baseUrl);
}

@Test
    public void validLoginTest() throws InterruptedException

{ 
	//login as admin user
	adminloginpage.enterUsername("admin");
	adminloginpage.enterPassword("adminuser@12345");
	adminloginpage.enterLogin();
	Thread.sleep(2000);
	screenShot.captureScreenShot();
	
	dashboardpage.clickPosts();
	Thread.sleep(2000);
	screenShot.captureScreenShot();
	
	allpostspage.clickAddNew();
	allpostspage.sendTitle("Guest");
	allpostspage.sendTextbox("New guest at Home");
	screenShot.captureScreenShot();
	Thread.sleep(2000);
	
	allpostspage.clickPublish();
	
	allpostspage.viewPostClick();

}
}
