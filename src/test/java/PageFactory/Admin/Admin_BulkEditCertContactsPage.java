package PageFactory.Admin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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


public class Admin_BulkEditCertContactsPage extends DriverLoad {
	ExtentReports report;
	ExtentTest test;
	
	
	/**********Bulk Edit Certificates Page**************/
	@FindBy(xpath = ".//*[@id='certificateDetails']/li[1]/a")
	WebElement IssuedContactsTab;
	
	@FindBy(xpath = ".//*[@id='certificateDetails']/li[2]/a")
	WebElement ExpiringContactsTab;
	
	@FindBy(xpath = ".//*[@id='certificateDetails']/li[3]/a")
	WebElement PendingContactsTab;
	
	@FindBy(xpath = ".//*[@id='certificateDetails']/li[4]/a")
	WebElement NoteCraftContactsTab;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminAccountEditContactsForm']/table/thead/tr/th[4]/label/input")
	WebElement AllCertTechContactCheckbox;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminAccountEditContactsForm']/table/thead/tr/th[5]/label/input")
	WebElement AllCertAdminContactCheckbox;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminAccountEditContactsForm']/table/tbody/tr[1]/td[4]/Label/input[2]")
	WebElement FirstCertTechContactCheckbox;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminAccountEditContactsForm']/table/tbody/tr[1]/td[5]/Label/input[2]")
	WebElement FirstCertAdminContactCheckbox;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminAccountEditContactsForm']/table/tbody/tr[2]/td[4]/Label/input[2]")
	WebElement SecondCertTechContactCheckbox;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminAccountEditContactsForm']/table/tbody/tr[2]/td[5]/Label/input[2]")
	WebElement SecondCertAdminContactCheckbox;
	
	@FindBy(xpath = ".//*[@id='CertificateTechContact']")
	WebElement AccountOrganisationField;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminAccountEditContactsForm']/div[3]/button")
	WebElement UpdateCertificatesButton;
	
	
	
	public Admin_BulkEditCertContactsPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	
	public void IssuedContactsTab_Click(){
		
		IssuedContactsTab.click();
	}
	
	public void ExpiringContactsTab_Click(){
		
		ExpiringContactsTab.click();
	}
	
	public void PendingContactsTab_Click(){
		
		PendingContactsTab.click();
	}
	
	public void NoteCraftContactsTab_Click(){
		
		NoteCraftContactsTab.click();
	}
	
	public void AllCertTechContactCheckbox_Click(){
		
		AllCertTechContactCheckbox.click();
	}
	
	public void AllCertAdminContactCheckbox_Click(){
		
		AllCertAdminContactCheckbox.click();
	}
	
	public void FirstCertTechContactCheckbox_Click(){
		
		FirstCertTechContactCheckbox.click();
	}
	
	public void FirstCertAdminContactCheckbox_Click(){
		
		FirstCertAdminContactCheckbox.click();
	}
	
	public void SecondCertTechContactCheckbox_Click(){
		
		SecondCertTechContactCheckbox.click();
	}
	
	public void SecondCertAdminContactCheckbox_Click(){
		
		SecondCertAdminContactCheckbox.click();
	}
	
	public void AccountOrganisationField_Select(String Name){
		
		 Select Level = new Select(AccountOrganisationField);
		 Level.selectByVisibleText(Name);
	}
	
	public void UpdateCertificatesButton_Click(){
		
		UpdateCertificatesButton.click();
	}


}
