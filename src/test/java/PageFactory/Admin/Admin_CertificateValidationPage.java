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


public class Admin_CertificateValidationPage extends DriverLoad {
	ExtentReports report;
	ExtentTest test;
	
	
	/********Certificate Details Tab****/
	
	@FindBy(xpath = ".//*[@id='CertificateAdminEditForm']/div[2]/div[2]/ul/li[1]/a")
	WebElement CertificateDetailsTab;
	
	@FindBy(xpath = ".//*[@id='CertificateCommonName']")
	WebElement CommonNameField;
	
	@FindBy(xpath = ".//*[@id='CertificateDetailCsr']")
	WebElement CsrField;
	
	@FindBy(xpath = ".//*[@id='mainCertDetails']/a")
	WebElement DecodeCsrButton;
	
	/*******************Admin Tad*****************/
	@FindBy(xpath = ".//*[@class='tabbable v-margin5']/ul/li[2]/a")
	WebElement AdminTab;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminTitle']")
	WebElement AdminTitleField;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminContact']")
	WebElement AdminNameField;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminOrganisation']")
	WebElement AdminOrganisationField;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminFirstname']")
	WebElement AdminFirstNameField;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminLastname']")
	WebElement AdminLastNameField;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminEmail']")
	WebElement AdminEmailField;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminPhone']")
	WebElement AdminPhoneField;
	
	/**********Technical Tab*****************/
	@FindBy(xpath = ".//*[@id='CertificateMysslEditForm']/div[2]/div[2]/ul/li[3]/a")
	WebElement TechnicalTab;
	
	@FindBy(xpath = ".//*[@id='CertificateTechContact']")
	WebElement TechnicalNameField;
	
	@FindBy(xpath = ".//*[@id='CertificateTechOrganisation']")
	WebElement TechnicalOrganisationField;
	
	@FindBy(xpath = ".//*[@id='CertificateTechTitle']")
	WebElement TechTitleField;
	
	@FindBy(xpath = ".//*[@id='CertificateTechFirstname']")
	WebElement TechFirstNameField;
	
	@FindBy(xpath = ".//*[@id='CertificateTechLastname']")
	WebElement TechLastNameField;
	
	@FindBy(xpath = ".//*[@id='CertificateTechEmail']")
	WebElement TechEmailField;
	
	@FindBy(xpath = ".//*[@id='CertificateTechPhone']")
	WebElement TechPhoneField;
	
	
	
	/**********Organisation Tab*****************/
	@FindBy(xpath = ".//*[@id='CertificateMysslEditForm']/div[2]/div[2]/ul/li[4]/a")
	WebElement OrganisationTab;
	
	@FindBy(xpath = ".//*[@id='CertificateOrganisationLegalName']")
	WebElement OrganisationLegalNameField;
	
	@FindBy(xpath = ".//*[@id='CertificateOrganisationCategory']")
	WebElement OrganisationCategoryField;
	
	@FindBy(xpath = ".//*[@id='CertificateOrganisationRegistrationNumber']")
	WebElement OrganisationRegistrationNumberField;
	
	
	/**********Director Tab*****************/
	@FindBy(xpath = ".//*[@id='CertificateMysslEditForm']/div[2]/div[2]/ul/li[5]/a")
	WebElement DirectorTab;
	
	@FindBy(xpath = ".//*[@id='CertificateDirectorContact']")
	WebElement DirectorContactField;
	
	@FindBy(xpath = ".//*[@id='CertificateDirectorOrganisation']")
	WebElement DirectorOrganisationField;
	
	/**********Terms and Conditions Tab***********/
	@FindBy(css = "a[href*='#myssl-certificate-tncs']")
	WebElement TermsTab;
	
	@FindBy(xpath = ".//*[@id='CertificateAcceptTerms']")
	WebElement TermsCheckBox;
	
	/***************Admin Security Questions******/
	@FindBy(xpath = ".//*[@id='CertificateAdminQuestion1']")
	WebElement AdminFavouriteColourQuestionField;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminQuestion2']")
	WebElement AdminFavouriteVegetableQuestionField;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminQuestion3']")
	WebElement AdminFavouriteBookQuestionField;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminQuestion4']")
	WebElement AdminFavouriteSportQuestionField;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminQuestion5']")
	WebElement AdminStreetNameQuestionField;
	
	
	/***************Tech Security Questions******/
	@FindBy(xpath = ".//*[@id='CertificateTechQuestion1']")
	WebElement TechFavouriteColourQuestionField;
	
	@FindBy(xpath = ".//*[@id='CertificateTechQuestion2']")
	WebElement TechFavouriteVegetableQuestionField;
	
	@FindBy(xpath = ".//*[@id='CertificateTechQuestion3']")
	WebElement TechFavouriteBookQuestionField;
	
	@FindBy(xpath = ".//*[@id='CertificateTechQuestion4']")
	WebElement TechFavouriteSportQuestionField;
	
	@FindBy(xpath = ".//*[@id='CertificateTechQuestion5']")
	WebElement TechStreetNameQuestionField;
	
	
	/***************Director Security Questions******/
	@FindBy(xpath = ".//*[@id='CertificateDirectorQuestion1']")
	WebElement DirectorFavouriteColourQuestionField;
	
	@FindBy(xpath = ".//*[@id='CertificateDirectorQuestion2']")
	WebElement DirectorFavouriteVegetableQuestionField;
	
	@FindBy(xpath = ".//*[@id='CertificateDirectorQuestion3']")
	WebElement DirectorFavouriteBookQuestionField;
	
	@FindBy(xpath = ".//*[@id='CertificateDirectorQuestion4']")
	WebElement DirectorFavouriteSportQuestionField;
	
	@FindBy(xpath = ".//*[@id='CertificateDirectorQuestion5']")
	WebElement DirectorStreetNameQuestionField;
	
	
	
	
	@FindBy(xpath = ".//*[@id='CertificateMysslEditForm']/div[2]/div[1]/button")
	WebElement SubmitCertForIssuanceButton;
	
	
	/********CSR*****************
	
	@FindBy(xpath = ".//*[@id='CertificateMysslViewForm']/div[2]/div[1]/div/button")
	WebElement ValidateCsrButton;
	
	@FindBy(xpath = ".//*[@class='stdContentWrapper']/div[1]/div[1]/div/div/div[2]/div/div[2]/a")
	WebElement ReIssueButton;
	
	@FindBy(xpath = ".//*[@id='CertificateMysslReissueForm']/fieldset/button")
	WebElement ReIssueCertificateButton;
	*/

	
	public Admin_CertificateValidationPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	
	public void CertificatesDetailsTabClick(){
		
		//CertificatesDetailsTab.click();
		
		CertificateDetailsTab.click();
		
	}
	
	public void CsrFieldClick(){
		
		CsrField.click();
		
		CsrField.clear();
		
	}
	
	public void DecodeCsrButtonClick(){
		
		DecodeCsrButton.click();
		
	}
	
	public void AdminTabClick(){
		
		AdminTab.click();
		
	}
	
	public void AdminNameFieldSelect(String Name){
		
		Select AdminName = new Select(AdminNameField);
		AdminName.selectByVisibleText(Name);
		
	}
	
	public void AdminTitleField_Select(String Initials){
		
		Select AdminName = new Select(AdminTitleField);
		AdminName.selectByVisibleText(Initials);
		
	}
	
	public void AdminOrganisationFieldFill(String name){
		
		AdminOrganisationField.clear();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		AdminOrganisationField.sendKeys(name);
	}
	
	public void AdminFirstNameField_Sendkeys(String FirstName){
		
		AdminFirstNameField.clear();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		AdminFirstNameField.sendKeys(FirstName);
	}
	
	public void AdminLastNameField_Sendkeys(String LastName){
		
		AdminLastNameField.clear();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		AdminLastNameField.sendKeys(LastName);
	}
	
	public void AdminEmailField_Sendkeys(String Email){
		
		AdminEmailField.clear();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		AdminEmailField.sendKeys(Email);
	}
	
	public void AdminPhoneField_Sendkeys(String PhoneNumber){
		
		AdminPhoneField.clear();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		AdminPhoneField.sendKeys(PhoneNumber);
	}
	
	
	public void TechnicalTabClick(){
		
		TechnicalTab.click();
		
	}
	
	public void TechnicalNameFieldSelect(String Name){
		
		Select TechnicalName = new Select(TechnicalNameField);
		TechnicalName.selectByVisibleText(Name);
		
	}
	
	public void TechnicalOrganisationFieldFill(String name){
		
		TechnicalOrganisationField.clear();
		TechnicalOrganisationField.sendKeys(name);
	}
	
	public void TechTitleField_Select(String Initials){
		
		Select TechName = new Select(TechTitleField);
		TechName.selectByVisibleText(Initials);
		
	}

	public void TechFirstNameField_Sendkeys(String FirstName){
		
		TechFirstNameField.clear();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		TechFirstNameField.sendKeys(FirstName);
	}
	
	public void TechLastNameField_Sendkeys(String LastName){
		
		TechLastNameField.clear();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		TechLastNameField.sendKeys(LastName);
	}
	
	public void TechEmailField_Sendkeys(String Email){
		
		TechEmailField.clear();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		TechEmailField.sendKeys(Email);
	}
	
	public void TechPhoneField_Sendkeys(String PhoneNumber){
		
		TechPhoneField.clear();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		TechPhoneField.sendKeys(PhoneNumber);
	}
	
	public void OrganisationTabClick(){
		
		OrganisationTab.click();
		
	}
	
	public void OrganisationLegalNameFieldFill(String name){
		
		OrganisationLegalNameField.clear();
		OrganisationLegalNameField.sendKeys(name);
	}
	
	public void OrganisationCategoryFieldSelect(String Name){
		
		Select OrganisationCategory = new Select(OrganisationCategoryField);
		OrganisationCategory.selectByVisibleText(Name);
		
	}
	
	public void OrganisationRegistrationNumberFieldFill(String name){
		
		OrganisationRegistrationNumberField.clear();
		OrganisationRegistrationNumberField.sendKeys(name);
	}
	
	public void DirectorTabClick(){
		
		DirectorTab.click();
		
	}
	
	public void DirectorContactFieldSelect(String Name){
		
		Select DirectorContact = new Select(DirectorContactField);
		DirectorContact.selectByVisibleText(Name);
		
	}
	
	public void DirectorOrganisationFieldFill(String name){
		
		DirectorOrganisationField.clear();
		DirectorOrganisationField.sendKeys(name);
	}
/*	
	public void ValidateCsrButton(){
		
		ValidateCsrButton.click();
		
	}
*/	
	public void CsrFieldFill(String name){
		
		CsrField.sendKeys(name);
	}
	
	public void HitEnterKey(){
		
		CsrField.sendKeys(Keys.ENTER);
	}
	
	
	public void AdminFavouriteColourQuestionFieldFill(String Question){
		
		AdminFavouriteColourQuestionField.clear();
		AdminFavouriteColourQuestionField.sendKeys(Question);
	}
	
	public void AdminFavouriteVegetableQuestionFieldFill(String Question){
		
		AdminFavouriteVegetableQuestionField.clear();
		AdminFavouriteVegetableQuestionField.sendKeys(Question);
	}
	
	public void AdminFavouriteBookQuestionFieldFill(String Question){
		
		AdminFavouriteBookQuestionField.clear();
		AdminFavouriteBookQuestionField.sendKeys(Question);
	}
	
	public void AdminFavouriteSportQuestionFieldFill(String Question){
		
		AdminFavouriteSportQuestionField.clear();
		AdminFavouriteSportQuestionField.sendKeys(Question);
	}
	
	public void AdminStreetNameQuestionFieldFill(String Question){
		
		AdminStreetNameQuestionField.clear();
		AdminStreetNameQuestionField.sendKeys(Question);
	}
	
	
	public void TechFavouriteColourQuestionFieldFill(String Question){
		
		TechFavouriteColourQuestionField.clear();
		TechFavouriteColourQuestionField.sendKeys(Question);
	}
	
	public void TechFavouriteVegetableQuestionFieldFill(String Question){
		
		TechFavouriteVegetableQuestionField.clear();
		TechFavouriteVegetableQuestionField.sendKeys(Question);
	}
	
	public void TechFavouriteBookQuestionFieldFill(String Question){
		
		TechFavouriteBookQuestionField.clear();
		TechFavouriteBookQuestionField.sendKeys(Question);
	}
	
	public void TechFavouriteSportQuestionFieldFill(String Question){
		
		TechFavouriteSportQuestionField.clear();
		TechFavouriteSportQuestionField.sendKeys(Question);
	}
	
	public void TechStreetNameQuestionFieldFill(String Question){
		
		TechStreetNameQuestionField.clear();
		TechStreetNameQuestionField.sendKeys(Question);
	}
	
	
	public void DirectorFavouriteColourQuestionFieldFill(String Question){
		
		DirectorFavouriteColourQuestionField.clear();
		DirectorFavouriteColourQuestionField.sendKeys(Question);
	}
	
	public void DirectorFavouriteVegetableQuestionFieldFill(String Question){
		
		DirectorFavouriteVegetableQuestionField.clear();
		DirectorFavouriteVegetableQuestionField.sendKeys(Question);
	}
	
	public void DirectorFavouriteBookQuestionFieldFill(String Question){
		
		DirectorFavouriteBookQuestionField.clear();
		DirectorFavouriteBookQuestionField.sendKeys(Question);
	}
	
	public void DirectorFavouriteSportQuestionFieldFill(String Question){
		
		DirectorFavouriteSportQuestionField.clear();
		DirectorFavouriteSportQuestionField.sendKeys(Question);
	}
	
	public void DirectorStreetNameQuestionFieldFill(String Question){
		
		DirectorStreetNameQuestionField.clear();
		DirectorStreetNameQuestionField.sendKeys(Question);
	}
	
	
	
	public void SubmitCertForIssuanceButtonClick(){
		
		SubmitCertForIssuanceButton.click();
	}
	
	public void TermsTabClick(){
		
		TermsTab.click();
		
	}
	
	public void TermsCheckBoxTick(){
		
		TermsCheckBox.click();
		
	}
	
	
	public void LoadSsl247_TestCsR () throws Exception {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C://Users//Gideon Okunleye//workspace//AutomationTestScripts//DataDriving.properties");
				 
		prop.load(fis);
		
		CsrFieldFill(prop.getProperty("Ssl-test1"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test2"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test3"));
		HitEnterKey();;
		CsrFieldFill(prop.getProperty("Ssl-test4"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test5"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test6"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test7"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test8"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test9"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test10"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test11"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test12"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test13"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test14"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test15"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test16"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test17"));
		HitEnterKey();
	
	}
/*	
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
*/	
}
