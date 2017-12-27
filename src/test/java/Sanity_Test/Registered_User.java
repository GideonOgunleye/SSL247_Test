package Sanity_Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilities.AlertBox;
import BaseUtilities.BrowserStack;
import BaseUtilities.Chrome;
import BaseUtilities.Chrome2;
import BaseUtilities.CsR;
import BaseUtilities.DriverLoad;
import BaseUtilities.ExtentFactory;
import BaseUtilities.TakeScreenShot;
import PageFactory.Client.Client_AddToBasketPage;
import PageFactory.Client.Client_BillingPage;
import PageFactory.Client.Client_CertificateDetailsPage;
import PageFactory.Client.Client_CertificateValidationPage;
import PageFactory.Client.Client_DomainNamesEditPage;
import PageFactory.Client.Client_EditUserPage;
import PageFactory.Client.Client_IssuedCertificatesPage;
import PageFactory.Client.Client_LoginPage;
import PageFactory.Client.Client_MyProductsPage;
import PageFactory.Client.Client_MySslDashBoard;
import PageFactory.Client.Client_MyUsersPage;
import PageFactory.Client.Client_NavigationLinks;
import PageFactory.Client.Client_NewUserPage;
import PageFactory.Client.Client_PendingCertificatesPage;
import PageFactory.Client.Client_RegisterDomainPage;
import PageFactory.Client.Client_ShoppingBasketPage;
import PageFactory.Client.Client_ViewOrderPage;
import Regression_Test.Test_Data;

import org.testng.annotations.BeforeTest;
//import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeMethod;

public class Registered_User extends BrowserStack  {
	
	ExtentReports report;
	ExtentTest test;
	Client_LoginPage 	Client_LoginPageElements;
	Client_BillingPage Client_BillingPageElements;
	Client_MySslDashBoard Client_MySslDashBoardElements;
	CsR CsrElements;
	Client_NavigationLinks Client_NavigationLinksElements;
	AlertBox AlertBoxElements;
	TakeScreenShot ScreenShot;
	Client_IssuedCertificatesPage Clients_IssuedCertificatesPageElements;
	Client_CertificateDetailsPage Client_CertificateDetailsPageElements;
	Client_MyProductsPage Client_MyProductsPageElements;
	Client_AddToBasketPage Client_AddToBasketPageElements;
	Client_ShoppingBasketPage  Client_ShoppingBasketPageElements;
	Client_ViewOrderPage Client_ViewOrderPageElements;
	Client_CertificateValidationPage Client_CertificateValidationPageElements;
	Client_PendingCertificatesPage Client_PendingCertificatesPageElements;
	Client_MyUsersPage Client_MyUsersPageElements;
	Client_NewUserPage Client_NewUserPageElements;
	Client_EditUserPage Client_EditUserPageElements;
	Client_RegisterDomainPage Client_RegisterDomainPageElements;
	Client_DomainNamesEditPage Client_DomainNamesEditPageElements;

	
	@BeforeMethod (groups = {"Sanity","Smoke","BS_Smoke","BS_Sanity","BS_Sanity","BS_DailySanity","Smoke_Firefox","Smoke_Chrome","Sanity_Chrome"})
	public void Login () throws Exception {
		
		report = ExtentFactory.getInstance(); 
		Client_LoginPageElements = new Client_LoginPage(driver);
		Client_BillingPageElements = new Client_BillingPage(driver);
		Client_MySslDashBoardElements = new Client_MySslDashBoard(driver);
		CsrElements = new CsR(driver);
		Client_NavigationLinksElements = new Client_NavigationLinks(driver);
		AlertBoxElements = new AlertBox(driver);
		Clients_IssuedCertificatesPageElements = new Client_IssuedCertificatesPage(driver);
		Client_CertificateDetailsPageElements = new Client_CertificateDetailsPage(driver);
		ScreenShot = new TakeScreenShot();
		Client_MyProductsPageElements = new Client_MyProductsPage (driver);
		Client_AddToBasketPageElements = new Client_AddToBasketPage (driver);
		Client_ShoppingBasketPageElements = new Client_ShoppingBasketPage (driver);
		Client_ViewOrderPageElements = new Client_ViewOrderPage(driver);
		Client_CertificateValidationPageElements = new Client_CertificateValidationPage(driver);
		Client_PendingCertificatesPageElements = new Client_PendingCertificatesPage(driver);
		Client_MyUsersPageElements = new Client_MyUsersPage(driver);
		Client_NewUserPageElements = new Client_NewUserPage(driver);
		Client_EditUserPageElements = new Client_EditUserPage(driver);
		Client_RegisterDomainPageElements = new Client_RegisterDomainPage(driver);
		Client_DomainNamesEditPageElements = new Client_DomainNamesEditPage(driver);
		 
		
		
		Client_LoginPageElements.ClientLogin();
		
		Thread.sleep(5000);		
	}

	
	@AfterMethod (groups = {"Sanity","Smoke","BS_Smoke","BS_Sanity","BS_DailySanity", "BS_Sanity","Smoke_Firefox","Smoke_Chrome","Sanity_Chrome"}, alwaysRun = true)
	public void Logout (ITestResult result) throws Exception {

	    //Take Screen Shots
				
	  	String path =  ScreenShot.Image(driver, "TestSecreenShot-" + result.getMethod().getMethodName());
		String imagePath = test.addScreenCapture(path);
		test.log(LogStatus.INFO, "Test Complete", imagePath);
		
		driver.navigate().refresh();
		
		Thread.sleep(5000);
		
		try{
			
			Client_LoginPageElements.ClickLogoutButton();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "User Logged Out");
			String path2 = ScreenShot.Image(driver, "Logout");
			String imagePath2 = test.addScreenCapture(path2);
			test.log(LogStatus.INFO, imagePath2);
			report.endTest(test);
			report.flush();
		
		}catch (Exception e) {
			
			test.log(LogStatus.FAIL, "Logout Failed");
			String path2 = ScreenShot.Image(driver, "Logout");
			String imagePath2 = test.addScreenCapture(path2);
			test.log(LogStatus.INFO, imagePath2);
			report.endTest(test);
			report.flush();
			//Assert.fail("Exception " + e);
		}
		
		//return destination;
		
	}
	

	
	@Test (priority = 1, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
	  public void Order_RapidSSL() throws Exception {
		 

		System.out.println("Order Cert Started!");
		
		test = report.startTest("Registered User Test --> Order_RapidSSL");
	    test.log(LogStatus.INFO, "User Logged in");
	    
	    Thread.sleep(1000);
	    
	    //Navigate to product page//
		
		 try {
			 
			    //Click to Order RapidSSL Product
				Client_MySslDashBoardElements.ClickMyProductsLink();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Clicked on my product link");
				
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,800)", "");
				Thread.sleep(15000);
				
				Client_MyProductsPageElements.Link16_Button1Clink();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Click on RapidSSL Product");
			 
		 }catch (Exception e) {
			 
				test.log(LogStatus.FAIL, "Element Not Found");
				test.log(LogStatus.INFO, e);
				System.out.println("Element Not Found");
				String path2 = ScreenShot.Image(driver, "Element");
				String imagePath2 = test.addScreenCapture(path2);
				test.log(LogStatus.INFO, imagePath2);
				report.endTest(test);
				report.flush();
				Assert.fail("Exception " + e);
			 
		 }
		
		Thread.sleep(1000);
		
		//Check Domain Name

		
		 try {
			 
				Client_AddToBasketPageElements.CommonNameField_SendKeys("ssl247.co.uk");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Entered common name");
				
				
				Client_AddToBasketPageElements.CheckButton_Clink();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Clicked on Check Button");
				
				Thread.sleep(10000);
				
				Client_AddToBasketPageElements.NoButton_Clink();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Clicked On No Button");		
				
				//Choose 3year Duration Option
				Client_AddToBasketPageElements.ThreeYears_RadioButton_Clink();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Clicked On Three Years Option");
					
				Client_AddToBasketPageElements.AddToBasketButton_Clink();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Clicked on Add to Basket Button");
			 
		 }catch (Exception e) {
			 
				test.log(LogStatus.FAIL, "Element Not Found");
				test.log(LogStatus.INFO, e);
				System.out.println("Element Not Found");
				String path2 = ScreenShot.Image(driver, "Element");
				String imagePath2 = test.addScreenCapture(path2);
				test.log(LogStatus.INFO, imagePath2);
				report.endTest(test);
				report.flush();
				Assert.fail("Exception " + e);
			 
		 }
		
		
		Thread.sleep(10000);
		
		 try {
			 
				//Confirm Order Details
				Client_ShoppingBasketPageElements.ConfirmOrderDetailsButton_Clink();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Clicked on Confirm Details Button");
				
				//Fill In Billing Retails
				System.out.println("Start Billing Page");
				
				Client_BillingPageElements.FillFirstname("Quality");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Filled First Name");
				
				Client_BillingPageElements.FillLastname("Assurance Tester");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Filled Last Name");
				
				Client_BillingPageElements.FillPhoneNumber("0203MMM7610541");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Filled Phone Number");
				
				Client_BillingPageElements.FillEmail("qa@ssl247.co.uk");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Filled Email");
				
				Client_BillingPageElements.FillAddress1("63 Lisson St, Marylebone");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Filled Address 1");
				
				Client_BillingPageElements.FillCity("London");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Filled City");
				
				Client_BillingPageElements.SelectCountry("United Kingdom");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Selected Country");
				
				Client_BillingPageElements.FillPostcode("NW1 5DD");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Filled Postcode");
				
				//Confirm input
				Client_BillingPageElements.ClickConfirmButton();
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Clicked Confirm Button");
			 
		 }catch (Exception e) {
			 
				test.log(LogStatus.FAIL, "Element Not Found");
				test.log(LogStatus.INFO, e);
				System.out.println("Element Not Found");
				String path2 = ScreenShot.Image(driver, "Element");
				String imagePath2 = test.addScreenCapture(path2);
				test.log(LogStatus.INFO, imagePath2);
				report.endTest(test);
				report.flush();
				Assert.fail("Exception " + e);
			 
		 }
		

		
		try {	
			/*----Complete Order----*/
			
			if (Client_ViewOrderPageElements.PageHeader_GetText().contains("View Order")) {
				
				test.log(LogStatus.PASS, "View Order Page Opened");
				
			}else {
				
				test.log(LogStatus.FAIL, "View Order Page NOT Opened");
				Assert.fail("View Order Page NOT Opened");
				String path2 = ScreenShot.Image(driver, "Element");
				String imagePath2 = test.addScreenCapture(path2);
				test.log(LogStatus.INFO, imagePath2);
				report.endTest(test);
				report.flush();
			}
			
			
			Client_ViewOrderPageElements.CompleteOrderButton_Clink();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked Click Complete Button");
	
			Thread.sleep(1000);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,500)", "");
			
			CsrElements.LoadCsR();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Entered CSR");
			
			CsrElements.ClickDecoder();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked Decoder Button");
			
			Thread.sleep(10000);
			
			CsrElements.ClickDecoderPopUp();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked Decoder Pop Up");
			
			Thread.sleep(10000);
				
			System.out.println("Sleep Over");
			
			
			//JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,-500)", "");
			
			
			Thread.sleep(10000);
			
			/*-----Fillm in Admin Tab-----------------------*/
			
			
			Client_CertificateValidationPageElements.AdminTabClick();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked Admin Tab");
		    System.out.println("Admin Tab Clicked");
		   	
		    Client_CertificateValidationPageElements.AdminOrganisationFieldFill("SSL247 Ltd");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Organisation Field");
			
			Client_CertificateValidationPageElements.AdminTitleField_Select("Dr");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Seleted Title Field");
			
			Client_CertificateValidationPageElements.AdminFirstNameField_Sendkeys("Gideon");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin First Name");
			
			Client_CertificateValidationPageElements.AdminLastNameField_Sendkeys("Ogunleye");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin Last Name");
			
			Client_CertificateValidationPageElements.AdminEmailField_Sendkeys("qa@ssl247.co.uk");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin Email");
			
			Client_CertificateValidationPageElements.AdminPhoneField_Sendkeys("02037610541");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Fill Admin Phone Number");
			
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			
			/*-----Fill in Tech Tab-----------------------------*/
			Client_CertificateValidationPageElements.TechnicalTabClick();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked Tech Tab");
			
			Client_CertificateValidationPageElements.TechnicalOrganisationFieldFill("SSL247 Ltd");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Tech Organization");
			
			Client_CertificateValidationPageElements.TechTitleField_Select("Dr");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Selected Tech Title Field");
			
			Client_CertificateValidationPageElements.TechFirstNameField_Sendkeys("Gideon");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Tech First Name");
			
			Client_CertificateValidationPageElements.TechLastNameField_Sendkeys("Ogunleye");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Tech Last Name");
			
			Client_CertificateValidationPageElements.TechEmailField_Sendkeys("qa@ssl247.co.uk");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Tech Email");
			
			Client_CertificateValidationPageElements.TechPhoneField_Sendkeys("02037610541");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Tech Phone Number");
			
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			
			/*-----Click on Submit Button--------*/
			
			Client_CertificateValidationPageElements.SubmitCertForIssuanceButtonClick();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked Submit button");
		
		}catch (Exception e) {
			
			test.log(LogStatus.FAIL, "Validation Failed");
			test.log(LogStatus.INFO, e);
			String path = ScreenShot.Image(driver, "TestScreenshot");
			String imagePath = test.addScreenCapture(path);;
			test.log(LogStatus.INFO, imagePath);
			
			//Assert.fail("Exception " + e);

		}
		
		 try {
			 
			 if (Client_PendingCertificatesPageElements.PageHeader().contains("Pending Certificates")) {
				 
				 test.log(LogStatus.PASS, "Validation Complete");
				 
			 }else {
				 
				 test.log(LogStatus.FAIL, "Validation Failed");
				 Assert.fail("Validation Failed");
			 }
			 
		 }catch (Exception e) {
			 
				test.log(LogStatus.FAIL, "Element Not Found");
				test.log(LogStatus.INFO, e);
				System.out.println("Element Not Found");
				String path2 = ScreenShot.Image(driver, "Element");
				String imagePath2 = test.addScreenCapture(path2);
				test.log(LogStatus.INFO, imagePath2);
				report.endTest(test);
				report.flush();
				Assert.fail("Exception " + e);
			 
		 }	
		
	 }
	
	@Test (priority = 2, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="CreateUser")
	  public void Create_User(String Firstname, String Lastname, String Email, String PhoneNumber, String Address, String State, String Postcode, String CountryNm) throws Exception {
		 

		System.out.println("Create User Started!");
		test = report.startTest("Registered User Test --> Create User" + Email);
	    test.log(LogStatus.INFO, "User Logged in");
		

		
		
		 try {
			 
				//1-Navigate and click on My Users
				Client_MySslDashBoardElements.ClickMyUsersLink();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "My End Users Page Opened");
				
				Thread.sleep(5000);
				
				//2-Navigate and Click on New Users
				
				Client_MyUsersPageElements.NewUserButton_Clink();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "New User Form Opened");
			 
		 }catch (Exception e) {
			 
				test.log(LogStatus.FAIL, "Element Not Found");
				test.log(LogStatus.INFO, e);
				System.out.println("Element Not Found");
				String path2 = ScreenShot.Image(driver, "Element");
				String imagePath2 = test.addScreenCapture(path2);
				test.log(LogStatus.INFO, imagePath2);
				report.endTest(test);
				report.flush();
				Assert.fail("Exception " + e);
			 
		 }
		
		
		//3-Fill In Form With Required Information
		
		Thread.sleep(5000);
		
		 try {
			 
				Client_NewUserPageElements.RoleSelectField_Select("1");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Selected Role");
				
				Client_NewUserPageElements.AccessLevelSelectField_Select("Super User");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Selected Access Control Level");
				
				Client_NewUserPageElements.FirstNameField_SendKeys(Firstname);
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Entered First Name");
				
				Client_NewUserPageElements.LastNameField_SendKeys(Lastname);
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Entered Last Name");
				
				Client_NewUserPageElements.EmailField_SendKeys(Email);
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Entered Email");
				
				Client_NewUserPageElements.PhoneField_SendKeys(PhoneNumber);
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Entered Phone Number");
				
				Client_NewUserPageElements.AddressOneField_SendKeys(Address);
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Entered Address One Field");
				
				Client_NewUserPageElements.StateField_SendKeys(State);
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Entered State");
				
				Client_NewUserPageElements.PostCodeField_SendKeys(Postcode);
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Entered Postcode");
				
				Client_NewUserPageElements.CountrySelectField_Select(CountryNm);
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Selected Country Name");
				
				
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,-900)", "");
				
				Thread.sleep(2000);
				
				Client_NewUserPageElements.SaveUserButton_Click();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Clicked On Save User Button");
			 
			 
		 }catch (Exception e) {
			 
				test.log(LogStatus.FAIL, "Element Not Found");
				test.log(LogStatus.INFO, e);
				System.out.println("Element Not Found");
				String path2 = ScreenShot.Image(driver, "Element");
				String imagePath2 = test.addScreenCapture(path2);
				test.log(LogStatus.INFO, imagePath2);
				report.endTest(test);
				report.flush();
				Assert.fail("Exception " + e);
			 
		 }
		 
		 
		
		
		 try {
			 
			 if (Client_NewUserPageElements.PageHeader_GetText().contains("My Users")) {
				 
				 test.log(LogStatus.PASS, "New User Form Filled and Saved"); 
				 System.out.println("Create User Completed!");
				 
			 }else {
				 
				 test.log(LogStatus.FAIL, "New User Form not saved");
				 System.out.println(Client_NewUserPageElements.PageHeader_GetText());
				 Assert.fail("New User Form not saved");
			 }
			 
		 }catch (Exception e) {
			 
				test.log(LogStatus.FAIL, "Element Not Found");
				test.log(LogStatus.INFO, e);
				System.out.println("Element Not Found");
				String path2 = ScreenShot.Image(driver, "Element");
				String imagePath2 = test.addScreenCapture(path2);
				test.log(LogStatus.INFO, imagePath2);
				report.endTest(test);
				report.flush();
				Assert.fail("Exception " + e);
			 
		 }
		
		
		
	}   
	
	@Test (priority = 3, groups = {"Sanity","BS_Sanity","Sanity_Chrome"}) 
	  public void Edit_User () throws Exception {
		

		System.out.println("Edit User Started!");
		
		test = report.startTest("Registered User Test --> Edit Users");
	    test.log(LogStatus.INFO, "User Logged in");
	    

	    
		 try {
			 
				//Navigate to User Profiles
				Client_MySslDashBoardElements.ClickMyUsersLink();
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			    test.log(LogStatus.INFO, "Clicked My Users Link");
				
				//Edit User Profile
				Thread.sleep(15000);
				
				Client_MyUsersPageElements.User3_EditButton_Clink();
				//driver.findElement(By.xpath(".//*[@id='mainContainer']/div[4]/div[2]/div[2]/div[3]/div/address/div/a[1]")).click();
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			    test.log(LogStatus.INFO, "Clicked Edit Button for Tester");
			 
		 }catch (Exception e) {
			 
				test.log(LogStatus.FAIL, "Element Not Found");
				test.log(LogStatus.INFO, e);
				System.out.println("Element Not Found");
				String path2 = ScreenShot.Image(driver, "Element");
				String imagePath2 = test.addScreenCapture(path2);
				test.log(LogStatus.INFO, imagePath2);
				report.endTest(test);
				report.flush();
				Assert.fail("Exception " + e);
			 
		 }
	    
		Thread.sleep(10000);
		

		
		 try {
			 
				Client_EditUserPageElements.UserDetailsTab_Click();
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Clicked Clicked User Details Tab");
				
				Client_EditUserPageElements.LanguageSelectField_SelectByText("English");
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Selected Language");
				
				Client_EditUserPageElements.RoleSelectField_SelectByIndex(0);
				//WebElement address = driver.findElement(By.xpath(".//*[@id='UserRole']"));
				//Select Role = new Select(address);
				//Role.selectByIndex(0);
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Selected User Role");
				
				Client_EditUserPageElements.FirstNameField_SendKeys("Gideon");
				//driver.findElement(By.name("data[User][firstname]")).clear();
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			    test.log(LogStatus.INFO, "Entered First Name");
			    
			    Client_EditUserPageElements.LastNameField_SendKeys("Ogunleye");
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			    test.log(LogStatus.INFO, "Entered Last Name");
				
			    Client_EditUserPageElements.PhoneField_SendKeys("02037610541");
				//driver.findElement(By.name("data[User][phone]")).sendKeys("02037610541");
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			    test.log(LogStatus.INFO, "Entered Phone Number");
				
			    
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,-500)", "");
				Thread.sleep(100);
			 
		 }catch (Exception e) {
			 
				test.log(LogStatus.FAIL, "Element Not Found");
				test.log(LogStatus.INFO, e);
				System.out.println("Element Not Found");
				String path2 = ScreenShot.Image(driver, "Element");
				String imagePath2 = test.addScreenCapture(path2);
				test.log(LogStatus.INFO, imagePath2);
				report.endTest(test);
				report.flush();
				Assert.fail("Exception " + e);
			 
		 }
		 
		 
		 try {
			 
				Client_EditUserPageElements.AdditionalDetailsTab_Click();	
				//driver.findElement(By.xpath(".//*[@id='UserMysslEditForm']/div[3]/ul/li[2]/a")).click();
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Clicked Additional Details Tab");
				
				Thread.sleep(100);
				
				Client_EditUserPageElements.StateField_SendKeys("London");
				//driver.findElement(By.xpath(".//*[@id='UserState']")).sendKeys("London");
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Entered State");
				
				Client_EditUserPageElements.SubmitChangesButton_Click();
				//driver.findElement(By.xpath(".//*[@id='UserMysslEditForm']/div[2]/button")).click();
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Clicked Submit Changes Button");
				    
				//Take Screenshot
				String path = ScreenShot.Image(driver, "Edit User");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.PASS, "Form Submitted");
				test.log(LogStatus.INFO, imagePath);
				
			 
		 }catch (Exception e) {
			 
				test.log(LogStatus.FAIL, "Element Not Found");
				test.log(LogStatus.INFO, e);
				System.out.println("Element Not Found");
				String path2 = ScreenShot.Image(driver, "Element");
				String imagePath2 = test.addScreenCapture(path2);
				test.log(LogStatus.INFO, imagePath2);
				report.endTest(test);
				report.flush();
				Assert.fail("Exception " + e);
			 
		 }

		
		 //Test Validation
			try {
				
				String PageHeader = "My Users";  
						    	
			  if (Client_EditUserPageElements.PageHeader_GetText().contains(PageHeader)) {
									
				test.log(LogStatus.PASS, "Validation Complete");
				System.out.println("Validation Complete!");
				
			  }else{
						    	
				test.log(LogStatus.FAIL, "Validation Failed");
				System.out.println(Client_EditUserPageElements.PageHeader_GetText());
				Assert.fail("Validation Failed ");
						    	
				}
				
			}catch (Exception e) {
									
				test.log(LogStatus.FATAL, e);

			}
		
	}	

	
	@Test (priority = 5, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
	public void Domain_Name_Ordering () throws Exception {
	
		//TODO
		System.out.println("Domain Name Order Started!");
		
		test = report.startTest("Registered User Test --> Domain Name Ordering");
	    test.log(LogStatus.INFO, "User Logged in");
		
		//Navigate Domain Names Link on side bar
	    Client_MySslDashBoardElements.ClickMyDomainNamesLink();
	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Clicked on Domain Name Link"); 
	    
	    Client_MySslDashBoardElements.ClickRegisterDomainLink();
	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Clicked on register domain link");
			
		//Enter Domain Name to check availability
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		
		Client_RegisterDomainPageElements.SearchField_SendKeys("ssl247test.net");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Entered Domain Name in Search Field");
		
	    Client_RegisterDomainPageElements.CheckAvailabilityButton_Click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Clicked on search button");
		
		Thread.sleep(10000);
		
		try {
			
			String DomainName = "ssl247test.net";
			String Available = "Available";
			
			if (Client_RegisterDomainPageElements.SearchResult_column_1_DomainName_GetText().contains(DomainName)) {
				
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			    test.log(LogStatus.PASS, "Domain name valid");
				
			}else {
				
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			    test.log(LogStatus.FAIL, "Domain name not valid");
			    Assert.fail("Domain name not valid");
			}
			
			
			
			if (Client_RegisterDomainPageElements.SearchResult_column_1_Availibity_GetText().contains(Available)) {
				
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			    test.log(LogStatus.PASS, "Domain name Available");
				System.out.println("Domain Name is Avalable");
				
				Client_RegisterDomainPageElements.SearchResult_column_1_CheckBox_Click();
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			    test.log(LogStatus.INFO, "Clicked on Column One Checkbox");
				
			    Client_RegisterDomainPageElements.AddToBasketButton_Click();
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			    test.log(LogStatus.INFO, "Clicked on Add to Basket Button");
				
			}else {
				
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			    test.log(LogStatus.FAIL, "Domain name Not Available");
			    Assert.fail("Domain name Not Available");
			    
			}
			
		}catch (Exception e){
			
			test.log(LogStatus.FAIL, "Element Not Found");
			System.out.println("Element Not Found");
			String path2 = ScreenShot.Image(driver, "Element");
			String imagePath2 = test.addScreenCapture(path2);
			test.log(LogStatus.INFO, imagePath2);
			report.endTest(test);
			report.flush();
			System.out.println("Exception" + e);
			Assert.fail("Exception " + e);
			
		}
				
				
		//Confirm Basket
		Thread.sleep(15000);
		
		 try {
			 
				//Confirm Order Details
				Client_ShoppingBasketPageElements.ConfirmOrderDetailsButton_Clink();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Clicked on Confirm Details Button");
				
				//Fill In Billing Retails
				System.out.println("Start Billing Page");
				
				Client_BillingPageElements.FillFirstname("Quality");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Filled First Name");
				
				Client_BillingPageElements.FillLastname("Assurance Tester");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Filled Last Name");
				
				Client_BillingPageElements.FillPhoneNumber("0203MMM7610541");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Filled Phone Number");
				
				Client_BillingPageElements.FillEmail("qa@ssl247.co.uk");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Filled Email");
				
				Client_BillingPageElements.FillAddress1("63 Lisson St, Marylebone");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Filled Address 1");
				
				Client_BillingPageElements.FillCity("London");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Filled City");
				
				Client_BillingPageElements.SelectCountry("United Kingdom");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Selected Country");
				
				Client_BillingPageElements.FillPostcode("NW1 5DD");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Filled Postcode");
				
				//Confirm input
				Client_BillingPageElements.ClickConfirmButton();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Clicked Confirm Button");
			 
		 }catch (Exception e) {
			 
				test.log(LogStatus.FAIL, "Element Not Found");
				test.log(LogStatus.INFO, e);
				System.out.println("Element Not Found");
				String path2 = ScreenShot.Image(driver, "Element");
				String imagePath2 = test.addScreenCapture(path2);
				test.log(LogStatus.INFO, imagePath2);
				report.endTest(test);
				report.flush();
				Assert.fail("Exception " + e);
			 
		 }
			
		 Thread.sleep(5000);
			
				//Click Complete Button

				
				try {
					
					
					Client_ViewOrderPageElements.CompleteButton_Clink();
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					test.log(LogStatus.INFO, "Clicked on Complete Order Button");
					
				}catch (Exception e){
					
					test.log(LogStatus.FAIL, "Element Not Found");
					System.out.println("Element Not Found");
					String path2 = ScreenShot.Image(driver, "Element");
					String imagePath2 = test.addScreenCapture(path2);
					test.log(LogStatus.INFO, imagePath2);
					report.endTest(test);
					report.flush();
					System.out.println("Exception" + e);
					Assert.fail("Exception " + e);
					
				}
				
			
				//Click on Admin Tab
				
				Thread.sleep(5000);
								
				try {
					
					Client_DomainNamesEditPageElements.AdminTab_Clink();
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					test.log(LogStatus.INFO, "Clicked on Admin Tab");
					
					//Fill in the Required Information
					
					Client_DomainNamesEditPageElements.AdminTab_ContactSelectField_Select("Mr Gideon Ogunleye");
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					test.log(LogStatus.INFO, "Selected Admin Contact");
					
					Client_DomainNamesEditPageElements.AdminTab_DialingCodeField_SendKeys("475");
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					test.log(LogStatus.INFO, "Entered Diialing Code");
					
					System.out.println("Filled Admin Tab");	
					
					
				}catch (Exception e){
					
					test.log(LogStatus.FAIL, "Element Not Found");
					System.out.println("Element Not Found");
					String path2 = ScreenShot.Image(driver, "Element");
					String imagePath2 = test.addScreenCapture(path2);
					test.log(LogStatus.INFO, imagePath2);
					report.endTest(test);
					report.flush();
					System.out.println("Exception" + e);
					Assert.fail("Exception " + e);
					
				}
				
				
				//Click on Technical Tab
				
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,-500)", "");
				
				Thread.sleep(5000);
				
				try {
					
					Client_DomainNamesEditPageElements.TechnicalTab_Click();
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					test.log(LogStatus.INFO, "Clicked on Technical Tab");
					
					//Fill in Required Information
					
					Client_DomainNamesEditPageElements.TechnicalTab_ContactSelectField_Select("Mr Gideon Ogunleye");
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					test.log(LogStatus.INFO, "Selected Technical Contact");
					
					Client_DomainNamesEditPageElements.TechnicalTab_DialingCodeField_SendKeys("475");
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					test.log(LogStatus.INFO, "Entered Dialing Code");
					
				}catch (Exception e){
					
					test.log(LogStatus.FAIL, "Element Not Found");
					System.out.println("Element Not Found");
					String path2 = ScreenShot.Image(driver, "Element");
					String imagePath2 = test.addScreenCapture(path2);
					test.log(LogStatus.INFO, imagePath2);
					report.endTest(test);
					report.flush();
					System.out.println("Exception" + e);
					Assert.fail("Exception " + e);
					
				}
				
				//Click on Owner Tab
				
				//JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,-500)", "");
				Thread.sleep(5000);
				
				try {
					
					Client_DomainNamesEditPageElements.OwnerTab_Click();
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					test.log(LogStatus.INFO, "Clicked Owner Tab");
					
					//Fill in Required Information
					
					Client_DomainNamesEditPageElements.OwnerTab_ContactSelectField_Select("Mr Gideon Ogunleye");
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					test.log(LogStatus.INFO, "Clicked Owner Tab");
					
					Client_DomainNamesEditPageElements.OwnerTab_DialingCodeField_SendKeys("475");		
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					test.log(LogStatus.INFO, "Entered Dailing Code");
					
					
				}catch (Exception e){
					
					test.log(LogStatus.FAIL, "Element Not Found");
					System.out.println("Element Not Found");
					String path2 = ScreenShot.Image(driver, "Element");
					String imagePath2 = test.addScreenCapture(path2);
					test.log(LogStatus.INFO, imagePath2);
					report.endTest(test);
					report.flush();
					System.out.println("Exception" + e);
					Assert.fail("Exception " + e);
					
				}
				
				
						
				//Click on Save Changes
				
				jse.executeScript("window.scrollBy(0,-500)", "");
				
				Thread.sleep(5000);
				
				try {
					
					Client_DomainNamesEditPageElements.SaveChangesButton_Click();
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					test.log(LogStatus.INFO, "Clicked Save Changes Button");
					
					if (driver.getTitle().contains("Domain Names")) {
						
						driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						test.log(LogStatus.PASS, "Order Completed");
						
					}else {
						
						driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						test.log(LogStatus.FAIL, "Order Not Completed");
						String path2 = ScreenShot.Image(driver, "Element");
						String imagePath2 = test.addScreenCapture(path2);
						test.log(LogStatus.INFO, imagePath2);
						report.endTest(test);
						report.flush();
						Assert.fail();
						
					}
					
					
				}catch (Exception e){
					
					test.log(LogStatus.FATAL, "Element Not Found");
					System.out.println("Element Not Found");
					String path2 = ScreenShot.Image(driver, "Element");
					String imagePath2 = test.addScreenCapture(path2);
					test.log(LogStatus.INFO, imagePath2);
					report.endTest(test);
					report.flush();
					System.out.println("Exception" + e);
					Assert.fail("Exception " + e);
					
				}

		
	}
		
	@Test (priority = 3, groups = {"Sanity","BS_Sanity","BS_DailySanity"},dataProviderClass =Test_DataSanity.class, dataProvider="ReissueCertificate", enabled = false) 
	public void  Reissue_Certificate(String AdUsername, String Adpassword, String URL, String Account, String Product) throws Exception {
		
		System.out.println("Reissue Certificate Test Started!");
		
		test = report.startTest("Registered User Test --> Reissue Certificate: " + Product );
	    test.log(LogStatus.INFO, "User Logged in");
		

	    
		try {
			
			//Navigate Domain Names Link on side bar
		    Client_MySslDashBoardElements.MysslCertificatessLinkClick();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    test.log(LogStatus.INFO, "Clicked on My SSL Link");
		    
		    Client_MySslDashBoardElements.IssuedLinkClick();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    test.log(LogStatus.INFO, "Clicked on Issued Link");
			
		}catch (Exception e){
			
			test.log(LogStatus.FAIL, "Element Not Found");
			System.out.println("Element Not Found");
			String path2 = ScreenShot.Image(driver, "Element");
			String imagePath2 = test.addScreenCapture(path2);
			test.log(LogStatus.INFO, imagePath2);
			report.endTest(test);
			report.flush();
			System.out.println("Exception" + e);
			Assert.fail("Exception " + e);
			
		}
	    
	    try {
	    	
	    	if (Clients_IssuedCertificatesPageElements.Column1Contains(Product)) {
	    		
	    		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    	    test.log(LogStatus.INFO, "Column 1 Contains Products");
	    		
	    	    String path = ScreenShot.Image(driver, "Product");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);
	    	    
				//IssuedCertificatesPageElements.Column1TextPrint();
				
	    		Clients_IssuedCertificatesPageElements.Product1View();
	    		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    	    test.log(LogStatus.INFO, "Clicked to view product");
	    		
	    	    
	    		
	    		}else if (Clients_IssuedCertificatesPageElements.Column2Contains(Product)) {
	    			
	    			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    	    test.log(LogStatus.INFO, "Column 2 Contains Products");
		    	    
		    	    String path = ScreenShot.Image(driver, "Product");
					String imagePath = test.addScreenCapture(path);
					test.log(LogStatus.INFO, imagePath);
					
					//IssuedCertificatesPageElements.Column2TextPrint();
				
	    			Clients_IssuedCertificatesPageElements.Product2View();
	    			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    	    test.log(LogStatus.INFO, "Clicked to view product");
	    			
		    	}else if (Clients_IssuedCertificatesPageElements.Column3Contains(Product)) {
	    			
	    			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    	    test.log(LogStatus.INFO, "Column 3 Contains Products");
		    	    
		    	    String path = ScreenShot.Image(driver, "Product");
					String imagePath = test.addScreenCapture(path);
					test.log(LogStatus.INFO, imagePath);
					
					//IssuedCertificatesPageElements.Column3TextPrint();
				
	    			Clients_IssuedCertificatesPageElements.Product3View();
	    			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    	    test.log(LogStatus.INFO, "Clicked to view product");
    			
		    	}else if (Clients_IssuedCertificatesPageElements.Column4Contains(Product)) {
    			
		    		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    		test.log(LogStatus.INFO, "Column 4 Contains Products");
	    	    
		    		String path = ScreenShot.Image(driver, "Product");
		    		String imagePath = test.addScreenCapture(path);
		    		test.log(LogStatus.INFO, imagePath);
				
		    		//IssuedCertificatesPageElements.Column4TextPrint();
			
		    		Clients_IssuedCertificatesPageElements.Product4View();
		    		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    		test.log(LogStatus.INFO, "Clicked to view product");
			
		    	}else if (Clients_IssuedCertificatesPageElements.Column5Contains(Product)) {
	    			
	    			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    	    test.log(LogStatus.INFO, "Column 5 Contains Products");
		    	    
		    	    String path = ScreenShot.Image(driver, "Product");
					String imagePath = test.addScreenCapture(path);
					test.log(LogStatus.INFO, imagePath);
					
					//IssuedCertificatesPageElements.Column3TextPrint();
				
	    			Clients_IssuedCertificatesPageElements.Product5View();
	    			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    	    test.log(LogStatus.INFO, "Clicked to view product");
				
			    }else {
				
				System.out.println("Product Not Found");
				test.log(LogStatus.FAIL, "Product Not Found");
				String path = ScreenShot.Image(driver, "Product");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);
				Assert.fail();
				
		    	}	
	    	
	    }catch (Exception e) {
	    	
	    	String path = ScreenShot.Image(driver, "Product");
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.INFO, imagePath);
			test.log(LogStatus.FAIL, "Validation Failed");
			System.out.println("Element Not Found");
			Assert.fail("Exception " + e);
			
	    }
		
	    
	    //Certificates Page
	    try {
	    
	    	Client_CertificateDetailsPageElements.ReIssueButtonClick();
	    	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	    test.log(LogStatus.INFO, "Clicked on Re-Issued Tab");
    	    
    	    Client_CertificateDetailsPageElements.CsrFieldClick();
    	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	    test.log(LogStatus.INFO, "Clicked Csr Field");
    	    
    	    Client_CertificateDetailsPageElements.LoadSsl247_TestCsR();
    	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	    test.log(LogStatus.INFO, "Loaded Csr");
    	    
    	    Client_CertificateDetailsPageElements.ValidateCsrButton();
    	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	    test.log(LogStatus.INFO, "Clicked Validate Csr Button");
    	    
    	    Thread.sleep(1000);
    	    
    	    Client_CertificateDetailsPageElements.ReIssueCertificateButtonClick();
    	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	    test.log(LogStatus.INFO, "Clicked on Reissue Certificate Button");
	    
		}catch (Exception e) {
			
			String path = ScreenShot.Image(driver, "Product");
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.INFO, imagePath);
			test.log(LogStatus.FAIL, "Validation Failed");
			//Assert.fail("Exception " + e);
			System.out.println("Reissuaince Test Exception:-  " + e);
			Assert.fail();
		}
	    
	    
	    try {
	    	
	    	String Alertnote = "Certificate has been submitted for reissue";  
	    	AlertBoxElements.AlertWait();
	    			    	
	      if (AlertBoxElements.VerifyAlert(Alertnote)) {
	    						
	    	test.log(LogStatus.PASS, "Validation Complete");
	    	Assert.assertTrue(AlertBoxElements.VerifyAlert(Alertnote));
	    	System.out.println("Validation Complete!");
	    	
	      }else{
	    	
	    	String path = ScreenShot.Image(driver, "SearchResult");
	    	String imagePath = test.addScreenCapture(path);
	    	test.log(LogStatus.INFO, imagePath);
  
	    	test.log(LogStatus.WARNING, "Alert Validation Failed");
	    	AlertBoxElements.AlertPrint();
	   	    	
	    	}
	    	
	    }catch (Exception e) {
	    						
	    	test.log(LogStatus.FAIL, "Alart Not Displayed");
	    	String path = ScreenShot.Image(driver, "SearchResult");
	    	String imagePath = test.addScreenCapture(path);
	    	test.log(LogStatus.INFO, imagePath);
	    	Assert.fail();
	    	//Assert.fail("Exception " + e);
	    }
	    
	}   
	
}
