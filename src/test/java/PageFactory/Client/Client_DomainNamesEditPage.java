package PageFactory.Client;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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


public class Client_DomainNamesEditPage extends DriverLoad {
	ExtentReports report;
	ExtentTest test;
	

	
	public Client_DomainNamesEditPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[4]/div[2]/h2")
	WebElement PageHeader;
	
	public String PageHeader_GetText() {
		
		return PageHeader.getText();
		
	}
	
	//Domains Tab**************************************************************
	
	@FindBy(xpath = ".//*[@id='DomainNameMysslEditForm']/div[2]/div[2]/ul/li[1]/a")
	WebElement DomainDetailsTab;
	
	public void DomainDetailsTab_Clink(){
		
		DomainDetailsTab.click();
	}
	
	//Admin Tab****************************************************************
	
	@FindBy(xpath = ".//*[@id='DomainNameMysslEditForm']/div[2]/div[2]/ul/li[2]/a")
	WebElement AdminTab;

	
	public void AdminTab_Clink(){
		
		AdminTab.click();
	}
	
	@FindBy(xpath = ".//*[@id='AdminContactUser']")
	WebElement AdminTab_ContactSelectField;
	
	public void AdminTab_ContactSelectField_Select(String FullName){
		
		 Select Level = new Select(AdminTab_ContactSelectField);
		 Level.selectByVisibleText(FullName);
	}
	
	@FindBy(xpath = ".//*[@id='AdminContactOrgName']")
	WebElement AdminTab_OrgNameField;
	
	public void AdminTab_OrgNameField_SendKeys(String CompanyName) {
		
		AdminTab_OrgNameField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		AdminTab_OrgNameField.sendKeys(CompanyName);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	@FindBy(xpath = ".//*[@id='AdminContactTitle']")
	WebElement AdminTab_TitleSelectField;
	
	public void AdminTab_TitleSelectField_Select(String Title){
		
		 Select Level = new Select(AdminTab_TitleSelectField);
		 Level.selectByVisibleText(Title);
	}
	
	@FindBy(xpath = ".//*[@id='AdminContactFirstname']")
	WebElement AdminTab_FirstNameField;
	
	public void AdminTab_FirstNameField_SendKeys(String Firstname) {
		
		AdminTab_FirstNameField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		AdminTab_FirstNameField.sendKeys(Firstname);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	@FindBy(xpath = ".//*[@id='AdminContactLastname']")
	WebElement AdminTab_LastNameField;
	
	public void AdminTab_LastNameField_SendKeys(String Lastname) {
		
		AdminTab_LastNameField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		AdminTab_LastNameField.sendKeys(Lastname);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	@FindBy(xpath = ".//*[@id='AdminContactEmail']")
	WebElement AdminTab_EmailField;
	
	public void AdminTab_EmailField_SendKeys(String Email) {
		
		AdminTab_EmailField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		AdminTab_EmailField.sendKeys(Email);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	@FindBy(xpath = ".//*[@id='AdminContactDialingCode']")
	WebElement AdminTab_DialingCodeField;
	
	public void AdminTab_DialingCodeField_SendKeys(String Code) {
		
		AdminTab_DialingCodeField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		AdminTab_DialingCodeField.sendKeys(Code);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	@FindBy(xpath = ".//*[@id='AdminContactPhone']")
	WebElement AdminTab_PhoneField;
	
	public void AdminTab_PhoneField_SendKeys(String PhoneNumber) {
		
		AdminTab_PhoneField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		AdminTab_PhoneField.sendKeys(PhoneNumber);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	@FindBy(xpath = ".//*[@id='AdminContactPhone']")
	WebElement AdminTab_AddressField;
	
	public void AdminTab_AddressField_SendKeys(String Address) {
		
		AdminTab_AddressField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		AdminTab_AddressField.sendKeys(Address);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	@FindBy(xpath = ".//*[@id='AdminContactCity']")
	WebElement AdminTab_CityField;
	
	public void AdminTab_CityField_SendKeys(String City) {
		
		AdminTab_CityField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		AdminTab_CityField.sendKeys(City);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	@FindBy(xpath = ".//*[@id='AdminContactPostcode']")
	WebElement AdminTab_PostcodeField;
	
	public void AdminTab_PostcodeField_SendKeys(String Postcode) {
		
		AdminTab_PostcodeField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		AdminTab_PostcodeField.sendKeys(Postcode);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	@FindBy(xpath = ".//*[@id='AdminContactRegion']")
	WebElement AdminTab_RegionField;
	
	public void AdminTab_RegionField_SendKeys(String Region) {
		
		AdminTab_RegionField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		AdminTab_RegionField.sendKeys(Region);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	@FindBy(xpath = ".//*[@id='AdminContactCountry']")
	WebElement AdminTab_CountrySelectField;
	
	public void AdminTab_CountrySelectField_Select(String CountryName){
		
		 Select Level = new Select(AdminTab_CountrySelectField);
		 Level.selectByVisibleText(CountryName);
	}
	
	
	//Technical Tab**************************************************************
	
	@FindBy(xpath = ".//*[@id='DomainNameMysslEditForm']/div[2]/div[2]/ul/li[3]/a")
	WebElement TechnicalTab;
	
	public void TechnicalTab_Click(){
		
		TechnicalTab.click();
	}
	
	@FindBy(xpath = ".//*[@id='TechnicalContactUser']")
	WebElement TechnicalTab_ContactSelectField;
	
	public void TechnicalTab_ContactSelectField_Select(String Name){
		
		 Select Level = new Select(TechnicalTab_ContactSelectField);
		 Level.selectByVisibleText(Name);
	}
	
	@FindBy(xpath = ".//*[@id='TechnicalContactOrgName']")
	WebElement TechnicalTab_OrgNameField;
	
	public void TechnicalTab_OrgNameField_SendKeys(String CompanyName) {
		
		TechnicalTab_OrgNameField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		TechnicalTab_OrgNameField.sendKeys(CompanyName);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	@FindBy(xpath = ".//*[@id='TechnicalContactTitle']")
	WebElement TechnicalTab_TitleSelectField;
	
	public void TechnicalTab_TitleSelectField_Select(String Title){
		
		 Select Level = new Select(TechnicalTab_TitleSelectField);
		 Level.selectByVisibleText(Title);
	}
	
	@FindBy(xpath = ".//*[@id='TechnicalContactFirstname']")
	WebElement TechnicalTab_FirstNameField;
	
	public void TechnicalTab_FirstNameField_SendKeys(String FirstName) {
		
		TechnicalTab_FirstNameField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		TechnicalTab_FirstNameField.sendKeys(FirstName);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	@FindBy(xpath = ".//*[@id='TechnicalContactLastname']")
	WebElement TechnicalTab_LastNameField;
	
	public void TechnicalTab_LastNameField_SendKeys(String LastName) {
		
		TechnicalTab_LastNameField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		TechnicalTab_LastNameField.sendKeys(LastName);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	
	@FindBy(xpath = ".//*[@id='TechnicalContactEmail']")
	WebElement TechnicalTab_EmailField;
	
	public void TechnicalTab_EmailField_SendKeys(String Email) {
		
		TechnicalTab_EmailField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		TechnicalTab_EmailField.sendKeys(Email);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	@FindBy(xpath = ".//*[@id='TechnicalContactDialingCode']")
	WebElement TechnicalTab_DialingCodeField;
	
	public void TechnicalTab_DialingCodeField_SendKeys(String Code) {
		
		TechnicalTab_DialingCodeField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		TechnicalTab_DialingCodeField.sendKeys(Code);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	@FindBy(xpath = ".//*[@id='TechnicalContactPhone']")
	WebElement TechnicalTab_PhoneField;
	
	public void TechnicalTab_PhoneField_SendKeys(String PhoneNumber) {
		
		TechnicalTab_PhoneField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		TechnicalTab_PhoneField.sendKeys(PhoneNumber);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	@FindBy(xpath = ".//*[@id='TechnicalContactAddress1']")
	WebElement TechnicalTab_AddressField;
	
	public void TechnicalTab_AddressField_SendKeys(String Address) {
		
		TechnicalTab_AddressField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		TechnicalTab_AddressField.sendKeys(Address);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	@FindBy(xpath = ".//*[@id='TechnicalContactCity']")
	WebElement TechnicalTab_CityField;
	
	public void TechnicalTab_CityField_SendKeys(String City) {
		
		TechnicalTab_CityField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		TechnicalTab_CityField.sendKeys(City);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	@FindBy(xpath = ".//*[@id='TechnicalContactPostcode']")
	WebElement TechnicalTab_PostcodeField;
	
	public void TechnicalTab_PostcodeField_SendKeys(String PostCode) {
		
		TechnicalTab_PostcodeField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		TechnicalTab_PostcodeField.sendKeys(PostCode);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	@FindBy(xpath = ".//*[@id='TechnicalContactRegion']")
	WebElement TechnicalTab_ReligionField;
	
	public void TechnicalTab_ReligionField_SendKeys(String Account) {
		
		TechnicalTab_ReligionField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		TechnicalTab_ReligionField.sendKeys(Account);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	@FindBy(xpath = ".//*[@id='TechnicalContactCountry']")
	WebElement TechnicalTab_CountrySelectField;
	
	public void TechnicalTab_CountrySelectField_Select(String CountryName){
		
		 Select Level = new Select(TechnicalTab_CountrySelectField);
		 Level.selectByVisibleText(CountryName);
		 
	}
	
	
	//OwnerTab**********************************************************************
	
	@FindBy(xpath = ".//*[@id='DomainNameMysslEditForm']/div[2]/div[2]/ul/li[4]/a")
	WebElement OwnerTab;
	
	public void OwnerTab_Click(){
		
		OwnerTab.click();
	}
	
	@FindBy(xpath = ".//*[@id='OwnerContactUser']")
	WebElement OwnerTab_ContactSelectField;
	
	public void OwnerTab_ContactSelectField_Select(String FullName){
		
		 Select Level = new Select(OwnerTab_ContactSelectField);
		 Level.selectByVisibleText(FullName);
	}
	
	@FindBy(xpath = ".//*[@id='OwnerContactOrgName']")
	WebElement OwnerTab_OrgNameField;
	
	public void OwnerTab_OrgNameField_SendKeys(String CompanyName) {
		
		OwnerTab_OrgNameField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		OwnerTab_OrgNameField.sendKeys(CompanyName);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	@FindBy(xpath = ".//*[@id='OwnerContactTitle']")
	WebElement OwnerTab_TitleSelectField;
	
	public void OwnerTab_TitleSelectField_Select(String Title){
		
		 Select Level = new Select(OwnerTab_TitleSelectField);
		 Level.selectByVisibleText(Title);
	}
	
	@FindBy(xpath = ".//*[@id='OwnerContactFirstname']")
	WebElement OwnerTab_FirstNameField;
	
	public void OwnerTab_FirstNameField_SendKeys(String Firstname) {
		
		OwnerTab_FirstNameField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		OwnerTab_FirstNameField.sendKeys(Firstname);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	@FindBy(xpath = ".//*[@id='OwnerContactLastname']")
	WebElement OwnerTab_LastNameField;
	
	public void OwnerTab_LastNameField_SendKeys(String Lastname) {
		
		OwnerTab_LastNameField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		OwnerTab_LastNameField.sendKeys(Lastname);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	@FindBy(xpath = ".//*[@id='OwnerContactEmail']")
	WebElement OwnerTab_EmailField;
	
	public void OwnerTab_EmailField_SendKeys(String Email) {
		
		OwnerTab_EmailField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		OwnerTab_EmailField.sendKeys(Email);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	@FindBy(xpath = ".//*[@id='OwnerContactDialingCode']")
	WebElement OwnerTab_DialingCodeField;
	
	public void OwnerTab_DialingCodeField_SendKeys(String Code) {
		
		OwnerTab_DialingCodeField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		OwnerTab_DialingCodeField.sendKeys(Code);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	@FindBy(xpath = ".//*[@id='OwnerContactPhone']")
	WebElement OwnerTab_PhoneField;
	
	public void OwnerTab_PhoneField_SendKeys(String PhoneNumber) {
		
		OwnerTab_PhoneField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		OwnerTab_PhoneField.sendKeys(PhoneNumber);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	@FindBy(xpath = ".//*[@id='OwnerContactAddress1']")
	WebElement OwnerTab_AddressField;
	
	public void OwnerTab_AddressField_SendKeys(String Address) {
		
		OwnerTab_AddressField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		OwnerTab_AddressField.sendKeys(Address);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	@FindBy(xpath = ".//*[@id='OwnerContactCity']")
	WebElement OwnerTab_CityField;
	
	public void OwnerTab_CityField_SendKeys(String City) {
		
		OwnerTab_CityField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		OwnerTab_CityField.sendKeys(City);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	@FindBy(xpath = ".//*[@id='OwnerContactRegion']")
	WebElement OwnerTab_RegionField;
	
	public void OwnerTab_RegionField_SendKeys(String Region) {
		
		OwnerTab_RegionField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		OwnerTab_RegionField.sendKeys(Region);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	@FindBy(xpath = ".//*[@id='OwnerContactPostcode']")
	WebElement OwnerTab_PostcodeField;
	
	public void OwnerTab_PostcodeField_SendKeys(String Postcode) {
		
		OwnerTab_PostcodeField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		OwnerTab_PostcodeField.sendKeys(Postcode);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	@FindBy(xpath = ".//*[@id='OwnerContactCountry']")
	WebElement OwnerTab_CountrySelectField;
	
	public void OwnerTab_CountrySelectField_Select(String CountryName){
		
		 Select Level = new Select(OwnerTab_CountrySelectField);
		 Level.selectByVisibleText(CountryName);
	}
	
	@FindBy(xpath = ".//*[@id='DomainNameMysslEditForm']/div[2]/div[1]/button")
	WebElement SaveChangesButton;
	
	public void SaveChangesButton_Click(){
		
		SaveChangesButton.click();
	}
	


}
