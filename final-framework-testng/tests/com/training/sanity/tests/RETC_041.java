package com.training.sanity.tests;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPage;
import com.training.pom.AllPostsPage;
import com.training.pom.BlogsPage;
import com.training.pom.CategoriesPage;
import com.training.pom.DashBoardPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_041 {
	private WebDriver driver;
	private AdminLoginPage adminloginpage;
	private ScreenShot screenShot;
	private static Properties properties;
	private String baseUrl;
	private DashBoardPage dashboardpage;
	private CategoriesPage categoriespage;
	private AllPostsPage allpostspage;
	private BlogsPage blogspage;
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
	blogspage = new BlogsPage(driver);
	
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
	
	
	//mouse hover on Posts and click on categories link
	WebDriverWait wait = new WebDriverWait(driver, 30);
	Actions action = new Actions(driver);
	action.moveToElement(dashboardpage.getMouseoverposts()).build().perform();
	wait.until(ExpectedConditions.elementToBeClickable(dashboardpage.getClickcategories())).click();
	screenShot.captureScreenShot("");
	//dashboardpage.clickCategories();
	
	
	
	//Enter Valid Credentials in Name text box
	categoriespage.enterName("Launches17");
	categoriespage.enterSlug("launch17");
	categoriespage.enterDesc("New Launches15 of villas, apartments, flats");
	Thread.sleep(2000);
	screenShot.captureScreenShot();
	
	categoriespage.addNewCategory();
	Thread.sleep(5000);
	driver.navigate().refresh();
	Thread.sleep(5000);
	screenShot.captureScreenShot();
	
	action.moveToElement(dashboardpage.getMouseoverposts()).build().perform();
	wait.until(ExpectedConditions.elementToBeClickable(dashboardpage.getClickallposts())).click();
	screenShot.captureScreenShot();
	
	allpostspage.clickAddNew();
	Thread.sleep(3000);
	allpostspage.sendTitle("New Launch17");
	allpostspage.sendTextbox("New Launch17 in Home");
	screenShot.captureScreenShot();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(allpostspage.getClickcheckbox())).click();
	allpostspage.clickPublish();
	screenShot.captureScreenShot();
	allpostspage.viewPostClick();
	Thread.sleep(3000);
	screenShot.captureScreenShot();
	
	blogspage.clickOnReadMore();
	Thread.sleep(3000);
	screenShot.captureScreenShot();
	blogspage.sendCommenTextBox("good");
	blogspage.clickSubmiteButton();
	Thread.sleep(3000);
	screenShot.captureScreenShot();
	
	
	
	
	
}

@AfterMethod
public void tearDown() throws Exception 
{
 Thread.sleep(1000);
 driver.quit();
}

}
