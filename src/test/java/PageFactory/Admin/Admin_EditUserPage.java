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


public class Admin_EditUserPage extends DriverLoad {
	ExtentReports report;
	ExtentTest test;
	
	
	/********Edit User Page**********/
	@FindBy(xpath = ".//*[@id='UserAdminEditForm']/div[3]/ul/li[1]/a")
	WebElement RequiredDetailsTab;	
	
	@FindBy(xpath = ".//*[@id='UserLanguage']")
	WebElement LanguageField;
	
	@FindBy(xpath = ".//*[@id='UserRole']")
	WebElement RoleField;
	
	@FindBy(xpath = ".//*[@id='UserAccessLevel']")
	WebElement AccessLevelField;
	
	@FindBy(xpath = ".//*[@id='UserTitle']")
	WebElement TitleField;
	
	@FindBy(xpath = ".//*[@id='UserFirstname']")
	WebElement FirstNameField;
	
	@FindBy(xpath = ".//*[@id='UserLastname']")
	WebElement LastNameField;
	
	@FindBy(xpath = ".//*[@id='UserEmail']")
	WebElement EmailField;
	
	@FindBy(xpath = ".//*[@id='UserPhone']")
	WebElement PhoneField;
	
	@FindBy(xpath = ".//*[@id='UserPhone']")
	WebElement MobileField;
	
	@FindBy(xpath = ".//*[@id='UserAdminEditForm']/div[3]/ul/li[2]/a")
	WebElement OptionalDetailsTab;
	
	@FindBy(xpath = ".//*[@id='UserCompanyName']")
	WebElement CompanyNameField;
	
	@FindBy(xpath = ".//*[@id='UserAddress1']")
	WebElement AddressField;
	
	@FindBy(xpath = ".//*[@id='UserCity']")
	WebElement CityField;
	
	@FindBy(xpath = ".//*[@id='UserState']")
	WebElement StateField;
	
	@FindBy(xpath = ".//*[@id='UserPostcode']")
	WebElement PostCodeField;
	
	@FindBy(xpath = ".//*[@id='UserCountry']")
	WebElement CountryField;
	
	@FindBy(xpath = ".//*[@id='UserAdminEditForm']/div[2]/button")
	WebElement SubmitChangesButton;
	
	@FindBy(xpath = ".//*[@id='UserAdminEditForm']/div[2]/a")
	WebElement SendChangePasswordEmailButton;
	
	
	public Admin_EditUserPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		//PageFactory.initElements(driver, this);
		
	}

	
	
	public void RequiredDetailsTab_Click() {
		
		RequiredDetailsTab.click();
	}
	
	public void LanguageField_Select(String Name){
		
		 Select Level = new Select(LanguageField);
		 Level.selectByVisibleText(Name);
	}
	
	public void RoleField_Select(){
		
		 Select Level = new Select(RoleField);
		 Level.selectByIndex(1);
	}
	
	public void AccessLevel_SelectSuperUser(){
		
		 Select Level = new Select(AccessLevelField);
		 Level.selectByIndex(1);
	}
	
	public void TitleField_SelectMr(){
		
		 Select Level = new Select(TitleField);
		 Level.selectByIndex(0);
	}
	
	public void FirstNameField_SendKeys(String Fname) {
		
		FirstNameField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		FirstNameField.sendKeys(Fname);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
	}
	
	public void LastNameField_SendKeys(String Lname) {
		
		LastNameField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		LastNameField.sendKeys(Lname);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
	}
	
	public void EmailField_SendKeys(String Email) {
		
		EmailField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		EmailField.sendKeys(Email);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
	}
	
	public void PhoneField_SendKeys(String Number) {
		
		PhoneField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		PhoneField.sendKeys(Number);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
	}
	
	public void MobileField_SendKeys(String Number) {
		
		MobileField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		MobileField.sendKeys(Number);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
	}
	
	public void OptionalDetailsTab_Click() {
		
		OptionalDetailsTab.click();
	}
	
	
	public void CompanyNameField_SendKeys(String Name) {
		
		CompanyNameField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		CompanyNameField.sendKeys(Name);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
	}
	
	
	public void AddressField_SendKeys(String Address) {
		
		AddressField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		AddressField.sendKeys(Address);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
	}
	
	public void CityField_SendKeys(String City) {
		
		CityField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		CityField.sendKeys(City);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
	}
	
	public void StateField_SendKeys(String State) {
		
		StateField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		StateField.sendKeys(State);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
	}
	
	public void PostCodeField_SendKeys(String PostCode) {
		
		PostCodeField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		PostCodeField.sendKeys(PostCode);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
	}
	
	public void CountryField_Select(String Country){
		
		 Select Level = new Select(CountryField);
		 Level.selectByVisibleText(Country);
	}
	
	public void StateField_Sendkeys(String State) {
		
		StateField.clear();
		StateField.sendKeys(State);
	}
	
	public void SendChangePasswordEmailButton_Click() {
		
		SendChangePasswordEmailButton.click();
	}
	
	public void SubmitChangesButton_Click() {
		
		SubmitChangesButton.click();
	}
	
}
