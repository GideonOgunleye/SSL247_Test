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


public class Client_EditUserPage extends DriverLoad {
	ExtentReports report;
	ExtentTest test;
	
	@FindBy(xpath = ".//*[@id='UserMysslEditForm']/div[3]/ul/li[1]/a")
	WebElement UserDetailsTab;
	
	@FindBy(xpath = ".//*[@id='UserLanguage']")
	WebElement LanguageSelectField;
	
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
	
	@FindBy(xpath = ".//*[@id='UserMysslEditForm']/div[3]/ul/li[2]/a")
	WebElement AdditionalDetailsTab;
	
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
	WebElement CountrySelectField;
	
	@FindBy(xpath = ".//*[@id='UserMysslEditForm']/div[3]/ul/li[3]/a")
	WebElement OptionalCompanyDetailsDetailsTab;
	
	@FindBy(xpath = ".//*[@id='UserRegistrationNumber']")
	WebElement RegistrationNumberField;
	
	@FindBy(xpath = ".//*[@id='UserMysslEditForm']/div[3]/ul/li[4]/a")
	WebElement UpdateYourPasswordTab;
	
	@FindBy(xpath = ".//*[@id='UserNewPassword']")
	WebElement NewPasswordField;
	
	@FindBy(xpath = ".//*[@id='UserConfirmPassword']")
	WebElement ConfirmNewPasswordField;
	
	@FindBy(xpath = ".//*[@id='UserMysslEditForm']/div[2]/button")
	WebElement SubmitChangesButton;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[4]/div[2]/h2")
	WebElement PageHeader;
	

	
	public Client_EditUserPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	
	public String PageHeader_GetText() {
		
		return PageHeader.getText();
		
	}
	
	public void UserDetailsTab_Click(){
		
		UserDetailsTab.click();
	}
	
	public void LanguageSelectField_SelectByText(String Language){
		
		 Select Level = new Select(LanguageSelectField);
		 Level.selectByVisibleText(Language);
	}
	
	public void RoleSelectField_SelectByIndex(int IndexNumber){
		
		 Select Level = new Select(RoleSelectField);
		 Level.selectByIndex(IndexNumber);
	}

	public void AccessLevelSelectField_SelectByText(String UserAccessLevel){
		
		 Select Level = new Select(AccessLevelSelectField);
		 Level.selectByVisibleText(UserAccessLevel);
	}
	
	public void TitleSelectField_SelectByText(String Title){
		
		 Select Level = new Select(TitleSelectField);
		 Level.selectByVisibleText(Title);
	}
	
	public void FirstNameField_SendKeys(String Firstname) {
		
		FirstNameField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		FirstNameField.sendKeys(Firstname);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	public void LastNameField_SendKeys(String Lastname) {
		
		LastNameField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		LastNameField.sendKeys(Lastname);
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
	
	public void AdditionalDetailsTab_Click(){
		
		AdditionalDetailsTab.click();
	}
	
	public void CompanyNameField_SendKeys(String Cname) {
		
		CompanyNameField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		CompanyNameField.sendKeys(Cname);
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
	
	public void PostCodeField_SendKeys(String Postcode) {
		
		PostCodeField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		PostCodeField.sendKeys(Postcode);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	public void CountrySelectField_SelectByText(String CountryName){
		
		 Select Level = new Select(CountrySelectField);
		 Level.selectByVisibleText(CountryName);
	}
	
	public void OptionalCompanyDetailsDetailsTab_Click(){
		
		OptionalCompanyDetailsDetailsTab.click();
	}
	
	public void RegistrationNumberField_SendKeys(String RegNo) {
		
		RegistrationNumberField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		RegistrationNumberField.sendKeys(RegNo);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	public void UpdateYourPasswordTab_Click(){
		
		UpdateYourPasswordTab.click();
	}
	
	public void NewPasswordField_SendKeys(String Password) {
		
		NewPasswordField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		NewPasswordField.sendKeys(Password);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	public void ConfirmNewPasswordField_SendKeys(String Password) {
		
		ConfirmNewPasswordField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		ConfirmNewPasswordField.sendKeys(Password);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	public void SubmitChangesButton_Click(){
		
		SubmitChangesButton.click();
	}

}
