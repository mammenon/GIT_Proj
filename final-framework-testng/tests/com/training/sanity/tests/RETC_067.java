package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.bean.EnquiryDetailsBean;
import com.training.dao.ELearningDAO;
import com.training.generics.ScreenShot;
import com.training.pom.Basehomepage;
import com.training.pom.DonecQuis;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_067 {
	private WebDriver driver;
	private String baseUrl;
	private Basehomepage basehomepage;
	private static Properties properties;
	private ScreenShot screenShot;
	private DonecQuis donecQuis;
	private EnquiryDetailsBean enquirydetailsbean;
	private ELearningDAO elearningdao;
	

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
		 
		String name = "manzoor";
		String email = "manzoor@gmail.com";
		String subject = "apartments";
		String message = "looking for an apartments";
		
		donecQuis.sendUserName(name);
		screenShot.captureScreenShot("Third");
		donecQuis.sendUserEmail(email);
		screenShot.captureScreenShot("Fourth");
		donecQuis.sendUserSubject(subject);
		screenShot.captureScreenShot("Fifth");
		donecQuis.sendUserMessage(message);
		screenShot.captureScreenShot("Sixth");
		donecQuis.SendButton();
		screenShot.captureScreenShot("Seventh");
		

				
		System.out.println(name +" " + email+" " + subject +" "+ message);
		String nameDB = null;
		String emailDB = null;
		String subjectDB = null;
		String messageDB = null;
		
		Iterator<EnquiryDetailsBean> details = elearningdao.getEnqiryDetails().iterator();
		
		while(details.hasNext())
		{
			enquirydetailsbean = details.next();
			nameDB = enquirydetailsbean.getName();
			emailDB = enquirydetailsbean.getEmail();
			subjectDB = enquirydetailsbean.getSubject();
			messageDB = enquirydetailsbean.getMessage();
			
			
		}
	//	System.out.println(name +" " + email+" " + subject +" "+ message);
		if(name.equalsIgnoreCase(nameDB) && email.equalsIgnoreCase(emailDB) && subject.equalsIgnoreCase(subjectDB) && message.equalsIgnoreCase(messageDB))
		{
			System.out.println("Test Case Passed");
		}
		else
		{
			System.out.println("Test Case Failed");
			Assert.fail();
		}
		
	}
}
