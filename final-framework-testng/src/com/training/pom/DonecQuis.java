package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DonecQuis {
	
	
	private WebDriver driver;
	
	public DonecQuis(WebDriver driver) 
	{
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@name='your-name']")
	private WebElement yourname;
	
	@FindBy(xpath="//*[@name='your-email']")
	private WebElement youremail;
	
	@FindBy (xpath="//*[@name='your-subject']")
	private WebElement yoursubject;
	
	@FindBy (xpath="//*[@name='your-message']")
	private WebElement yourmessage;
	
	@FindBy(xpath="//*[@value='Send']")
	private WebElement sendbutton;
	
	@FindBy (xpath="//*[@id='amount']")
	private WebElement saleprice;
	
	@FindBy (xpath="//*[@id='downpayment']")
	private WebElement downpayment;
	
	@FindBy (xpath="//*[@id='years']")
	private WebElement loanterm;
	
	@FindBy (xpath="//*[@id='interest']")
	private WebElement intrestrate;
	
	@FindBy (xpath="//*[@class='button calc-button']")
	private WebElement calculatebutton;
	
	@FindBy (xpath="//*[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")
	private WebElement actualMessage;
	
	public void scrollMethod()
	{
	JavascriptExecutor je = (JavascriptExecutor) driver;
//	WebElement element = driver.findElement(By.xpath("//*[@id='interest']"));
	je.executeScript("arguments[0].scrollIntoView(true);",intrestrate); 
	}
	public String getActualMessage()
	{
		return this.actualMessage.getText();
	}
	
	@FindBy (xpath="//*[@class='notification success']")
	private WebElement actualmonthlypayment;
	
	public String getMonthlyPayment()
	{
		return this.actualmonthlypayment.getText();
	}
	
	
	
	public void sendUserName(String yourname) 
	{
		this.yourname.clear();
		this.yourname.sendKeys(yourname);
	}
	
	public void sendUserEmail(String youremail) 
	{
		this.youremail.clear();
		this.youremail.sendKeys(youremail);
	}
	
	public void sendUserSubject(String yoursubject) 
	{
		this.yoursubject.clear();
		this.yoursubject.sendKeys(yoursubject);
	}
	
	public void sendUserMessage(String yourmessage) 
	{
		this.yourmessage.clear();
		this.yourmessage.sendKeys(yourmessage);
	}
	
	public void SendButton()
	{
	    this.sendbutton.click();
		
	}
	
	public void SalePrice(String saleprice)
	{
		this.saleprice.clear();
		this.saleprice.sendKeys(saleprice);
		
	}
	
	public void DownPayment(String downpayment)
	
	{
	    this.downpayment.clear();
		this.downpayment.sendKeys(downpayment);
	}
	
public void LoanTerm(String loanterm)
	
	{
	    this.loanterm.clear();
		this.loanterm.sendKeys(loanterm);
	}

public void IntrestRate(String intrestrate)

   {
    this.intrestrate.clear();
	this.intrestrate.sendKeys(intrestrate);
   }

public void CalculateButton()
 
   {
    this.calculatebutton.click();
	
   }

	
}
	
	
	


