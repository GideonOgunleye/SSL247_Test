package PageFactory.Admin;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilities.DriverLoad;

import org.testng.Assert;


public class Admin_CertificateDetailsPage extends DriverLoad {
	ExtentReports report;
	ExtentTest test;
	
	
	/********Issue Certificates Page****/
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[1]/div/div/div[2]/div/a[1]")
	WebElement SyncWithCaButton;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[1]/div/div/div[2]/div/a[2]")
	WebElement SendFulfillmentButton;
	
	@FindBy(xpath = ".//*[@id='CertificateMysslViewForm']/div[2]/div[1]/div/button")
	WebElement TransferToAccountButton;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[1]/div/div/div[2]/div/a[4]")
	WebElement AssignRenewalProductButton;
	
	@FindBy(xpath = ".//*[@id='CertificateNotes']")
	WebElement EmailNotesField;
	
	@FindBy(xpath = ".//*[@id='CertificateEmail']")
	WebElement EmailAddressField;
	
	@FindBy(xpath = ".//*[@id='CertificateOneOffEmail']")
	WebElement OneOffEmailAddressField;
	
	@FindBy(xpath = ".//*[@id='sendFulfillmentEmail']/form/div[4]/button")
	WebElement SendEmailButton;
	

	
	public Admin_CertificateDetailsPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	public void SyncWithCaButtonClick(){
		
		SyncWithCaButton.click();
		
	}
	
	public void SendFulfillmentButtonClick(){
		
		SendFulfillmentButton.click();
		
	}
	
	public void TransferToAccountButtonClick(){
		
		TransferToAccountButton.click();
		
	}
	
	public void AssignRenewalProductButtonClick(){
		
		AssignRenewalProductButton.click();
		
	}
	
	public void EmailNotesField_Fill(String Note){
		
		EmailNotesField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		EmailNotesField.sendKeys(Note);
		
	}
	
	public void EmailAddressField_Select(String Email){
		
		Select EmailAdd = new Select(EmailAddressField);
	  	EmailAdd.selectByVisibleText(Email);
	  	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
	}
	
	public void OneOffEmailAddressField_Fill(String Email){
		
		OneOffEmailAddressField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		OneOffEmailAddressField.sendKeys(Email);
		
	}
	
	public void SendEmailButtonClick(){
		
		SendEmailButton.click();
		
	}
	
}
