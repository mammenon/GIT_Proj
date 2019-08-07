package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.bean.EnquiryDetailsBean;
import com.training.dao.ELearningDAO;
import com.training.generics.ScreenShot;
import com.training.pom.Basehomepage;
import com.training.pom.DonecQuis;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_069 
{
	private WebDriver driver;
	private String baseUrl;
	private Basehomepage basehomepage;
	private static Properties properties;
	private ScreenShot screenShot;
	private DonecQuis donecQuis;
	private EnquiryDetailsBean enquirydetailsbean;
	private ELearningDAO elearningdao;
	private ApachePOIExcelRead apachePOIExcelRead;
	

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
		enquirydetailsbean = new EnquiryDetailsBean();
		// open the browser 
		driver.get(baseUrl);
		donecQuis = new DonecQuis(driver);
		elearningdao = new ELearningDAO();
		apachePOIExcelRead = new ApachePOIExcelRead();
		
		
	}
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void validLoginTest() throws InterruptedException 
	{
		//driver.get(baseUrl);
		
		String[][] list=apachePOIExcelRead.getExcelContent("C:\\Users\\MAYAMENON\\Downloads\\TestData.xlsx");	
		System.out.println(list.length);
		
		
		
		for(int i=29; i<=29; i++)
		{
			Actions action = new Actions(driver);
		 	action.moveToElement(basehomepage.newlaunchlink).build().perform();
			screenShot.captureScreenShot();
			basehomepage.clickdonecquislink();
			donecQuis.SalePrice(list[i][1]);
			screenShot.captureScreenShot();
			
			donecQuis.DownPayment(list[i][2]);
			screenShot.captureScreenShot();
			
			donecQuis.LoanTerm(list[i][3]);
			screenShot.captureScreenShot();
			
			donecQuis.IntrestRate(list[i][4]);
			screenShot.captureScreenShot();
			
			donecQuis.CalculateButton();
			screenShot.captureScreenShot();		
			donecQuis.scrollMethod();		
			//System.out.println(list[i][1]);
		}

	}
}
