package Smoke_Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilities.AlertBox;
import BaseUtilities.BrowserStack;
import BaseUtilities.Chrome;
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
	Client_LoginPage 	LoginPageElements;
	Client_BillingPage BillingPageElements;
	Client_MySslDashBoard sslDashBoardElements;
	CsR CsrElements;
	Client_NavigationLinks NavigationElements;
	AlertBox AlertBoxElements;
	TakeScreenShot ScreenShot;
	Client_IssuedCertificatesPage IssuedCertificatesPageElements;
	Client_CertificateDetailsPage CertificateDetailsPageElements;
	Client_MyProductsPage MyProductsPageElements;
	Client_AddToBasketPage AddToBasketPageElements;
	Client_ShoppingBasketPage  ShoppingBasketPageElements;
	Client_ViewOrderPage ViewOrderPageElements;
	Client_CertificateValidationPage CertificateValidationPageElements;
	Client_PendingCertificatesPage PendingCertificatesPageElements;
	Client_MyUsersPage MyUsersPageElements;
	Client_NewUserPage NewUserPageElements;
	Client_EditUserPage EditUserPageElements;
	Client_RegisterDomainPage RegisterDomainPageElements;
	Client_DomainNamesEditPage DomainNamesEditPageElements;

	
	@BeforeMethod (groups = {"Smoke","BS_Smoke"})
	public void Login () throws Exception {
		
		report = ExtentFactory.getInstance(); 
		LoginPageElements = new Client_LoginPage(driver);
		BillingPageElements = new Client_BillingPage(driver);
		sslDashBoardElements = new Client_MySslDashBoard(driver);
		CsrElements = new CsR(driver);
		NavigationElements = new Client_NavigationLinks(driver);
		AlertBoxElements = new AlertBox(driver);
		IssuedCertificatesPageElements = new Client_IssuedCertificatesPage(driver);
		CertificateDetailsPageElements = new Client_CertificateDetailsPage(driver);
		ScreenShot = new TakeScreenShot();
		MyProductsPageElements = new Client_MyProductsPage (driver);
		AddToBasketPageElements = new Client_AddToBasketPage (driver);
		ShoppingBasketPageElements = new Client_ShoppingBasketPage (driver);
		ViewOrderPageElements = new Client_ViewOrderPage(driver);
		CertificateValidationPageElements = new Client_CertificateValidationPage(driver);
		PendingCertificatesPageElements = new Client_PendingCertificatesPage(driver);
		MyUsersPageElements = new Client_MyUsersPage(driver);
		NewUserPageElements = new Client_NewUserPage(driver);
		EditUserPageElements = new Client_EditUserPage(driver);
		RegisterDomainPageElements = new Client_RegisterDomainPage(driver);
		DomainNamesEditPageElements = new Client_DomainNamesEditPage(driver);
		 
		
		
		LoginPageElements.ClientLogin();
		
		Thread.sleep(5000);		
	}

	
	@AfterMethod (groups = {"Smoke","BS_Smoke"}, alwaysRun = true)
	public void Logout (ITestResult result) throws Exception {

	    //Take Screen Shots
				
	  	String path =  ScreenShot.Image(driver, "TestSecreenShot-" + result.getMethod().getMethodName());
		String imagePath = test.addScreenCapture(path);
		test.log(LogStatus.INFO, "Test Complete", imagePath);
		
		driver.navigate().refresh();
		
		Thread.sleep(5000);
		
		try{
			
			LoginPageElements.ClickLogoutButton();
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
	

	
	@Test (priority = 0, groups = {"Smoke","BS_Smoke"},dataProviderClass =Test_DataSmoke.class, dataProvider="LoginUser")
	  public void LogIn_Valid_Credentials (String Username, String Password, String Credentials) throws Exception{
		 
		  report = ExtentFactory.getInstance3();
		
		 // test = report.startTest("<---------------------------Test Suite Start----------------------------------->");
		  test = report.startTest("Registered User Test --> User Login- " + "Valid Credentials");
		  
		  try{
				
				LoginPageElements.ClickLogoutButton();
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
		  
		  LoginPageElements.LoadLoginPage();
		  Thread.sleep(1000);
		  test.log(LogStatus.INFO, "Browser Opened and Url Entered");
		  test.log(LogStatus.INFO, "Login Page Loaded");
		  
		  LoginPageElements.ClickLoginLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Clicked Login Link");
		  
		  LoginPageElements.EnterUserName(Username);
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Entereed Valid UserName");
		  
		  LoginPageElements.EnterPassword(Password);
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Entered Valid Password");
		  
		  LoginPageElements.ClickLoginButton();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Clicked Login Link");
		  
		  
		  try {
				
			 
			 if(driver.getTitle().contains("MySSL® » Dashboard")){
				 
				 System.out.println("Admin User Logged In");
			 	 test.log(LogStatus.PASS, "Admin User Logged In");
			 
			 }else {
				 
				 System.out.println("Dashboard Page NOT Opened");
				 System.out.println("Title Page Displayed Is:- "+ driver.getTitle());
			 	 test.log(LogStatus.FAIL, "Dashboard Page NOT Opened");
			 	 
			 }
			  
			}catch(Exception e) {
				System.out.println("Exception:- "+ e);
				test.log(LogStatus.FAIL, "Validation Failed");
				//Assert.fail("Exception " + e);
			
				}	
			
		  
	  } 
	
	@Test (priority = 1, groups = {"Smoke","BS_Smoke"},dataProviderClass =Test_DataSmoke.class, dataProvider="LoginUser")
	  public void LogIn_InValid_Credentials (String Username, String Password, String Credentials) throws Exception{
		 
		  report = ExtentFactory.getInstance3();
		
		 // test = report.startTest("<---------------------------Test Suite Start----------------------------------->");
		  test = report.startTest("Registered User Test --> User Login- " + "Invalid Credentials");
		  
		  try{
				
				LoginPageElements.ClickLogoutButton();
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
		  
		  LoginPageElements.LoadLoginPage();
		  Thread.sleep(1000);
		  test.log(LogStatus.INFO, "Browser Opened and Url Entered");
		  test.log(LogStatus.INFO, "Login Page Loaded");
		  
		  LoginPageElements.ClickLoginLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Clicked Login Link");
		  
		  LoginPageElements.EnterUserName(Username);
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Entereed Valid UserName");
		  
		  LoginPageElements.EnterPassword("Test2345");
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Entered Invalid Password");
		  
		  LoginPageElements.ClickLoginButton();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Clicked Login Link");
		  
		  
		  try {
				
			 
			 if(driver.getTitle().contains("MySSL� � Dashboard")){
				 
				 System.out.println("Admin User Logged In");
			 	 test.log(LogStatus.FAIL, "Admin User Logged In");
			 
			 }else {
				 
				 System.out.println("Dashboard Page NOT Opened");
				 System.out.println("Title Page Displayed Is:- "+ driver.getTitle());
			 	 test.log(LogStatus.PASS, "Dashboard Page NOT Opened");
			 	 
			 }
			  
			}catch(Exception e) {
				
				System.out.println("Exception:- "+ e);
				test.log(LogStatus.FAIL, "Validation Failed");
				//Assert.fail("Exception " + e);
			
				}	
			
		  
	  }   
	
}
