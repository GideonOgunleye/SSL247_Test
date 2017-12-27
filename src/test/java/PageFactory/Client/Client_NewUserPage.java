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


public class Client_NewUserPage extends DriverLoad {
	ExtentReports report;
	ExtentTest test;
	
	@FindBy(xpath = ".//*[@id='UserRole']")
	WebElement RoleSelectField;
	
	@FindBy(xpath = ".//*[@id='UserAccessLevel']")
	WebElement AccessLevelSelectField;
	
	@FindBy(xpath = ".//*[@id='UserTitle']")
	WebElement TitleSelectField;
	
	@FindBy(xpath = ".//*[@id='UserFirstname']")
	WebElement FirstNameField;
	
	@FindBy(xpath = ".//*[@id='UserLastname']")
	WebElement LastNameField;
	
	@FindBy(xpath = ".//*[@id='UserEmail']")
	WebElement EmailField;
	
	@FindBy(xpath = ".//*[@id='UserPhone']")
	WebElement PhoneField;
	
	@FindBy(xpath = ".//*[@id='UserPosition']")
	WebElement PositionField;
	
	@FindBy(xpath = ".//*[@id='UserAddress1']")
	WebElement AddressOneField;
	
	@FindBy(xpath = ".//*[@id='UserAddress2']")
	WebElement AddressTwoField;
	
	@FindBy(xpath = ".//*[@id='UserAddress3']")
	WebElement AddressThreeField;
	
	@FindBy(xpath = ".//*[@id='UserCity']")
	WebElement CityField;
	
	@FindBy(xpath = ".//*[@id='UserState']")
	WebElement StateField;
	
	@FindBy(xpath = ".//*[@id='UserPostcode']")
	WebElement PostCodeField;
	
	@FindBy(xpath = ".//*[@id='UserCountry']")
	WebElement CountrySelectField;
	
	@FindBy(xpath = ".//*[@id='UserFax']")
	WebElement FaxField;
	
	@FindBy(xpath = ".//*[@id='UserCompanyName']")
	WebElement CompanyNameField;
	
	@FindBy(xpath = ".//*[@id='UserRegistrationNumber']")
	WebElement RegistrationField;
	
	@FindBy(xpath = ".//*[@id='UserMysslAddForm']/h2/button")
	WebElement SaveUserButton;
	
	@FindBy(xpath = ".//*[@id='UserMysslAddForm']/h2/a")
	WebElement CancelButton;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[4]/div[2]/h2")
	WebElement PageHeader;
	

	
	public Client_NewUserPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	
	public String PageHeader_GetText() {
		
		return PageHeader.getText();
		
	}
	
	
	public void RoleSelectField_Select(String Number){
		
		 Select Level = new Select(RoleSelectField);
		 Level.selectByValue(Number);
	}

	public void AccessLevelSelectField_Select(String UserAccessLevel){
		
		 Select Level = new Select(AccessLevelSelectField);
		 Level.selectByVisibleText(UserAccessLevel);
	}
	
	public void TitleSelectField_Select(String Title){
		
		 Select Level = new Select(TitleSelectField);
		 Level.selectByVisibleText(Title);
		 
	}
	
	public void FirstNameField_SendKeys(String FirstName) {
		
		FirstNameField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		FirstNameField.sendKeys(FirstName);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	public void LastNameField_SendKeys(String LastName) {
		
		LastNameField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		LastNameField.sendKeys(LastName);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	public void EmailField_SendKeys(String Email) {
		
		EmailField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		EmailField.sendKeys(Email);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	public void PhoneField_SendKeys(String PhoneNumber) {
		
		PhoneField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		PhoneField.sendKeys(PhoneNumber);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	public void PositionField_SendKeys(String Position) {
		
		PositionField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		PositionField.sendKeys(Position);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	public void AddressOneField_SendKeys(String Address) {
		
		AddressOneField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		AddressOneField.sendKeys(Address);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	public void AddressTwoField_SendKeys(String Address) {
		
		AddressTwoField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		AddressTwoField.sendKeys(Address);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	public void AddressThreeField_SendKeys(String Address) {
		
		AddressThreeField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		AddressThreeField.sendKeys(Address);
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
	
	public void PostCodeField_SendKeys(String Postcode) {
		
		PostCodeField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		PostCodeField.sendKeys(Postcode);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	
	public void CountrySelectField_Select(String CountryName){
		
		 Select Level = new Select(CountrySelectField);
		 Level.selectByVisibleText(CountryName);
	}
	
	
	public void FaxField_SendKeys(String FaxNumber) {
		
		FaxField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		FaxField.sendKeys(FaxNumber);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	public void CompanyNameField_SendKeys(String CompanyName) {
		
		CompanyNameField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		CompanyNameField.sendKeys(CompanyName);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	public void RegistrationField_SendKeys(String Number) {
		
		RegistrationField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		RegistrationField.sendKeys(Number);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	public void SaveUserButton_Click(){
		
		SaveUserButton.click();
	}
	
	public void CancelButton_Click(){
		
		CancelButton.click();
	}
	
	
	

}
