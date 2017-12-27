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


public class Admin_SearchCertificatesPage extends DriverLoad {
	ExtentReports report;
	ExtentTest test;
	

	/********Certificates Page**********/
	
	@FindBy(xpath = ".//*[@id='CertificateCommonName']")
	WebElement CommonNameField;
	
	@FindBy(xpath = ".//*[@id='CertificateExpiresAfter']")
	WebElement ExpiresAfterField;
	
	@FindBy(xpath = ".//*[@id='CertificateExpiresBefore']")
	WebElement ExpiresBeforeField;
	
	@FindBy(xpath = ".//*[@id='CertificateIssuedAfter']")
	WebElement IssuedAfterField;
	
	@FindBy(xpath = ".//*[@id='CertificateIssuedBefore']")
	WebElement IssuedBeforeField;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminAccountIndexForm']/div[2]/div/div[2]/div/button")
	WebElement SearchButton;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminAccountIndexForm']/div[2]/div/div[2]/div/a[1]")
	WebElement ExportSslCertsButton;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminAccountIndexForm']/div[2]/div/div[2]/div/a[2]")
	WebElement OrderNewSslCertButton;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminAccountIndexForm']/div[2]/div/div[2]/div/a[3]")
	WebElement AddMissingCertButton;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminAccountIndexForm']/div[2]/div/div[2]/div/a[4]")
	WebElement AddExternalSslCertButton;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminAccountIndexForm']/div[2]/div/div[2]/div/a[5]")
	WebElement ImportExternalSslFromExceelButton;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminAccountIndexForm']/div[2]/div/div[2]/div/a[6]")
	WebElement BulkEditNoteCratfCertsButton;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminAccountIndexForm']/div[2]/div/div[2]/div/a[7]")
	WebElement BulkEditContactsButton;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminAccountIndexForm']/div[2]/div/div[2]/div/a[8]")
	WebElement BulkTransferCertificateButton;
	
	@FindBy(xpath = ".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[2]")
	WebElement FirstResultCommonName;
	
	@FindBy(xpath = ".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[5]/div/button")
	WebElement FirstResultSelectButton;
	
	@FindBy(xpath = ".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[5]/div/ul/li[1]/a")
	WebElement FirstResultCompleteBtn;
	
	@FindBy(xpath = ".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[5]/div/ul/li[2]/a")
	WebElement FirstResultViewBtn;
	
	@FindBy(xpath = ".//*[@id='DataTables_Table_0']/tbody/tr[2]/td[2]")
	WebElement SecondResultCommonName;
	
	@FindBy(xpath = ".//*[@id='DataTables_Table_0']/tbody/tr[2]/td[5]/div/button")
	WebElement SecondResultSelectButton;
	
	@FindBy(xpath = ".//*[@id='DataTables_Table_0']/tbody/tr[2]/td[5]/div/ul/li[1]/a")
	WebElement SecondResultCompleteBtn;
	
	@FindBy(xpath = ".//*[@id='DataTables_Table_0']/tbody/tr[2]/td[5]/div/ul/li[2]/a")
	WebElement SecondResultViewBtn;
	
	
	
	
	public Admin_SearchCertificatesPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	
	public void CommonNameField_SendKeys(String Cname) {
		
		CommonNameField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		CommonNameField.sendKeys(Cname);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
	}
	
	public void ExpiresAfterField_SendKeys(String Date) {
		
		ExpiresAfterField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		ExpiresAfterField.sendKeys(Date);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	public void ExpiresBeforeField_SendKeys(String Date) {
		
		ExpiresBeforeField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		ExpiresBeforeField.sendKeys(Date);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
	}
	
	public void IssuedAfterField_SendKeys(String Date) {
		
		IssuedAfterField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		IssuedAfterField.sendKeys(Date);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
	}
	
	public void IssuedBeforeField_SendKeys(String Date) {
		
		IssuedBeforeField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		IssuedBeforeField.sendKeys(Date);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
	}
	
	public void SearchButton_Click(){
		
		SearchButton.click();
	}
	
	public void ExportSslCertsButton_Click(){
		
		ExportSslCertsButton.click();
	}
	
	public void OrderNewSslCertButton_Click(){
		
		OrderNewSslCertButton.click();
	}
	
	public void AddMissingCertButton_Click(){
		
		AddMissingCertButton.click();
	}
	
	public void AddExternalSslCertButton_Click(){
		
		AddExternalSslCertButton.click();
	}
	
	public void ImportExternalSslFromExceelButton_Click(){
		
		ImportExternalSslFromExceelButton.click();
	}
	
	public void BulkEditNoteCratfCertsButton_Click(){
		
		BulkEditNoteCratfCertsButton.click();
	}
	
	public void BulkEditContactsButton_Click(){
		
		BulkEditContactsButton.click();
	}
	
	public void BulkTransferCertificateButton_Click(){
		
		BulkTransferCertificateButton.click();
	}
	
	public boolean FirstResultCommonName_Contains(String Cname){
		
		return FirstResultCommonName.getText().contains(Cname);
		
	}
	
	public void FirstResultCompleteBtn_Click(){
		
		FirstResultSelectButton.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		FirstResultCompleteBtn.click();
	}
	
	public void FirstResultViewBtn_Click(){
		
		FirstResultSelectButton.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		FirstResultViewBtn.click();
	}
	
	public boolean SecondResultCommonName_Contains(String Cname){
		
		return SecondResultCommonName.getText().contains(Cname);
		
	}
	
	public void SecondResultCompleteBtn_Click(){
		
		FirstResultSelectButton.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		SecondResultCompleteBtn.click();
	}
	
	public void SecondResultViewBtn_Click(){
		
		FirstResultSelectButton.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		SecondResultViewBtn.click();
	}
	
	

}
