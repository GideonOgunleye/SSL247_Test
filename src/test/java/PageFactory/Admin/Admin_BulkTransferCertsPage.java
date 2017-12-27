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


public class Admin_BulkTransferCertsPage extends DriverLoad {
	ExtentReports report;
	ExtentTest test;
	
	
	/**********Bulk Edit Certificates Page**************/
	@FindBy(xpath = ".//*[@id='certificateDetails']/li[1]/a")
	WebElement ExpiringTab;

	@FindBy(xpath = ".//*[@id='certificateDetails']/li[2]/a")
	WebElement NotecraftsTab;
	
	@FindBy(xpath = ".//*[@id='certificateDetails']/li[3]/a")
	WebElement ExpiredTab;
	
	@FindBy(xpath = ".//*[@id='certificateDetails']/li[4]/a")
	WebElement StockTab;
	
	@FindBy(xpath = ".//*[@id='certificateDetails']/li[5]/a")
	WebElement PendingTab;
	
	@FindBy(xpath = ".//*[@id='certificateDetails']/li[6]/a")
	WebElement IncompleteTab;
	
	@FindBy(xpath = ".//*[@id='certificateDetails']/li[7]/a")
	WebElement CancelledTab;
	
	@FindBy(xpath = ".//*[@id='certificateDetails']/li[8]/a")
	WebElement ArchivedTab;
	
	@FindBy(xpath = ".//*[@id='certificateDetails']/li[9]/a")
	WebElement IssuedTab;
	
	@FindBy(xpath = ".//*[@id='issued']/table/tbody/tr[1]/td[1]/input[2]")
	WebElement IssueTab_CheckBoxOne;
	
	@FindBy(xpath = ".//*[@id='issued']/table/tbody/tr[2]/td[1]/input[2]")
	WebElement IssuedTab_CheckBoxTwo;
	
	@FindBy(xpath = ".//*[@id='certificateDetails']/li[10]/a")
	WebElement DeactivatedTab;
	
	@FindBy(xpath = ".//*[@id='certificateDetails']/li[11]/a")
	WebElement SHA_1Tab;
	
	@FindBy(xpath = ".//*[@id='certificateDetails']/li[12]/a")
	WebElement RequiredReissueTab;
	
	@FindBy(xpath = ".//*[@id='CertificateAccount']")
	WebElement SearchAccountField;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminAccountBulkTransferCertificatesForm']/div[4]/button")
	WebElement TransferCertificatesButton;
	

	
	
	
	public Admin_BulkTransferCertsPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	
	public void ExpiringTab_Click(){
		
		ExpiringTab.click();
	}
	
	public void NotecraftsTab_Click(){
		
		NotecraftsTab.click();
	}
	
	public void ExpiredTab_Click(){
		
		ExpiredTab.click();
	}
	
	public void StockTab_Click(){
		
		StockTab.click();
	}
	
	public void PendingTab_Click(){
		
		PendingTab.click();
	}
	
	public void IncompleteTab_Click(){
		
		IncompleteTab.click();
	}
	
	public void CancelledTab_Click(){
		
		CancelledTab.click();
	}
	
	public void ArchivedTab_Click(){
		
		ArchivedTab.click();
	}
	
	public void IssuedTab_Click(){
		
		IssuedTab.click();
	}
	
	public void IssueTab_CheckBoxOne_Click(){
		
		IssueTab_CheckBoxOne.click();
	}
	
	public void IssuedTab_CheckBoxTwo_Click(){
		
		IssuedTab_CheckBoxTwo.click();
	}
	
	public void DeactivatedTab_Click(){
		
		DeactivatedTab.click();
	}
	
	public void SHA_1Tab_Click(){
		
		SHA_1Tab.click();
	}
	
	public void RequiredReissueTab_Click(){
		
		RequiredReissueTab.click();
	}
	
	public void SearchAccountFieldSendKeys(String Account) {
		
		SearchAccountField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		SearchAccountField.sendKeys(Account);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);

	}
	
	public void TransferCertificatesButton_Click(){
		
		TransferCertificatesButton.click();
	}


}
