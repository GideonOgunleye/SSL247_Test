package Smoke_Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilities.AlertBox;
import BaseUtilities.BrowserStack;
import BaseUtilities.Chrome;
import BaseUtilities.Chrome2;
import BaseUtilities.Constants;
import BaseUtilities.DriverLoad;
import BaseUtilities.ExtentFactory;
import BaseUtilities.TakeScreenShot;
import PageFactory.Admin.Admin_AddAccountPage;
import PageFactory.Admin.Admin_BillingPage;
import PageFactory.Admin.Admin_CertificateDetailsPage;
import PageFactory.Admin.Admin_CertificatesPage;
import PageFactory.Admin.Admin_ClientAccountsPage;
import PageFactory.Admin.Admin_IssuedCertificatesPage;
import PageFactory.Admin.Admin_LoginPage;
import PageFactory.Admin.Admin_MySslDashBoard;
import PageFactory.Admin.Admin_NavigationLinks;
import PageFactory.Admin.Admin_OutgoingEmailsLogPage;
import PageFactory.Admin.Admin_ProposalsPage;
import PageFactory.Admin.Admin_SslDashBoard;
import PageFactory.Client.Client_NavigationLinks;
import Sanity_Test.Test_DataSanity;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class Admin_User extends BrowserStack {
	
	  ExtentReports report;
	  ExtentTest test;
	  Admin_LoginPage 	Admin_LoginPageElements;
	  Admin_NavigationLinks Admin_NavigationLinksElements;
	  Admin_CertificatesPage Admin_CertificatesPageElements;
	  //Client_NavigationLinks NavigationLinksElements;
	  Admin_BillingPage Admin_BillingPageElements;
	  Admin_MySslDashBoard Admin_MySslDashBoardElements;
	  Admin_SslDashBoard Admin_SslDashBoardElements;
	  AlertBox AlertBoxElements;
	  Admin_ProposalsPage Admin_ProposalsPageElements;
	  Admin_ClientAccountsPage Admin_ClientAccountsPageElements;
	  Admin_IssuedCertificatesPage Admin_IssuedCertificatesPage;
	  Admin_CertificateDetailsPage Admin_CertificateDetailsPageElements;
	  Admin_AddAccountPage Admin_AddAccountPageElements;
	  TakeScreenShot ScreenShot;
	  Admin_OutgoingEmailsLogPage Admin_OutgoingEmailsLogPageElements;
	
@BeforeMethod (groups = {"Smoke","BS_Smoke"})
public void Login() throws Exception {

		  Admin_LoginPageElements = new Admin_LoginPage(driver);
		  Admin_BillingPageElements = new Admin_BillingPage(driver);
		  Admin_MySslDashBoardElements = new Admin_MySslDashBoard(driver);
		  Admin_SslDashBoardElements = new Admin_SslDashBoard(driver);
		  AlertBoxElements = new AlertBox(driver);
		  Admin_ProposalsPageElements = new Admin_ProposalsPage(driver);
		  //NavigationLinksElements = new Client_NavigationLinks(driver);
		  Admin_NavigationLinksElements = new Admin_NavigationLinks(driver);
		  Admin_ClientAccountsPageElements = new Admin_ClientAccountsPage(driver);
		  Admin_CertificatesPageElements = new Admin_CertificatesPage(driver);
		  Admin_IssuedCertificatesPage = new Admin_IssuedCertificatesPage(driver);
		  Admin_CertificateDetailsPageElements = new Admin_CertificateDetailsPage(driver);
		  Admin_AddAccountPageElements = new Admin_AddAccountPage(driver);
		  ScreenShot = new TakeScreenShot();
		  Admin_OutgoingEmailsLogPageElements = new  Admin_OutgoingEmailsLogPage(driver);
	  
		  Admin_LoginPageElements.AdminLogin();
	 
		  report = ExtentFactory.getInstance(); 	 
			 
}

@AfterMethod (alwaysRun = true, groups = {"Smoke","BS_Smoke"})
public void Log_Out (ITestResult result) throws Exception {


String path =  ScreenShot.Image(driver, "TestSecreenShot-" + result.getMethod().getMethodName());
String imagePath = test.addScreenCapture(path);
test.log(LogStatus.INFO, "Test Complete", imagePath);


/*User Log Out*/
driver.navigate().refresh();

JavascriptExecutor jse = (JavascriptExecutor)driver;
jse.executeScript("window.scrollBy(0,-500)", "");

Thread.sleep(1000);

	 try{ 
		 
		 
		 if (Admin_LoginPageElements.LoginLinkIsVisible()){
			 
			 test.log(LogStatus.INFO, "Logout Button Not Visible");
			 System.out.println("Logout Button Not Visible");
			 String path2 = ScreenShot.Image(driver, "Logout");
			 String imagePath2 = test.addScreenCapture(path2);
			 test.log(LogStatus.INFO, imagePath2);
			 report.endTest(test);
			 report.flush();
			 
		 }else if (Admin_LoginPageElements.AdminLogoutButtonIsVisible()) {
			 
			  Admin_LoginPageElements.ClickAdminLogoutButton();
			  test.log(LogStatus.INFO, "Admin User Logged Out");
			  String path2 = ScreenShot.Image(driver, "Logout");
			  String imagePath2 = test.addScreenCapture(path2);
			  test.log(LogStatus.INFO, imagePath2);
			  report.endTest(test);
			  report.flush();
			 
		 }
		 
	  
	 }catch (Exception e) {
			
			test.log(LogStatus.FAIL, "Logout Validation Failed");
			test.log(LogStatus.INFO, e);
			String path2 = ScreenShot.Image(driver, "Logout");
			String imagePath2 = test.addScreenCapture(path2);
			test.log(LogStatus.INFO, imagePath2);
			report.endTest(test);
			report.flush();
			System.out.println("Exception " + e);
			driver.quit();
			//Assert.fail("Exception " + e);
	}
}

@Test (priority = 0, groups = {"Smoke","BS_Smoke"})
public void Admin_LogIn_ValidationCredentials() throws Exception{

report = ExtentFactory.getInstance3();
//Admin_LoginPageElements.AdminLogin();

test = report.startTest("Registered User Test --> Admin Login- " + "Valid Credentials");
	
try{
		
		Admin_LoginPageElements.ClickAdminLogoutButton();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "User Logged Out");
		String path2 = ScreenShot.Image(driver, "Logout");
		String imagePath2 = test.addScreenCapture(path2);
		test.log(LogStatus.INFO, imagePath2);
		report.endTest(test);
		report.flush();
	
	}catch (Exception e) {
		
		test.log(LogStatus.FAIL, "Logout Failed");
		test.log(LogStatus.INFO, e);
		String path2 = ScreenShot.Image(driver, "Logout");
		String imagePath2 = test.addScreenCapture(path2);
		test.log(LogStatus.INFO, imagePath2);
		report.endTest(test);
		report.flush();
		//Assert.fail("Exception " + e);
	}

try {
	  
	  Admin_LoginPageElements.LoadLoginPage();
	  Thread.sleep(1000);
	  test.log(LogStatus.INFO, "Browser Opened and Url Entered");
	  test.log(LogStatus.INFO, "Login Page Loaded");
	  
	  Admin_LoginPageElements.ClickLoginLink();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Clicked Login Link");
	  
	  Admin_LoginPageElements.EnterUserName("gogunleye@ssl247.co.uk");
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Entereed UserName");
	  
	  Admin_LoginPageElements.EnterPassword("Prestige02");
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Entered Password");
	  
	  
	  Admin_LoginPageElements.ClickLoginButton();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Clicked Login Link");

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
		
		 
	 if(driver.getTitle().contains("Slicket Backlog")){
		 
		 System.out.println("Admin User Logged In");
	 	 test.log(LogStatus.PASS, "Admin User Logged In");
	 
	 }else {
		 
		 System.out.println("Admin User Not Logged In");
	 	 test.log(LogStatus.FAIL, "Admin User Not Logged In");
	 	 //String path2 = ScreenShot.Image(driver, "Element");
	 	 //String imagePath2 = test.addScreenCapture(path2);
	 	 //test.log(LogStatus.INFO, imagePath2);
	 	// driver.close();
	 	 
	 }
	  
	}catch(Exception e) {
		
		test.log(LogStatus.WARNING, "Alert not displayed");
		test.log(LogStatus.INFO, e);
		System.out.println("Element Not Found");
		String path2 = ScreenShot.Image(driver, "Element");
		String imagePath2 = test.addScreenCapture(path2);
		test.log(LogStatus.INFO, imagePath2);
		report.endTest(test);
		report.flush();
		System.out.println("Exception" + e);
	
	}

}

@Test (priority = 1, groups = {"Smoke","BS_Smoke"})
public void Admin_LogIn_InValidationCredentials() throws Exception{

report = ExtentFactory.getInstance3();
//Admin_LoginPageElements.AdminLogin();

test = report.startTest("Registered User Test --> Admin Login- " + "InValid Credentials");
	
try{
		
		Admin_LoginPageElements.ClickAdminLogoutButton();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "User Logged Out");
		String path2 = ScreenShot.Image(driver, "Logout");
		String imagePath2 = test.addScreenCapture(path2);
		test.log(LogStatus.INFO, imagePath2);
		report.endTest(test);
		report.flush();
	
	}catch (Exception e) {
		
		test.log(LogStatus.FAIL, "Logout Failed");
		test.log(LogStatus.INFO, e);
		String path2 = ScreenShot.Image(driver, "Logout");
		String imagePath2 = test.addScreenCapture(path2);
		test.log(LogStatus.INFO, imagePath2);
		report.endTest(test);
		report.flush();
		//Assert.fail("Exception " + e);
	}

try {
	  
	  Admin_LoginPageElements.LoadLoginPage();
	  Thread.sleep(1000);
	  test.log(LogStatus.INFO, "Browser Opened and Url Entered");
	  test.log(LogStatus.INFO, "Login Page Loaded");
	  
	  Admin_LoginPageElements.ClickLoginLink();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Clicked Login Link");
	  
	  Admin_LoginPageElements.EnterUserName("gogunleye@ssl247.co.uk");
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Entereed UserName");
	  
	  Admin_LoginPageElements.EnterPassword("Test1234567");
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Entered Password");
	  
	  
	  Admin_LoginPageElements.ClickLoginButton();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Clicked Login Link");

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
		
		 
	 if(driver.getTitle().contains("Slicket Backlog")){
		 
		 System.out.println("Admin User Logged In");
	 	 test.log(LogStatus.FAIL, "Admin User Logged In");
	 
	 }else {
		 
		 System.out.println("Admin User Not Logged In");
	 	 test.log(LogStatus.PASS, "Admin User Not Logged In");
	 	 //String path2 = ScreenShot.Image(driver, "Element");
	 	 //String imagePath2 = test.addScreenCapture(path2);
	 	 //test.log(LogStatus.INFO, imagePath2);
	 	// driver.close();
	 	 
	 }
	  
	}catch(Exception e) {
		
		test.log(LogStatus.WARNING, "Alert not displayed");
		test.log(LogStatus.INFO, e);
		System.out.println("Element Not Found");
		String path2 = ScreenShot.Image(driver, "Element");
		String imagePath2 = test.addScreenCapture(path2);
		test.log(LogStatus.INFO, imagePath2);
		report.endTest(test);
		report.flush();
		System.out.println("Exception" + e);
	
	}

}


@Test (priority = 2,groups = {"Smoke","BS_Smoke"})
public void Create_Proposal () throws Exception {

//Navigate to User Account, Search for User and Click View

		report = ExtentFactory.getInstance3();
		test = report.startTest("Admin Test -->  Create a Proposal");
		test.log(LogStatus.INFO, "Admin User Logged in");
	
		
		 try {
			 
				Admin_NavigationLinksElements.ClientsAccountsLinkClick();
				test.log(LogStatus.INFO, "Click on clients Accounts Link");
				 
				Admin_ClientAccountsPageElements.ValidatePage();
				Admin_ClientAccountsPageElements.SearchQueryFieldFill("UK Test");
				test.log(LogStatus.INFO, "Click on Search Query and Enter UK Test");
				 
				Admin_ClientAccountsPageElements.UpdateButtonClink();
				test.log(LogStatus.INFO, "Click on Update Button");
				 
				Thread.sleep(5000);
				
				Admin_ClientAccountsPageElements.ValidateResults("UKTE001");
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Search Resusult is Displayed");
			 
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
		
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript("window.scrollBy(0,500)", "");
	    
	    Thread.sleep(1000);
		
		 try {
			 
				Admin_ClientAccountsPageElements.ViewAccount();	
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			    test.log(LogStatus.INFO, "Click on UK Test Account in search Result");
			    
			    Thread.sleep(1000);
			    //Admin_MySslDashBoardElements.AdminDashboardValidation();
			  	test.log(LogStatus.INFO, "DashBord Page Opened");
				
				//Navigate to Proposals Section 
			  	Admin_SslDashBoardElements.ProposalsLinkClick();
				Thread.sleep(10000);
				test.log(LogStatus.INFO, "Proposal Link Clicked");
				
			 
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
		//Click on New Proposal
		//Admin_ProposalsPageElements.ValidatePage();
		Admin_ProposalsPageElements.NewProposalButtonClink();
		Thread.sleep(10000);
		test.log(LogStatus.INFO, "New Proposal Buttton Clicked");
		
		//Fill in required information
		Admin_ProposalsPageElements.ProductTypeFieldSelect("SSL Certificate");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Select Product Type");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	
		Admin_ProposalsPageElements.ProductFieldSelect("RapidSSL Pro");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Select Product Name");
		Thread.sleep(10000);
			
		Admin_ProposalsPageElements.QuantityFieldClear();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Cleared Quantity Field");
		
		Admin_ProposalsPageElements.QuantityFieldSenkeys("3");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Enter Quantity in Field ");
		
		Admin_ProposalsPageElements.DurationFieldSelect("3 years");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Select Number of Years");
		Thread.sleep(10000);		
		
		Admin_ProposalsPageElements.CommonNameFieldClear();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Cleared Common Name Field");
		
		Admin_ProposalsPageElements.CommonNameFieldSendKeys("ssl247-testing.co.uk");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Fill in Common Name");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		Admin_ProposalsPageElements.CalculatePricesButtonClink();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Click on Calculate Prices Button");
		Thread.sleep(10000);
		
		//Click Save
		Admin_ProposalsPageElements.SaveProposalButtonClink();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Click on Save Proposal Button");
		
	}catch (Exception e) {
			
			test.log(LogStatus.FAIL, "Validation Failed");
			test.log(LogStatus.INFO, e);
			Assert.fail("Exception " + e);
	
	}

		
		//Validate Test
		try {
			String Alertnote = "Proposal saved";  
			AlertBoxElements.AlertWait();
					    	
		  if (AlertBoxElements.VerifyAlert(Alertnote)) {
								
			test.log(LogStatus.PASS, "Validation Complete");
			Assert.assertTrue(AlertBoxElements.VerifyAlert(Alertnote));
			System.out.println("Validation Complete!");
		  }else{
					    	
		test.log(LogStatus.FAIL, "Validation Failed");
			AlertBoxElements.AlertPrint();
			Assert.fail("Validation Failed ");
					    	
			}
			
		}catch (Exception e) {
								
			String path = ScreenShot.Image(driver, "SearchResult");
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.INFO, imagePath);
			test.log(LogStatus.WARNING, "Alert not Displayed");
			test.log(LogStatus.INFO, e);

		}

		//test.log(LogStatus.INFO, "Click on Save Proposal Button");
		//test.log(LogStatus.PASS, "Proposal Created and Saved Successfully");
	}

}
