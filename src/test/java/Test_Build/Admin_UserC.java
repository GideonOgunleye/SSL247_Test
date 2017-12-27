package Test_Build;

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
import PageFactory.Admin.Admin_CertificateDetailsPage;
import PageFactory.Admin.Admin_CertificatesPage;
import PageFactory.Admin.Admin_IssuedCertificatesPage;
import PageFactory.Admin.Admin_NavigationLinks;
import PageFactory.Admin.Admin_OutgoingEmailsLogPage;
import PageFactory.Admin.Admin_ProposalsPage;
import PageFactory.Admin.Admin_SslDashBoard;
import PageFactory.Client.Client_AddAccountPage;
import PageFactory.Client.Client_BillingPage;
import PageFactory.Client.Client_ClientAccountsPage;
import PageFactory.Client.Client_LoginPage;
import PageFactory.Client.Client_MySslDashBoard;
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

public class Admin_UserC extends Chrome2 {
	  ExtentReports report;
	  ExtentTest test;
	  Client_LoginPage 	LoginPageElements;
	  Admin_NavigationLinks Admin_NavigationLinksElements;
	  Admin_CertificatesPage Admin_CertificatesPageElements;
	  Client_NavigationLinks NavigationLinksElements;
	  Client_BillingPage BillingPageElements;
	  Client_MySslDashBoard sslDashBoardElements;
	  Admin_SslDashBoard Admin_SslDashBoardElements;
	  AlertBox AlertBoxElements;
	  Admin_ProposalsPage ProposalsPageElements;
	  Client_ClientAccountsPage ClientAccountsPageElements;
	  Admin_IssuedCertificatesPage Admin_IssuedCertificatesPage;
	  Admin_CertificateDetailsPage Admin_CertificateDetailsPageElements;
	  Client_AddAccountPage AddAccountPageElements;
	  TakeScreenShot ScreenShot;
	  Admin_OutgoingEmailsLogPage Admin_OutgoingEmailsLogPageElements;
	
 @BeforeMethod (groups = {"Sanity","Smoke","BS_Smoke","Smoke_Firefox","Smoke_Chrome","BS_Sanity","Sanity_Chrome"})
 public void Login() throws Exception {

		  LoginPageElements = new Client_LoginPage(driver);
		  BillingPageElements = new Client_BillingPage(driver);
		  sslDashBoardElements = new Client_MySslDashBoard(driver);
		  Admin_SslDashBoardElements = new Admin_SslDashBoard(driver);
		  AlertBoxElements = new AlertBox(driver);
		  ProposalsPageElements = new Admin_ProposalsPage(driver);
		  NavigationLinksElements = new Client_NavigationLinks(driver);
		  Admin_NavigationLinksElements = new Admin_NavigationLinks(driver);
		  ClientAccountsPageElements = new Client_ClientAccountsPage(driver);
		  Admin_CertificatesPageElements = new Admin_CertificatesPage(driver);
		  Admin_IssuedCertificatesPage = new Admin_IssuedCertificatesPage(driver);
		  Admin_CertificateDetailsPageElements = new Admin_CertificateDetailsPage(driver);
		  AddAccountPageElements = new Client_AddAccountPage(driver);
		  ScreenShot = new TakeScreenShot();
		  Admin_OutgoingEmailsLogPageElements = new  Admin_OutgoingEmailsLogPage(driver);
	  
		  LoginPageElements.AdminLogin();
	 
		  report = ExtentFactory.getInstance(); 	 
			 
	  }

@AfterMethod (alwaysRun = true, groups = {"Sanity","Smoke","BS_Smoke","Smoke_Firefox","Smoke_Chrome","BS_Sanity","Sanity_Chrome"})
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
			 
			 
			 if (LoginPageElements.LoginLinkIsVisible()){
				 
				 test.log(LogStatus.INFO, "Logout Button Not Visible");
				 System.out.println("Logout Button Not Visible");
				 String path2 = ScreenShot.Image(driver, "Logout");
				 String imagePath2 = test.addScreenCapture(path2);
				 test.log(LogStatus.INFO, imagePath2);
				 report.endTest(test);
				 report.flush();
				 
			 }else if (LoginPageElements.AdminLogoutButtonIsVisible()) {
				 
				  LoginPageElements.ClickAdminLogoutButton();
				  test.log(LogStatus.INFO, "Admin User Logged Out");
				  String path2 = ScreenShot.Image(driver, "Logout");
				  String imagePath2 = test.addScreenCapture(path2);
				  test.log(LogStatus.INFO, imagePath2);
				  report.endTest(test);
				  report.flush();
				 
			 }
			 
		  
		 }catch (Exception e) {
				
				test.log(LogStatus.FAIL, "Logout Validation Failed");
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
  
@Test (priority = 0, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="AdminLogin", enabled = false)
public void Admin_LogInValidation(String Username, String Password, String Credentials) throws Exception{

	  report = ExtentFactory.getInstance3();
	 // LoginPageElements.AdminLogin();
	  
	  test = report.startTest("Registered User Test --> Admin Login- " + Credentials);
		
	  try{
			
			LoginPageElements.ClickAdminLogoutButton();
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
	 
	  try {
		  
		  LoginPageElements.LoadLoginPage();
		  Thread.sleep(1000);
		  test.log(LogStatus.INFO, "Browser Opened and Url Entered");
		  test.log(LogStatus.INFO, "Login Page Loaded");
		  
		  LoginPageElements.ClickLoginLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Clicked Login Link");
		  
		  LoginPageElements.EnterUserName(Username);
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Entereed UserName");
		  
		  LoginPageElements.EnterPassword(Password);
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Entered Password");
		  
		  
		  LoginPageElements.ClickLoginButton();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Clicked Login Link");
	  
	  }catch (Exception e) {
			
			test.log(LogStatus.FAIL, "Element Not Found");
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
			System.out.println("Exception:- "+ e);
			test.log(LogStatus.FAIL, "Validation Failed");
			//Assert.fail("Exception " + e);
		
		}
	  
}

  
  @Test (priority = 1, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void Edit_Account_User() throws Exception{
	  
		//Search For UK Test User
	     test = report.startTest("Admin Test --> Edit User");
	     
	     test.log(LogStatus.INFO, "Admin User Logged in");
	  
	     Admin_NavigationLinksElements.ClientsAccountsLinkClick();
	     driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 test.log(LogStatus.INFO, "Click on clients Accounts Link");
		 
		 ClientAccountsPageElements.ValidatePage();
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 test.log(LogStatus.INFO, "Click Account Page Validated");
		 
		 
		 ClientAccountsPageElements.SearchQueryFieldFill("UK Test");
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 test.log(LogStatus.INFO, "Click on Search Query and Enter UK Test");
		 
		 ClientAccountsPageElements.UpdateButtonClink();
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 test.log(LogStatus.INFO, "Click on Update Button");
		 
		 Thread.sleep(5000);
		 ClientAccountsPageElements.ValidateResults("UKTE001");
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 test.log(LogStatus.INFO, "Search Resusult is Displayed");
		 
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("window.scrollBy(0,500)", "");
		     
		 Thread.sleep(1000);
		 
		 ClientAccountsPageElements.ViewAccount();
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	     test.log(LogStatus.INFO, "Click on UK Test Account in search Result");
	     
	     //JavascriptExecutor jse = (JavascriptExecutor)driver;
	     jse.executeScript("window.scrollBy(0,500)", "");
	     
	     Thread.sleep(1000);
	     
	     sslDashBoardElements.AdminDashboardValidation();
	     driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  	 test.log(LogStatus.INFO, "DashBord Page Opened");
	     
		 
	     
	     //Click on My Users Link
	     Admin_SslDashBoardElements.ClickAccountEndUsersLink();
	     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	     test.log(LogStatus.INFO, "Click on Account End Users link on the side bar Menu");
	     
	     //JavascriptExecutor jse = (JavascriptExecutor)driver;
	     jse.executeScript("window.scrollBy(0,500)", "");
	     Thread.sleep(1000);
	     test.log(LogStatus.INFO, "Scrolled Page Down");
		 
		 
	     try {		 
		 String UserVal = "Gideon Ogunleye";

		 if(Admin_SslDashBoardElements.User1_LinkContains(UserVal)){
				
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 Admin_SslDashBoardElements.User1_EditButton();
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		     test.log(LogStatus.INFO, "Navigate to Quality Assurance Tester User and Click Edit");
		     
		     //Edit User
		     Admin_SslDashBoardElements.AccessLevelSelect();
			 Thread.sleep(1000);
			 
			//Edit Optional Details
			 Admin_SslDashBoardElements.OptionalDetailsTabClick();
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 Admin_SslDashBoardElements.StateFieldFill("London");
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 
			 jse.executeScript("window.scrollBy(0,-500)", "");
		     Thread.sleep(1000);
		     test.log(LogStatus.INFO, "Scrolled Page up");
			 
			//Click Save User
			 Admin_SslDashBoardElements.SubmitChangesButtonClick();
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 test.log(LogStatus.INFO, "Click Submit Chnages Button");
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 test.log(LogStatus.PASS, "Test User Account Edited and Saved");
			 
			}else if (Admin_SslDashBoardElements.User2_LinkContains(UserVal)) {
				
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				Admin_SslDashBoardElements.User2_EditButton();
			    test.log(LogStatus.INFO, "Navigate to Quality Assurance Tester User and Click Edit");
			    
			    Thread.sleep(1000);
				 
				 //Edit User
				 Admin_SslDashBoardElements.RequiredDetailsTabClick();
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.INFO, "Clicked Required Details Tab");
				 
			     Admin_SslDashBoardElements.AccessLevelSelect();
			     driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.INFO, "Selected Super User Option");
			     
				 Thread.sleep(1000);
				 
				 //Edit Optional Details
				 Admin_SslDashBoardElements.OptionalDetailsTabClick();
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 Admin_SslDashBoardElements.StateFieldFill("London");
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 
				 jse.executeScript("window.scrollBy(0,-500)", "");
			     Thread.sleep(1000);
			     test.log(LogStatus.INFO, "Scrolled Page up");
				 
				//Click Save User
				 Admin_SslDashBoardElements.SubmitChangesButtonClick();
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.INFO, "Click Submit Chnages Button");
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.PASS, "Test User Account Edited and Saved");
				 
			 }else if (Admin_SslDashBoardElements.User3_LinkContains(UserVal)) {
		
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 Admin_SslDashBoardElements.User3_EditButton();
				 test.log(LogStatus.INFO, "Navigate to Quality Assurance Tester User and Click Edit");
				 
				 Thread.sleep(1000);
				 
				 //Edit User
				 Admin_SslDashBoardElements.RequiredDetailsTabClick();
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.INFO, "Clicked Required Details Tab");
				 
			     Admin_SslDashBoardElements.AccessLevelSelect();
			     driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.INFO, "Selected Super User Option");
			     
				 Thread.sleep(1000);
				 
				//Edit Optional Details
				 Admin_SslDashBoardElements.OptionalDetailsTabClick();
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 Admin_SslDashBoardElements.StateFieldFill("London");
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 
				 jse.executeScript("window.scrollBy(0,-500)", "");
			     Thread.sleep(1000);
			     test.log(LogStatus.INFO, "Scrolled Page up");
				 
				//Click Save User
				 Admin_SslDashBoardElements.SubmitChangesButtonClick();
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.INFO, "Click Submit Chnages Button");
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.PASS, "Test User Account Edited and Saved");
				 
				 
			 }else if (Admin_SslDashBoardElements.User4_LinkContains(UserVal)) {
				 
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 Admin_SslDashBoardElements.User4_EditButton();
				 test.log(LogStatus.INFO, "Navigate to Quality Assurance Tester User and Click Edit");
				 
				 Thread.sleep(1000);
				 
				 //Edit User
				 Admin_SslDashBoardElements.RequiredDetailsTabClick();
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.INFO, "Clicked Required Details Tab");
				 
			     Admin_SslDashBoardElements.AccessLevelSelect();
			     driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.INFO, "Selected Super User Option");
			     
				 Thread.sleep(1000);
				 
				//Edit Optional Details
				 Admin_SslDashBoardElements.OptionalDetailsTabClick();
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.INFO, "Clicked Optional Details Tab");
				 
				 Admin_SslDashBoardElements.StateFieldFill("London");
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.INFO, "Filled In State");
				 
				 jse.executeScript("window.scrollBy(0,-500)", "");
			     Thread.sleep(1000);
			     test.log(LogStatus.INFO, "Scrolled Page up");
				 
				//Click Save User
				 Admin_SslDashBoardElements.SubmitChangesButtonClick();
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.INFO, "Click Submit Chnages Button");
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.PASS, "Test User Account Edited and Saved");
				 
			 }else  {
				 
				test.log(LogStatus.FAIL, "Test User Account not Found"); 
				System.out.println("Quality Tester User Not Found");
				Assert.fail("Quality Tester User Not Found");
			 }
		 
	}catch (Exception e) {
		
		test.log(LogStatus.FAIL, "Validation Failed");
		test.log(LogStatus.INFO, e);
		Assert.fail("Exception " + e);

	}

		
		 /*Test Validation*/
		 
		 try {
				String Alertnote = "User details have been updated";  
				AlertBoxElements.AlertWait();
						    	
			  if (AlertBoxElements.VerifyAlert(Alertnote)) {
									
				test.log(LogStatus.PASS, "Validation Complete");
				Assert.assertTrue(AlertBoxElements.VerifyAlert(Alertnote));
				System.out.println("Validation Complete!");
				
			  }else{
						    	
				test.log(LogStatus.FAIL, "Validation Failed");
				AlertBoxElements.AlertPrint();
				String path = ScreenShot.Image(driver, "SearchResult");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);
						    	
				}
				
			}catch (Exception e) {
				
				test.log(LogStatus.SKIP, "Alert Note not found");
				test.log(LogStatus.INFO, e);
				String path = ScreenShot.Image(driver, "SearchResult");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.FAIL, "Alert Not Displayed");
				test.log(LogStatus.INFO, imagePath);


			}
	
		 
  }
  
  @Test (priority = 2,groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
  public void Create_Proposal () throws Exception {
	  
	//Navigate to User Account, Search for User and Click View
	  
	  		report = ExtentFactory.getInstance3();
	  		test = report.startTest("Admin Test -->  Create a Proposal");
	  		test.log(LogStatus.INFO, "Admin User Logged in");
	 	
			Admin_NavigationLinksElements.ClientsAccountsLinkClick();
			test.log(LogStatus.INFO, "Click on clients Accounts Link");
			 
			ClientAccountsPageElements.ValidatePage();
			ClientAccountsPageElements.SearchQueryFieldFill("UK Test");
			test.log(LogStatus.INFO, "Click on Search Query and Enter UK Test");
			 
			ClientAccountsPageElements.UpdateButtonClink();
			test.log(LogStatus.INFO, "Click on Update Button");
			 
			Thread.sleep(5000);
			
			ClientAccountsPageElements.ValidateResults("UKTE001");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Search Resusult is Displayed");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
		    jse.executeScript("window.scrollBy(0,500)", "");
		    
		    Thread.sleep(1000);
			
			ClientAccountsPageElements.ViewAccount();	
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    test.log(LogStatus.INFO, "Click on UK Test Account in search Result");
		    
		    Thread.sleep(1000);
		    //sslDashBoardElements.AdminDashboardValidation();
		  	test.log(LogStatus.INFO, "DashBord Page Opened");
			
			//Navigate to Proposals Section 
		  	Admin_SslDashBoardElements.ProposalsLinkClick();
			Thread.sleep(10000);
			test.log(LogStatus.INFO, "Proposal Link Clicked");
		
		try {	
			//Click on New Proposal
			//ProposalsPageElements.ValidatePage();
			ProposalsPageElements.NewProposalButtonClink();
			Thread.sleep(10000);
			test.log(LogStatus.INFO, "New Proposal Buttton Clicked");
			
			//Fill in required information
			ProposalsPageElements.ProductTypeFieldSelect("SSL Certificate");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Select Product Type");
			
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
			ProposalsPageElements.ProductFieldSelect("RapidSSL Pro");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Select Product Name");
			Thread.sleep(10000);
				
			ProposalsPageElements.QuantityFieldClear();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Cleared Quantity Field");
			
			ProposalsPageElements.QuantityFieldSenkeys("3");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Enter Quantity in Field ");
			
			ProposalsPageElements.DurationFieldSelect("3 years");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Select Number of Years");
			Thread.sleep(10000);		
			
			ProposalsPageElements.CommonNameFieldClear();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Cleared Common Name Field");
			
			ProposalsPageElements.CommonNameFieldSendKeys("ssl247-testing.co.uk");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Fill in Common Name");
			
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
			ProposalsPageElements.CalculatePricesButtonClink();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Click on Calculate Prices Button");
			Thread.sleep(10000);
			
			//Click Save
			ProposalsPageElements.SaveProposalButtonClink();
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
				
				test.log(LogStatus.WARNING, "Alert not Displayed");
				test.log(LogStatus.INFO, e);
				String path = ScreenShot.Image(driver, "SearchResult");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);


			}

			//test.log(LogStatus.INFO, "Click on Save Proposal Button");
			//test.log(LogStatus.PASS, "Proposal Created and Saved Successfully");
  } 
  
  @Test (priority = 3,groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void IssueProposal () throws Exception {
	  
	  test = report.startTest("Admin Test --> Issue a Proposal");
	  test.log(LogStatus.INFO, "Admin User Logged in");
	  
	  Admin_NavigationLinksElements.ClientsAccountsLinkClick();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Click on clients Accounts Link");
		 
	  //ClientAccountsPageElements.ValidatePage();
	  ClientAccountsPageElements.SearchQueryFieldFill("UK Test");
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Click on Search Query and Enter UK Test");
		 
	  ClientAccountsPageElements.UpdateButtonClink();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Click on Update Button");
	  
	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	  jse.executeScript("window.scrollBy(0,500)", "");
		 
	  Thread.sleep(1000);
	  
	  ClientAccountsPageElements.ValidateResults("UKTE001");
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Search Resusult is Displayed");
	  
	  ClientAccountsPageElements.ViewAccount();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Clicked on UK Test Account in search Result");
	  Thread.sleep(1000);
	  
	try {
	 
	  		test.log(LogStatus.INFO, "DashBord Page Opened");
	  		
	  		Admin_SslDashBoardElements.ProposalsLinkClick();
	  		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  		test.log(LogStatus.INFO, "Clicked on Proposal Link");
	  		
		  	ProposalsPageElements.UnIssuedTabClink();
	  		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  		test.log(LogStatus.INFO, "Clicked on Unissused Tab");
		  	
		  	ProposalsPageElements.ViewTopResult();
	  		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  		test.log(LogStatus.INFO, "Clicked to view Top Result");		  	
		  	
		  	ProposalsPageElements.IssueProposalTabClink();
	  		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  		test.log(LogStatus.INFO, "Clicked on Issue Proposal Tab");
		  	
		  	Thread.sleep(1000);
		  	
		  	ProposalsPageElements.ConfirmCheckBoxOneClink();
	  		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  		test.log(LogStatus.INFO, "Clicked on Chec Box One");
		  	
		  	Thread.sleep(1000);
		  	ProposalsPageElements.ConfirmCheckBoxTwoClink();
		  	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  		test.log(LogStatus.INFO, "Clicked on Chec Box two");
		  	
		  	Thread.sleep(1000);
		  	
		  	ProposalsPageElements.IssueProposalButtonClink();
		  	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  		test.log(LogStatus.INFO, "Clicked on Issue Proposal Button");
	  
		}catch (Exception e) {
		
			test.log(LogStatus.FAIL, "Validation Failed");
			Assert.fail("Exception " + e);

	}
	  		
		//Validate Alert	
		try { 
			
			String Alertnote = "issued";  
			AlertBoxElements.AlertWait();
			
			if (AlertBoxElements.VerifyAlert(Alertnote)) {
				
				Assert.assertTrue(AlertBoxElements.VerifyAlert(Alertnote));
				test.log(LogStatus.PASS, "Validation Complete");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				System.out.println("Validation Complete!");
				
			}else {
					    	
				test.log(LogStatus.FAIL, "Validation Failed");
				AlertBoxElements.AlertPrint();
				Assert.fail("Validation Failed ");		    	
			}
			
		}catch (Exception e) {
			
			String path = ScreenShot.Image(driver, "SearchResult");
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, "Alert not Displayed");
			test.log(LogStatus.INFO, imagePath);

		}
	  
  }
  
  
  @Test (priority = 4, groups = {"Sanity", "BS_Sanity","Sanity_Chrome"})
  public void Send_Fulfillment_Email() throws Exception {
  		  
      test = report.startTest("Admin Test -->  Send Fullfillement Email");
      
	  	Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(Constants.File_Path + Constants.DataFile_Name);
				 
		prop.load(fis);

		driver.get(prop.getProperty("ComUrl")); 
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//String title = driver.getTitle();				 
		//Assert.assertTrue(title.contains("SSL Certificates: Buy Symantec, Thawte, Apache SSL Cert, GlobalSign, GeoTrust, RapidSSL- SSL247.co.uk")); 
		//Thread.sleep(5000);
		
		LoginPageElements.ClickLoginLink();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		LoginPageElements.EnterUserName(prop.getProperty("AdUserName"));
		LoginPageElements.EnterPassword(prop.getProperty("AdPassword"));
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		LoginPageElements.ClickLoginButton();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Admin User Logged in");
      
    
      //Navigate to products link
      
      Thread.sleep(1000);

    
      try {   	

    	    Admin_NavigationLinksElements.ProductsLinkMouse();
    	    driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
  		  	test.log(LogStatus.INFO, "Moved Mouse To Product Link");
  		  	
  		  	Admin_NavigationLinksElements.CertificatesLinkClick();
    	    driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
  		  	test.log(LogStatus.INFO, "Clicked on Certificates Link");
    	    
  		  	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
  		  	test.log(LogStatus.INFO, "Opened Search Products Page");
  		
  		}catch (Exception e){
  			
  			System.out.println("Search Product Link Not Clicked");
  			test.log(LogStatus.FAIL, "Search Products Page Not Opened");
  			Assert.fail("Exception " + e);
  		}
  			  	
  	  	Thread.sleep(5000);
  	  	
  try { 		
  	  	//Select Account Name from for field
  	  	Admin_CertificatesPageElements.ForFieldSelect_AccountName();
  		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
  		test.log(LogStatus.INFO, "Selected Account Name From Field");
  	  	
  		//Select Issued from Status Field
  		Admin_CertificatesPageElements.StatusFieldSelect_Issued();
  		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
  		test.log(LogStatus.INFO, "Selected Issued From Status Field");
  		
  	    //Enter Account Name into form field and Click Search
  		Admin_CertificatesPageElements.SearchFieldSendKeys("UK Test");
  		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
  		test.log(LogStatus.INFO, "Entered account name in field");
  		
  		Admin_CertificatesPageElements.SearchButtonClick();	
  		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
  		test.log(LogStatus.INFO, "Clicked Search Button");
  	
  	}catch (Exception e){
  		
  		System.out.println("Search Fields Not Present");
  		test.log(LogStatus.FAIL, "Search Fields Not Present");
  	}
  	
  	
  	//Wait for Result to appear 
  	try {
  		
  		String Message = "records per page";
  		
  		if (Admin_CertificatesPageElements.SearchResultValidate().contains(Message)) {
  			
  			test.log(LogStatus.INFO, "Result Is Displayed");
  			
  		}else {
  			
  			System.out.println("Search Result Not Present");
  			String path = ScreenShot.Image(driver, "SearchResult");
  			String imagePath = test.addScreenCapture(path);
  			test.log(LogStatus.FAIL, "Search Result Not Present", imagePath);
  				
  		}

  	}catch (Exception e){
  		
  		System.out.println("Search Result Element Not Present");
  		test.log(LogStatus.FAIL, "Result Not Displayed");
  	}
  	
  	String AccountName = "UK TEST where can you see me";
  	String Status = "Issued";
  	
  	if (Admin_CertificatesPageElements.Col1_Contains(AccountName)){
  		
  		System.out.println("Account Found in col 1");
  		
  		if (Admin_CertificatesPageElements.Col1_StatusContains(Status)) {
  			
  			System.out.println("issued Cert found in col 1");
  			Admin_CertificatesPageElements.Col1_ViewButtonClick();
  			test.log(LogStatus.INFO, "Clicked on Issued Certificate in first column of result");
  			
  		}else{
  			
  			System.out.println("No issued cert present in col 1");
  		
  		}
  		
  	}else if(Admin_CertificatesPageElements.Col2_Contains(AccountName)){
  		
  			System.out.println("Account Found in col 2");
  		
  		if (Admin_CertificatesPageElements.Col2_StatusContains(Status)) {
  			
  			System.out.println("issued Cert found in col 2");
  			Admin_CertificatesPageElements.Col2_ViewButtonClick();
  			test.log(LogStatus.INFO, "Clicked on Issued Certificate in Second column of result");
  			
  		}else {
  			
  			System.out.println("No issued cert present in col 2");
  			
  			}
  		
  	}else  {
  		 
  		System.out.println("Quality Tester User With Issued Cert Not Found");
  		test.log(LogStatus.FAIL, "Test User with Issued Cert Not Found");
  		
  	 }


  	//Click on Send Fulfillment Email Link
  	Thread.sleep(10000);
  	Admin_CertificateDetailsPageElements.SendFulfillmentButtonClick();
  	test.log(LogStatus.INFO, "Clicked on Send Fulfillment");
  	
  	//Fill In required information
  	Thread.sleep(10000);
  	
  	Admin_CertificateDetailsPageElements.EmailNotesField_Fill("Testing Testing");
  	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	test.log(LogStatus.INFO, "Entered Email Notes Text");
  	
  	Admin_CertificateDetailsPageElements.EmailAddressField_Select("gogunleye@ssl247.co.uk");
  	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
  	test.log(LogStatus.INFO, "Selected Test User from drop down list");
  	
  	Admin_CertificateDetailsPageElements.OneOffEmailAddressField_Fill("gogunleye@ssl247.co.uk");
  	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
  	test.log(LogStatus.INFO, "Entered Email in email field");
  	
  	Admin_CertificateDetailsPageElements.SendEmailButtonClick();
  	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
  	test.log(LogStatus.INFO, "Clicked on Send Button");
  	
 /* 	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    String SendStatus = driver.findElement(By.xpath("html/body/div[4]/p[1]")).getText();	
    Assert.assertTrue(SendStatus.contains("Certificate has been emailed to qa@ssl247.co.uk"));
    test.log(LogStatus.PASS, "Message Sent");*/
  	
  	
  	/*----Verify Sent Email is in Outgoing emails--------*/
  	
  	//Navigate to Outgoing Emails Link
  	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

    	Admin_NavigationLinksElements.CmsLink_Mouse();
    	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	Admin_NavigationLinksElements.OutgoingEmailsLink_Click();
    	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	test.log(LogStatus.INFO, "Navigated to Outgoing emails Page");
    	
/*    	Assert.assertTrue(AdminOutgoingEmailsLogPageElements.Col1_SubjectContains("Your 1 year(s) GlobalSign DomainSSL SSL certificate for *.ssl247.co.uk has been issued"));
    	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	test.log(LogStatus.PASS, "Varified email is present");*/
    	
    	//Delete Outgoing Emails Afterwards
    	
    	Admin_OutgoingEmailsLogPageElements.Col1_ViewButtionClick();
    	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	test.log(LogStatus.INFO, "Clicked On View Button");
    	
    	 try {
    		 
    	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	    driver.switchTo().alert().accept(); 
  			String Alertnote = "Email deleted";  
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
  								
  			test.log(LogStatus.INFO, "Alert Not Opened");
  			//Assert.fail("Exception " + e);

  		}


  }

  @Test (priority = 5,groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void Send_Change_Password_Request_Email() throws Exception {
	  
	    test = report.startTest("Admin Test --> Change Password Request Email");
	    
	  	Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(Constants.File_Path + Constants.DataFile_Name);
				 
		prop.load(fis);

		driver.get(prop.getProperty("ComUrl")); 
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//String title = driver.getTitle();				 
		//Assert.assertTrue(title.contains("SSL Certificates: Buy Symantec, Thawte, Apache SSL Cert, GlobalSign, GeoTrust, RapidSSL- SSL247.co.uk")); 
		//Thread.sleep(5000);
		
		LoginPageElements.ClickLoginLink();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		LoginPageElements.EnterUserName(prop.getProperty("AdUserName"));
		LoginPageElements.EnterPassword(prop.getProperty("AdPassword"));
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		LoginPageElements.ClickLoginButton();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Admin User Logged in");
	    
	    
//TODO	  		
		//Navigate to User Profiles
		//Search For UK Test User
	     Admin_NavigationLinksElements.ClientsAccountsLinkClick();
	     driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 test.log(LogStatus.INFO, "Click on clients Accounts Link");
		 
		 ClientAccountsPageElements.ValidatePage();
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 test.log(LogStatus.INFO, "Click Account Page Validated");
		 
		 ClientAccountsPageElements.SearchQueryFieldFill("UK Test");
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 test.log(LogStatus.INFO, "Click on Search Query and Enter UK Test");
		 
		 ClientAccountsPageElements.UpdateButtonClink();
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 test.log(LogStatus.INFO, "Click on Update Button");
		 
		 Thread.sleep(5000);
		 ClientAccountsPageElements.ValidateResults("UKTE001");
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 test.log(LogStatus.INFO, "Search Resusult is Displayed");
		 
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("window.scrollBy(0,500)", "");
		     
		 Thread.sleep(1000);
		 
		 ClientAccountsPageElements.ViewAccount();
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	     test.log(LogStatus.INFO, "Click on UK Test Account in search Result");
	     
	     //JavascriptExecutor jse = (JavascriptExecutor)driver;
	     jse.executeScript("window.scrollBy(0,500)", "");
	     
	     Thread.sleep(1000);
	     
	     sslDashBoardElements.AdminDashboardValidation();
	     driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  	 test.log(LogStatus.INFO, "DashBord Page Opened");
	     
	     //Click on My Users Link
	     Admin_SslDashBoardElements.ClickAccountEndUsersLink();
	     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	     test.log(LogStatus.INFO, "Click on Account End Users link on the side bar Menu");
	     
	     //JavascriptExecutor jse = (JavascriptExecutor)driver;
	     jse.executeScript("window.scrollBy(0,500)", "");
	     Thread.sleep(1000);
	     test.log(LogStatus.INFO, "Scrolled Page Down");
		 
	     try {		 
		 String UserVal = "Gideon Ogunleye";

		 if(Admin_SslDashBoardElements.User1_LinkContains(UserVal)){
				
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 Admin_SslDashBoardElements.User1_EditButton();
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		     test.log(LogStatus.INFO, "Navigate to Quality Assurance Tester User and Click Edit");
		     
		     Thread.sleep(1000);
		     
			 Admin_SslDashBoardElements.SendChangePasswordEmailButtonClick();
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 test.log(LogStatus.INFO, "Clicked On ChangePassword Request Email");
			    
			 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			 driver.switchTo().alert().accept();
			 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			 test.log(LogStatus.INFO, "Clicked On Alert");
		     
		     
			 
			}else if (Admin_SslDashBoardElements.User2_LinkContains(UserVal)) {
				
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				Admin_SslDashBoardElements.User2_EditButton();
			    test.log(LogStatus.INFO, "Navigate to Quality Assurance Tester User and Click Edit");
			    
			    Thread.sleep(1000);
			    
			    Admin_SslDashBoardElements.SendChangePasswordEmailButtonClick();
			    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			    test.log(LogStatus.INFO, "Clicked On ChangePassword Request Email");
			    
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				driver.switchTo().alert().accept();
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Clicked On Alert");
				 
			 }else if (Admin_SslDashBoardElements.User3_LinkContains(UserVal)) {
		
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 Admin_SslDashBoardElements.User3_EditButton();
				 test.log(LogStatus.INFO, "Navigate to Quality Assurance Tester User and Click Edit");
				 
				 Thread.sleep(1000);
				 
				 Admin_SslDashBoardElements.SendChangePasswordEmailButtonClick();
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.INFO, "Clicked On ChangePassword Request Email");
				    
				 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				 driver.switchTo().alert().accept();
				 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				 test.log(LogStatus.INFO, "Clicked On Alert");
				 
				 
			 }else if (Admin_SslDashBoardElements.User4_LinkContains(UserVal)) {
				 
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 Admin_SslDashBoardElements.User4_EditButton();
				 test.log(LogStatus.INFO, "Navigate to Quality Assurance Tester User and Click Edit");
				 
				 Thread.sleep(1000);
				 
				 Admin_SslDashBoardElements.SendChangePasswordEmailButtonClick();
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.INFO, "Clicked On ChangePassword Request Email");
				    
				 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				 driver.switchTo().alert().accept();
				 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				 test.log(LogStatus.INFO, "Clicked On Alert");
				 
			 }else  {
				 
				test.log(LogStatus.FAIL, "Test User Account not Found"); 
				System.out.println("Quality Tester User Not Found");
				Assert.fail("Quality Tester User Not Found");
			 }
		 
	}catch (Exception e) {
		
		test.log(LogStatus.FAIL, "Validation Failed");
		Assert.fail("Exception " + e);

	}
		 
		 
		 try {
				String Alertnote = "A reset password has been sent to qa@ssl247.co.uk";  
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
									
				test.log(LogStatus.FAIL, "Validation Failed");
				Assert.fail("Exception " + e);

			}

		 
  }
 
  @Test (priority = 6,groups = {"Sanity","BS_DailySanity"},dataProviderClass =Test_DataSanity.class, dataProvider="ReissueCertificate")
  public void Sync_Cert_WithCA(String AdUsername, String Adpassword, String URL, String Account, String Product) throws Exception {
  	  
  	  test = report.startTest("Admin Test --> Sync Cert With CA");
  	  test.log(LogStatus.INFO, "Admin User Logged in");
  	  
  	  Admin_NavigationLinksElements.ClientsAccountsLinkClick();
  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
  	  test.log(LogStatus.INFO, "Click on clients Accounts Link");
  		 
  	  //ClientAccountsPageElements.ValidatePage();
  	  ClientAccountsPageElements.SearchQueryFieldFill("UK Test");
  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
  	  test.log(LogStatus.INFO, "Click on Search Query and Enter UK Test");
  		 
  	  ClientAccountsPageElements.UpdateButtonClink();
  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
  	  test.log(LogStatus.INFO, "Click on Update Button");
  	  
  	  JavascriptExecutor jse = (JavascriptExecutor)driver;
  	  jse.executeScript("window.scrollBy(0,500)", "");
  		 
  	  Thread.sleep(1000);
  	  
  	  ClientAccountsPageElements.ValidateResults("UKTE001");
  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
  	  test.log(LogStatus.INFO, "Search Resusult is Displayed");
  	  
  	  ClientAccountsPageElements.ViewAccount();
  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
  	  test.log(LogStatus.INFO, "Clicked on UK Test Account in search Result");
  	  
  	  Thread.sleep(2000);
  	  
  	try {
  	 
  	  		test.log(LogStatus.INFO, "DashBord Page Opened");
  	  		
  	  		Admin_SslDashBoardElements.ClickMysslCertificatessLink();
  	  		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
  			test.log(LogStatus.INFO, "Clicked on Myssl Certificates Link");
  	  		
  	  		Admin_SslDashBoardElements.IssuedLinkClick();
  	  		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
  			test.log(LogStatus.INFO, "Clicked on Issued Link");
  			
  	  	  	jse.executeScript("window.scrollBy(0,450)", "");
  	  	  	
  	  	  	Thread.sleep(2000);
  			
  			if (Admin_IssuedCertificatesPage.Column1Contains(Product)) {
  	    		
  	    		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  	    	    test.log(LogStatus.INFO, "Column 1 Contains Products");
  	    		
  	    	    String path = ScreenShot.Image(driver, "Product");
  				String imagePath = test.addScreenCapture(path);
  				test.log(LogStatus.INFO, imagePath);
  	    	    
  				Admin_IssuedCertificatesPage.Column1TextPrint();
  				
  				Admin_IssuedCertificatesPage.Product1View();
  	    		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  	    	    test.log(LogStatus.INFO, "Clicked to view product");
  	    	    
  	    	    Admin_CertificateDetailsPageElements.SyncWithCaButtonClick();
  	    		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  	    	    test.log(LogStatus.INFO, "Clicked on Sync Button");
  	    		
  	    	    
  	    		}else if (Admin_IssuedCertificatesPage.Column2Contains(Product)) {
  	    			
  	    			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  		    	    test.log(LogStatus.INFO, "Column 2 Contains Products");
  		    	    
  		    	    String path = ScreenShot.Image(driver, "Product");
  					String imagePath = test.addScreenCapture(path);
  					test.log(LogStatus.INFO, imagePath);
  					
  					Admin_IssuedCertificatesPage.Column2TextPrint();
  				
  					Admin_IssuedCertificatesPage.Product2View();
  	    			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  		    	    test.log(LogStatus.INFO, "Clicked to view product");
  		    	    
  		    	    Admin_CertificateDetailsPageElements.SyncWithCaButtonClick();
  		    		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  		    	    test.log(LogStatus.INFO, "Clicked on Sync Button");
  	    			
  		    	}else if (Admin_IssuedCertificatesPage.Column3Contains(Product)) {
  	    			
  	    			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  		    	    test.log(LogStatus.INFO, "Column 3 Contains Products");
  		    	    
  		    	    String path = ScreenShot.Image(driver, "Product");
  					String imagePath = test.addScreenCapture(path);
  					test.log(LogStatus.INFO, imagePath);
  					
  					Admin_IssuedCertificatesPage.Column3TextPrint();
  				
  					Admin_IssuedCertificatesPage.Product3View();
  	    			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  		    	    test.log(LogStatus.INFO, "Clicked to view product");
  		    	    
  		    	    Admin_CertificateDetailsPageElements.SyncWithCaButtonClick();
  		    		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  		    	    test.log(LogStatus.INFO, "Clicked on Sync Button");
  		    	    
  		    	}else if (Admin_IssuedCertificatesPage.Column15Contains(Product)) {
  	    			
  	    			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  		    	    test.log(LogStatus.INFO, "Column 10 Contains Products");
  		    	    
  		    	    String path = ScreenShot.Image(driver, "Product");
  					String imagePath = test.addScreenCapture(path);
  					test.log(LogStatus.INFO, imagePath);
  					
  					Admin_IssuedCertificatesPage.Column15TextPrint();
  				
  					Admin_IssuedCertificatesPage.Product15View();
  	    			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  		    	    test.log(LogStatus.INFO, "Clicked to view product");
  		    	    
  		    	    Admin_CertificateDetailsPageElements.SyncWithCaButtonClick();
  		    		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  		    	    test.log(LogStatus.INFO, "Clicked on Sync Button");
    			
  	    	}else {
  				
  				System.out.println("Product Not Found");
  				
  				//AdminIssuedCertificatesPage.Column15TextPrint();
  				
  				test.log(LogStatus.FAIL, "Product Not Found");
  				String path = ScreenShot.Image(driver, "Product");
  				String imagePath = test.addScreenCapture(path);
  				test.log(LogStatus.INFO, imagePath);
  				
  		    	}	
  	  
  		}catch (Exception e) {
  		
  			String path = ScreenShot.Image(driver, "Product");
  			String imagePath = test.addScreenCapture(path);
  			test.log(LogStatus.INFO, imagePath);
  			test.log(LogStatus.FAIL, "Validation Failed");
  			Assert.fail("Exception " + e);

  	}
  	
  	Thread.sleep(1000);
  	
  	  		
  		//Validate Alert	
  		try { 
  			
  			String Alertnote = "Certificate synced with the CA";  
  			AlertBoxElements.AlertWait();
  			
  			if (AlertBoxElements.VerifyAlert(Alertnote)) {
  				
  				Assert.assertTrue(AlertBoxElements.VerifyAlert(Alertnote));
  				test.log(LogStatus.PASS, "Validation Complete");
  				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
  				System.out.println("Validation Complete!");
  				
  			}else {
  					    	
  				test.log(LogStatus.FAIL, "Alert Validation Failed");
  				AlertBoxElements.AlertPrint();
  				//Assert.fail("Validation Failed ");		    	
  			}
  			
  		}catch (Exception e) {
  			
  			String path = ScreenShot.Image(driver, "SearchResult");
  			String imagePath = test.addScreenCapture(path);
  			test.log(LogStatus.FAIL, "Alert not Displayed");
  			test.log(LogStatus.INFO, imagePath);

  		}
  	  
  }
  
  @Test (priority = 7, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void Create_user_Account() throws Exception{
  	  
  		//Search For UK Test User
  	     test = report.startTest("Admin Test --> Create Account");
  	     
  	     test.log(LogStatus.INFO, "Admin User Logged in");
  	  
  		 Admin_NavigationLinksElements.ClientsAccountsLinkMouse();
  		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  		 test.log(LogStatus.INFO, "Moved Mouse to Clients Accounts Link");
  		 
  		 Admin_NavigationLinksElements.NewAccountLinkClick();
  		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  		 test.log(LogStatus.INFO, "Clicked on New Account Link");
  		 
  		 Thread.sleep(1000);
  		 
  		 
  		 try { 
  			 
  		 
  			 AddAccountPageElements.CompanyNameFieldFill("SSL 247-Test");
  			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  			 test.log(LogStatus.INFO, "Filled Company Name");
  			 
  			 AddAccountPageElements.AccountManagerFieldSelect("Daniel Genadiev");
  			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  			 test.log(LogStatus.INFO, "Selected Account Manager");
  			 
  			 AddAccountPageElements.SalesAssistantFieldSelect("Anna Cardinale");
  			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  			 test.log(LogStatus.INFO, "Selected Sales Assistant");
  			 
  			 AddAccountPageElements.TerritoryFieldSelect("United Kingdom");
  			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  			 test.log(LogStatus.INFO, "Selected Territory");
  			 
  			 AddAccountPageElements.VatPrefixFieldSelect("IT");
  			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  			 test.log(LogStatus.INFO, "Selected Prefix");
  			 
  			 AddAccountPageElements.VatNumberFieldFill("01479900217");
  			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  			 test.log(LogStatus.INFO, "Filled VaT Number");
  			 
  			 AddAccountPageElements.CompanyRegNumberFieldFill("1234567");
  			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  			 test.log(LogStatus.INFO, "Filled Reg Number");
  			 
  			 AddAccountPageElements.AccountActivitySectorFieldSelect("Other");
  			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  			 test.log(LogStatus.INFO, "Selected Account Activity Sector");
  			 
  			 AddAccountPageElements.AccountCompanySizeFieldSelect("51-250");
  			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  			 test.log(LogStatus.INFO, "Selected Company Range");
  			 
  			 AddAccountPageElements.RequestPaymentTermsCheckBoxClick();
  			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  			 test.log(LogStatus.INFO, "Ticked Payment Terms Checkbox");
  			 
  			 AddAccountPageElements.DaysToPayFieldSelect("7");
  			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  			 test.log(LogStatus.INFO, "Selected Number Of Days To Pay");
  			 
  			 AddAccountPageElements.DaysToEomCheckBoxClick();
  			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  			 test.log(LogStatus.INFO, "Ticked Days to Pay EOM Checkbox");
  			 
  			 AddAccountPageElements.MinimumPaymentLimitFieldSelect("50");
  			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  			 test.log(LogStatus.INFO, "Selected Minimum Payment Limit");
  			 
  			 AddAccountPageElements.ActiveButtonClick();
  			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  			 test.log(LogStatus.INFO, "Clicked Active Button");
  			 
  			 String path = ScreenShot.Image(driver, "Account");
  			 String imagePath = test.addScreenCapture(path);
  			 test.log(LogStatus.INFO, imagePath);
  			 
  			 AddAccountPageElements.CreateAccountButtonClick();
  			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  			 test.log(LogStatus.INFO, "Clicked Create Account Button");
  			 
  			 
  		 }catch (Exception e) {
  				
  			  String path = ScreenShot.Image(driver, "Account");
  			  String imagePath = test.addScreenCapture(path);
  			  test.log(LogStatus.INFO, imagePath);
  			  test.log(LogStatus.FAIL, "Form Submittion Failed");
  			  driver.navigate().refresh();
  			  Assert.fail("Exception " + e);
  				
  		}	 
  	
  }

}
