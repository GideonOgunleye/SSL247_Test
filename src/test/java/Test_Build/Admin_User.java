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
import BaseUtilities.CsR;
import BaseUtilities.DriverLoad;
import BaseUtilities.ExtentFactory;
import BaseUtilities.TakeScreenShot;
import PageFactory.Admin.Admin_AccountEndUsersPage;
import PageFactory.Admin.Admin_AddAccountPage;
import PageFactory.Admin.Admin_BillingPage;
import PageFactory.Admin.Admin_BulkEditCertContactsPage;
import PageFactory.Admin.Admin_BulkTransferCertsPage;
import PageFactory.Admin.Admin_CertificateDetailsPage;
import PageFactory.Admin.Admin_CertificateValidationPage;
import PageFactory.Admin.Admin_CertificatesPage;
import PageFactory.Admin.Admin_ClientAccountsPage;
import PageFactory.Admin.Admin_CodeSigningCertsValidationPage;
import PageFactory.Admin.Admin_EditUserPage;
import PageFactory.Admin.Admin_IncompleteCertificatesPage;
import PageFactory.Admin.Admin_IncompleteCodeSigningCertsPage;
import PageFactory.Admin.Admin_IncompleteSmimePage;
import PageFactory.Admin.Admin_IssuedCertificatesPage;
import PageFactory.Admin.Admin_LoginPage;
import PageFactory.Admin.Admin_MySslDashBoard;
import PageFactory.Admin.Admin_NavigationLinks;
import PageFactory.Admin.Admin_NewUserPage;
import PageFactory.Admin.Admin_OrdersPage;
import PageFactory.Admin.Admin_OutgoingEmailsLogPage;
import PageFactory.Admin.Admin_PendingCertificatesPage;
import PageFactory.Admin.Admin_ProposalsPage;
import PageFactory.Admin.Admin_SearchCertificatesPage;
import PageFactory.Admin.Admin_ShoppingBasketPage;
import PageFactory.Admin.Admin_SmimeValidationPage;
import PageFactory.Admin.Admin_SslDashBoard;
import PageFactory.Client.Client_CertificateValidationPage;
import PageFactory.Client.Client_LoginPage;
import PageFactory.Client.Client_NavigationLinks;
import Regression_Test.Test_Data;
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
import org.openqa.selenium.Alert;
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

public class Admin_User extends Chrome2 {
	
	AlertBox	AlertBoxElements;
	ExtentReports report;
	ExtentTest test;
	TakeScreenShot ScreenShot;
	CsR CsrElements;
	Admin_AccountEndUsersPage	Admin_AccountEndUsersPageElements;
	Admin_AddAccountPage	Admin_AddAccountPageElements;
	Admin_BillingPage	Admin_BillingPageElements;
	Admin_BulkEditCertContactsPage	Admin_BulkEditCertContactsPageElements;
	Admin_BulkTransferCertsPage	Admin_BulkTransferCertsPageElements;
	Admin_CertificateDetailsPage	Admin_CertificateDetailsPageElements;
	Admin_CertificatesPage	Admin_CertificatesPageElements;
	Admin_CertificateValidationPage	Admin_CertificateValidationPageElements;
	Admin_ClientAccountsPage	Admin_ClientAccountsPageElements;
	Admin_CodeSigningCertsValidationPage	Admin_CodeSigningCertsValidationPageElements;
	Admin_EditUserPage	Admin_EditUserPageElements;
	Admin_IncompleteCertificatesPage	Admin_IncompleteCertificatesPageElements;
	Admin_IncompleteCodeSigningCertsPage	Admin_IncompleteCodeSigningCertsPageElements;
	Admin_IncompleteSmimePage	Admin_IncompleteSmimePageElements;
	Admin_IssuedCertificatesPage	Admin_IssuedCertificatesPageElements;
	Admin_LoginPage	Admin_LoginPageElements;
	Admin_MySslDashBoard	Admin_MySslDashBoardElements;
	Admin_NavigationLinks	Admin_NavigationLinksElements;
	Admin_NewUserPage	Admin_NewUserPageElements;
	Admin_OrdersPage	Admin_OrdersPageElements;
	Admin_OutgoingEmailsLogPage	Admin_OutgoingEmailsLogPageElements;
	Admin_PendingCertificatesPage	Admin_PendingCertificatesPageElements;
	Admin_ProposalsPage	Admin_ProposalsPageElements;
	Admin_SearchCertificatesPage	Admin_SearchCertificatesPageElements;
	Admin_ShoppingBasketPage	Admin_ShoppingBasketPageElements;
	Admin_SmimeValidationPage	Admin_SmimeValidationPageElements;
	Client_CertificateValidationPage	Client_CertificateValidationPageElements;
	Client_LoginPage	Client_LoginPageElements;
	
	
@BeforeMethod (groups = {"Smoke","BS_Smoke"})
public void Login() throws Exception {

	/*	  Admin_LoginPageElements = new Admin_LoginPage(driver);
		  Admin_BillingPageElements = new Admin_BillingPage(driver);
		  Admin_MySslDashBoardElements = new Admin_MySslDashBoard(driver);
		  Admin_MySslDashBoardElements = new Admin_MySslDashBoard(driver);
		  AlertBoxElements = new AlertBox(driver);
		  Admin_ProposalsPageElements = new Admin_ProposalsPage(driver);
		  Admin_NavigationLinksElements = new Admin_NavigationLinks(driver);
		  Admin_ClientAccountsPageElements = new Admin_ClientAccountsPage(driver);
		  Admin_CertificatesPageElements = new Admin_CertificatesPage(driver);
		  Admin_IssuedCertificatesPageElements = new Admin_IssuedCertificatesPage(driver);
		  Admin_CertificateDetailsPageElements = new Admin_CertificateDetailsPage(driver);
		  Admin_AddAccountPageElements = new Admin_AddAccountPage(driver);
		  ScreenShot = new TakeScreenShot();
		  Admin_OutgoingEmailsLogPageElements = new  Admin_OutgoingEmailsLogPage(driver);
	*/
	
	AlertBoxElements	= new AlertBox(driver);
	CsrElements	= new CsR(driver);
	ScreenShot	= new TakeScreenShot();
	Admin_AccountEndUsersPageElements	= new Admin_AccountEndUsersPage(driver);
	Admin_AddAccountPageElements	= new Admin_AddAccountPage(driver);
	Admin_BillingPageElements	= new Admin_BillingPage(driver);
	Admin_BulkEditCertContactsPageElements	= new Admin_BulkEditCertContactsPage(driver);
	Admin_BulkTransferCertsPageElements	= new Admin_BulkTransferCertsPage(driver);
	Admin_CertificateDetailsPageElements	= new Admin_CertificateDetailsPage(driver);
	Admin_CertificatesPageElements	= new Admin_CertificatesPage(driver);
	Admin_CertificateValidationPageElements	= new Admin_CertificateValidationPage(driver);
	Admin_ClientAccountsPageElements	= new Admin_ClientAccountsPage(driver);
	Admin_CodeSigningCertsValidationPageElements	= new Admin_CodeSigningCertsValidationPage(driver);
	Admin_EditUserPageElements	= new Admin_EditUserPage(driver);
	Admin_IncompleteCertificatesPageElements	= new Admin_IncompleteCertificatesPage(driver);
	Admin_IncompleteCodeSigningCertsPageElements	= new Admin_IncompleteCodeSigningCertsPage(driver);
	Admin_IncompleteSmimePageElements	= new Admin_IncompleteSmimePage(driver);
	Admin_IssuedCertificatesPageElements	= new Admin_IssuedCertificatesPage(driver);
	Admin_LoginPageElements	= new Admin_LoginPage(driver);
	Admin_MySslDashBoardElements	= new Admin_MySslDashBoard(driver);
	Admin_NavigationLinksElements	= new Admin_NavigationLinks(driver);
	Admin_NewUserPageElements	= new Admin_NewUserPage(driver);
	Admin_OrdersPageElements	= new Admin_OrdersPage(driver);
	Admin_OutgoingEmailsLogPageElements	= new Admin_OutgoingEmailsLogPage(driver);
	Admin_PendingCertificatesPageElements	= new Admin_PendingCertificatesPage(driver);
	Admin_ProposalsPageElements	= new Admin_ProposalsPage(driver);
	Admin_SearchCertificatesPageElements	= new Admin_SearchCertificatesPage(driver);
	Admin_ShoppingBasketPageElements	= new Admin_ShoppingBasketPage(driver);
	Admin_SmimeValidationPageElements	= new Admin_SmimeValidationPage(driver);
	Client_CertificateValidationPageElements	 = new Client_CertificateValidationPage(driver);
	Client_LoginPageElements	 = new Client_LoginPage(driver);
	
	
	
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
			
			test.log(LogStatus.FAIL, "Admin Logout Failed");
			test.log(LogStatus.INFO, e);
			String path2 = ScreenShot.Image(driver, "Logout");
			String imagePath2 = test.addScreenCapture(path2);
			test.log(LogStatus.INFO, imagePath2);
			report.endTest(test);
			report.flush();
			System.out.println("Exception " + e);
			//Assert.fail("Exception " + e);
	}
	 
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
	 
	 
}

//TODO
@Test (priority = 1, groups = {"Regression","BS_Regression","Regression_Chrome"},dataProviderClass = Test_Data.class, dataProvider="Certificate_WithSAN_ProposalsOrder_Data")
  public void Ssl_Certificates_WithSAN_Plus_WildCard_Proposals (String ProductType, String Product, String Quantity, String Duration, String License, String CommonName) throws Exception {
	  
	  test = report.startTest("Admin Test --> Proposals Order Test + SAN - " + Product);
	  
	  Properties prop = new Properties();
	  FileInputStream fis = new FileInputStream(Constants.File_Path + Constants.DataFile_Name);
	  
	  prop.load(fis);
	     
	  test.log(LogStatus.INFO, "Browser Opened and Url Enterl");
	  test.log(LogStatus.INFO, "Logged in as Admin");
	  
	  System.out.println("Started Proposal For:------------------ " + Product);
	  
	try {
		
		  Admin_NavigationLinksElements.ClientsAccountsLinkClick();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Click on clients Accounts Link");
		  
		  Admin_ClientAccountsPageElements.ValidatePage();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Click Account Page Validated");
			 
			 
		  Admin_ClientAccountsPageElements.SearchQueryFieldFill("UK Test");
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Click on Search Query and Enter UK Test");
			 
		  Admin_ClientAccountsPageElements.UpdateButtonClink();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Click on Update Button");
			
		}catch (Exception e){
			
			test.log(LogStatus.FAIL, "Element Not Found");
			test.log(LogStatus.INFO, e);
			System.out.println("Element Not Found");
			String path2 = ScreenShot.Image(driver, "Element");
			String imagePath2 = test.addScreenCapture(path2);
			test.log(LogStatus.INFO, imagePath2);
			report.endTest(test);
			report.flush();
			System.out.println("Exception" + e);
			Assert.fail("Exception " + e);
			
	}
	  
	  
	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	  jse.executeScript("window.scrollBy(0,500)", "");
		 
	  Thread.sleep(5000);
	  
	try {
		
		  Admin_ClientAccountsPageElements.ValidateResults("UKTE001");
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Search Resusult is Displayed");
			 
		  Admin_ClientAccountsPageElements.ViewAccount();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Click on UK Test Account in search Result");
		     
		  Thread.sleep(1000);
		  
		  Admin_MySslDashBoardElements.ClickMyProposalsLink();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Clicked on proposal link");
			
		}catch (Exception e){
			
			test.log(LogStatus.FAIL, "Element Not Found");
			test.log(LogStatus.INFO, e);
			System.out.println("Element Not Found");
			String path2 = ScreenShot.Image(driver, "Element");
			String imagePath2 = test.addScreenCapture(path2);
			test.log(LogStatus.INFO, imagePath2);
			report.endTest(test);
			report.flush();
			System.out.println("Exception" + e);
			Assert.fail("Exception " + e);
			
		}
	  
	  //JavascriptExecutor jse = (JavascriptExecutor)driver;
	  //jse.executeScript("window.scrollBy(0,500)", "");
	  
	  Thread.sleep(2000);
	 
	  try {
		  
			  Admin_ProposalsPageElements.NewProposalButtonClink();
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Clicked on New Proposal Button");
			  
			  jse.executeScript("window.scrollBy(0,500)", "");
			  
			  Thread.sleep(2000);
			  
			  //Select Product Type
			  Admin_ProposalsPageElements.ProductTypeFieldSelect(ProductType);
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Selected Product Type");
			  
			  Thread.sleep(1000);
			  
			  //Select Product 
			  Admin_ProposalsPageElements.ProductFieldSelect(Product);
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Selected Product");
			  
			  Thread.sleep(1000);
			
			try {  
				
			  //Select Quantity
			  Admin_ProposalsPageElements.QuantityFieldClear();
			  Admin_ProposalsPageElements.QuantityFieldSenkeys(Quantity);
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Selected Quantity");
			  
	  		}catch (Exception p) {
			
	  			String path = ScreenShot.Image(driver, "Proposal");
	  			test.log(LogStatus.INFO, p);
	  			String imagePath = test.addScreenCapture(path);
	  			test.log(LogStatus.INFO, imagePath);
	  			test.log(LogStatus.INFO, "Duration not Selected");
	  			//Assert.fail("Exception " + e);

	  		}
			  
			  
			  Thread.sleep(1000);
			  
			//Select Duration
			  try {
				
				  Admin_ProposalsPageElements.DurationFieldSelect(Duration);
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Selected Duration");
			  
			  }catch (Exception p) {
					
				  String path = ScreenShot.Image(driver, "Proposal");
				  test.log(LogStatus.INFO, p);
				  String imagePath = test.addScreenCapture(path);
				  test.log(LogStatus.INFO, imagePath);
				  test.log(LogStatus.INFO, "Duration not Selected");
				  //Assert.fail("Exception " + e);

				}
			  
			  Thread.sleep(1000);
			  
			  //Select Number of Licenses
			  try {  
				  
				  Admin_ProposalsPageElements.LicenseFieldSelect(License);
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Selected Duration");
			  
			  }catch (Exception p) {
					
				  String path = ScreenShot.Image(driver, "Proposal");
				  test.log(LogStatus.INFO, p);
				  String imagePath = test.addScreenCapture(path);
				  test.log(LogStatus.INFO, imagePath);
				  test.log(LogStatus.INFO, "Licence Field Not Clickable");
				  //Assert.fail("Exception " + e);

				}
			  

			  Thread.sleep(1000);
			  
			  //Fill Common Name Field
			  try { 
				 
				  Admin_ProposalsPageElements.CommonNameFieldClear();
				  Admin_ProposalsPageElements.CommonNameFieldSendKeys(CommonName);
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Entered Common Name");
			  
			  }catch (Exception e) {
			
				  String path = ScreenShot.Image(driver, "Proposal");
				  test.log(LogStatus.INFO, e);
				  String imagePath = test.addScreenCapture(path);
				  test.log(LogStatus.INFO, imagePath);
				  test.log(LogStatus.INFO, "Common Name Field Not Clickable");
				  //Assert.fail("Exception " + e);
		
			  }
			  
			  Thread.sleep(1000);
			  
			  //Enter SAN
			  
			  try {
				  
				  Admin_ProposalsPageElements.SanFieldSendKeys("ssl247-test.com");
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Entered Common Name in SAN Field");
				  
			  }catch (Exception e) {
				  
				  String path = ScreenShot.Image(driver, "Proposal");
				  test.log(LogStatus.INFO, e);
				  String imagePath = test.addScreenCapture(path);
				  test.log(LogStatus.INFO, imagePath);
				  test.log(LogStatus.FATAL, "Error with SAN Field");
				  System.out.println("Exception " + e);
			  }
			  
			  Thread.sleep(1000);
			  
			  //Click Calculate Prices Button
			  
			  Admin_ProposalsPageElements.CalculatePricesButtonClink();
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Click on Calculate Prices Button");
			  
			  Thread.sleep(1000);
			  
			  jse.executeScript("window.scrollBy(0,500)", "");
			  String path = ScreenShot.Image(driver, "Proposal");
			  String imagePath = test.addScreenCapture(path);
			  test.log(LogStatus.INFO, imagePath);
			  
			  Thread.sleep(1000);
				
			  //Click Save 
			
			  Admin_ProposalsPageElements.SaveProposalButtonClink();
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Click on Save Proposal Button");
			  
		   	  jse.executeScript("window.scrollBy(0,250)", "");
			  	
		  	  Thread.sleep(1000);
			  
			  Admin_ProposalsPageElements.IssueProposalTabClink();
		  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  	  test.log(LogStatus.INFO, "Clicked on Issue Proposal Tab");
		  	  
		   	  jse.executeScript("window.scrollBy(0,250)", "");
			  	
		  	  Thread.sleep(1000);
			  	
			  Admin_ProposalsPageElements.ConfirmCheckBoxOneClink();
		  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  	  test.log(LogStatus.INFO, "Clicked on Chec Box One");
			  	
			  Thread.sleep(1000);
			  Admin_ProposalsPageElements.ConfirmCheckBoxTwoClink();
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  	  test.log(LogStatus.INFO, "Clicked on Chec Box two");
			  	
			  Thread.sleep(1000);
			  	
			  Admin_ProposalsPageElements.IssueProposalButtonClink();
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  	  test.log(LogStatus.INFO, "Clicked on Issue Proposal Button");
		  	  
		  	  Thread.sleep(2000);
		  	  jse.executeScript("window.scrollBy(0,500)", "");
		  	  
		  	  
		  	  Admin_ProposalsPageElements.ConvertToInvoiceButtonClink();
		  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  	  test.log(LogStatus.INFO, "Clicked Covert to Invoice Button");
		  	  
	   }catch (Exception e) {
			
		   	String path = ScreenShot.Image(driver, "Proposal");
		   	test.log(LogStatus.INFO, e);
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.INFO, imagePath);
			test.log(LogStatus.FAIL, "Test Failed");
			driver.navigate().refresh();
			Assert.fail( Product +" - Exception: "+ e);
			
		}
		  	  //jse.executeScript("window.scrollBy(0,500)", "");
		  	  //Thread.sleep(1000);
		  	  
		  	try {
		  		
			  	  Alert alert = driver.switchTo().alert();
			  	  alert.accept();
			  	  test.log(LogStatus.INFO, "Clicked on Alert");
			  	  
			  	  jse.executeScript("window.scrollBy(0,500)", "");
		        
		    } catch (Exception e) {
		    	
		    	System.out.println("Alert Not Handled");
		    }
		  	
		  	
		     //Admin User Log Out------------------------------------------------------------------
			
			 try{ 
				 
				 if(Admin_LoginPageElements.AdminLogoutButtonIsVisible()) {
		  			   
		  			 Admin_LoginPageElements.ClickAdminLogoutButton();
			  		 test.log(LogStatus.PASS, "Admin-Logout Logged Out");
			  		 String path2 = ScreenShot.Image(driver, "Logout");
			  		 String imagePath2 = test.addScreenCapture(path2);
			  		 test.log(LogStatus.INFO, imagePath2);
					 
				 }else {
					 
					 test.log(LogStatus.FAIL, "Admin-Logout not visible");
					 String path2 = ScreenShot.Image(driver, "Logout");
					 String imagePath2 = test.addScreenCapture(path2);
					 test.log(LogStatus.INFO, imagePath2);
					 report.endTest(test);
					 report.flush();
					 Assert.fail("Log Out not visible");
					 driver.quit();
				 }
		
			 }catch (Exception e) {
					
					test.log(LogStatus.FAIL, "Admin-Logout Failed");
					test.log(LogStatus.INFO, e);
					String path2 = ScreenShot.Image(driver, "Logout");
					String imagePath2 = test.addScreenCapture(path2);
					test.log(LogStatus.INFO, imagePath2);
					report.endTest(test);
					report.flush();
					Assert.fail("Log Out Failed- "+"Exception: " + e);
					driver.quit();
					
				} 
			
			 
			//Client Login---------------------------------------------------------------------
			 
			try {
				   
				
				  Admin_LoginPageElements.EnterUserName("qa@ssl247.co.uk");
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Entereed UserName");
				  
				  Admin_LoginPageElements.EnterPassword("Test1234");
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Entered Password");
				  
				  Admin_LoginPageElements.ClickLoginButton();
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Clicked Login Button");
				  
				  test.log(LogStatus.PASS, "Client Logged In Successfully");
				  String path2 = ScreenShot.Image(driver, "Proposal");
				  String imagePath2 = test.addScreenCapture(path2);
				  test.log(LogStatus.INFO, imagePath2);
			  
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
			 
			 
			 Thread.sleep(2000);	
			 
			//Validate Certificate 
			 
		try {
			
			Admin_MySslDashBoardElements.MysslCertificatessLinkClick();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked on mY SSL Certificates Link");
			
			Admin_MySslDashBoardElements.IncompleteLinkClick();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked on Incomplete Link");
			
			Admin_IncompleteCertificatesPageElements.Column1EditButtonClick();
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked to view certificate on First Row");
			
			Thread.sleep(2000);
			
			test.log(LogStatus.PASS, "Saved Order Found");
			String path = ScreenShot.Image(driver, "Proposal");
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.INFO, imagePath);
			
		}catch (Exception e){
			
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
		
		//Certificate Details Tab-------------------------------------------------------------------------		
		try {	
				Client_CertificateValidationPageElements.CertificatesDetailsTabClick();
			    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Clicked on Certificate Details Tab");	
				
				Thread.sleep(2000);
			  	jse.executeScript("window.scrollBy(0,500)", "");
				
				Client_CertificateValidationPageElements.CsrFieldClick();;
			    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Clicked on CSR Field");	
			
				Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Para1"));
				Client_CertificateValidationPageElements.HitEnterKey();
				Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Para2"));
				Client_CertificateValidationPageElements.HitEnterKey();
				Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Para3"));
				Client_CertificateValidationPageElements.HitEnterKey();;
				Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Para4"));
				Client_CertificateValidationPageElements.HitEnterKey();
				Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Para5"));
				Client_CertificateValidationPageElements.HitEnterKey();
				Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Para6"));
				Client_CertificateValidationPageElements.HitEnterKey();
				Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Para7"));
				Client_CertificateValidationPageElements.HitEnterKey();
				Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Para8"));
				Client_CertificateValidationPageElements.HitEnterKey();
				Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Para9"));
				Client_CertificateValidationPageElements.HitEnterKey();
				Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Para10"));
				Client_CertificateValidationPageElements.HitEnterKey();
				Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Para11"));
				Client_CertificateValidationPageElements.HitEnterKey();
				Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Para12"));
				Client_CertificateValidationPageElements.HitEnterKey();
				Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Para13"));
				Client_CertificateValidationPageElements.HitEnterKey();
				Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Para14"));
				Client_CertificateValidationPageElements.HitEnterKey();
				Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Para15"));
				Client_CertificateValidationPageElements.HitEnterKey();
				Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Para16"));
				Client_CertificateValidationPageElements.HitEnterKey();
				Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Para17"));
				Client_CertificateValidationPageElements.HitEnterKey();
				
				test.log(LogStatus.PASS, "Certificate Details Tab Filled");
				String path2 = ScreenShot.Image(driver, "Proposal");
				String imagePath2 = test.addScreenCapture(path2);
				test.log(LogStatus.INFO, imagePath2);
				
		  }catch (Exception e) {
				
				test.log(LogStatus.FAIL, "Error iN Certails Tab");
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
			  	jse.executeScript("window.scrollBy(0,-500)", "");
			  	
			 //Admin Tab----------------------------------------------------------
			 try {  	
				 
			  	Client_CertificateValidationPageElements.AdminTabClick();
			    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Clicked Admin Tab");	
				
				Client_CertificateValidationPageElements.AdminNameFieldSelect("Gideon Ogunleye");
			    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Selected Admin contact name");	
				
				Client_CertificateValidationPageElements.AdminOrganisationFieldFill("SSL247  SARL");
			    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Filled Admin Organisation Name");
				
				Thread.sleep(1000);
			  	jse.executeScript("window.scrollBy(0,500)", "");
			  	
	
				test.log(LogStatus.PASS, "Admin Tab Filled");
				String path2 = ScreenShot.Image(driver, "Proposal");
				String imagePath2 = test.addScreenCapture(path2);
				test.log(LogStatus.INFO, imagePath2);
				
			  }catch (Exception e) {
					
					test.log(LogStatus.FAIL, "Error In Admin Tab");
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
			  	jse.executeScript("window.scrollBy(0,-900)", "");
			  	
			  //Technical Tab--------------------------------------------------------------------------------	
			  try {
				  
				  Client_CertificateValidationPageElements.TechnicalTabClick();
				  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Click on Technical Tab");
				  
				  Client_CertificateValidationPageElements.TechnicalNameFieldSelect("Gideon Ogunleye");
				  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Selected Technical Contact");
				  
				  Client_CertificateValidationPageElements.TechnicalOrganisationFieldFill("SSL247 SARL");
				  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Filled Tech Organisation Field");
				  
				  Thread.sleep(1000);
				  jse.executeScript("window.scrollBy(0,500)", "");
				  
				  test.log(LogStatus.PASS, "Tech Tab Filled");
				  String path2 = ScreenShot.Image(driver, "Proposal");
				  String imagePath2 = test.addScreenCapture(path2);
				  test.log(LogStatus.INFO, imagePath2);
				  
			  }catch (Exception e) {
					
					test.log(LogStatus.WARNING, "Error In Technical Tab");
					test.log(LogStatus.INFO, e);
					System.out.println("Element Not Found");
					String path2 = ScreenShot.Image(driver, "Element");
					String imagePath2 = test.addScreenCapture(path2);
					test.log(LogStatus.INFO, imagePath2);
					//report.endTest(test);
					//report.flush();
					//Assert.fail("Exception " + e);
				}
			  
			Thread.sleep(1000);
			jse.executeScript("window.scrollBy(0,-900)", "");
			

			//Organisation Tab-------------------------------------------------------------------------------------------
			try {
				
				Client_CertificateValidationPageElements.OrganisationTabClick();	
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Clicked Organisation Tab");
				
				Client_CertificateValidationPageElements.OrganisationLegalNameFieldFill("SSL247 LTD");	
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Filled Organisation Legal Name Field");
				
				Client_CertificateValidationPageElements.OrganisationCategoryFieldSelect("Registered company or corporation");
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Selected Organisation Category");
				
				Client_CertificateValidationPageElements.OrganisationRegistrationNumberFieldFill("05802692");
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Filled Organisation Rgistration Number");
				
				test.log(LogStatus.PASS, "Organisation Tab Filled");
				String path2 = ScreenShot.Image(driver, "Proposal");
				String imagePath2 = test.addScreenCapture(path2);
				test.log(LogStatus.INFO, imagePath2);
				
				
			}catch (Exception e) {
				
				test.log(LogStatus.WARNING, "Error In Organisation Tab");
				test.log(LogStatus.INFO, e);
				System.out.println("Element Not Found");
				String path2 = ScreenShot.Image(driver, "Element");
				String imagePath2 = test.addScreenCapture(path2);
				test.log(LogStatus.INFO, imagePath2);
				//report.endTest(test);
				//report.flush();
				//Assert.fail("Exception " + e);
			}
			  	
			Thread.sleep(1000);
		  	jse.executeScript("window.scrollBy(0,-900)", "");
		  	

			
			try {
				
			  	Client_CertificateValidationPageElements.SubmitCertForIssuanceButtonClick();
			  	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Clicked Submit Certificate For Issuance Button");
				
				Thread.sleep(1000);
				
				if (Admin_PendingCertificatesPageElements.PageHeader().contains("Pending Certificates")) {
					
					test.log(LogStatus.PASS, "Test Validation Passed");
					
				}else {
					
					test.log(LogStatus.FAIL, "Test Validation Failed");
					Assert.fail("Test Validation Failed");
				}
				
				
			}catch (Exception e) {
				
				test.log(LogStatus.FATAL, "Error with Validation Failed");
				test.log(LogStatus.INFO, e);
				System.out.println("Validation Failed");
				String path2 = ScreenShot.Image(driver, "Element");
				String imagePath2 = test.addScreenCapture(path2);
				test.log(LogStatus.INFO, imagePath2);
				report.endTest(test);
				report.flush();
				Assert.fail("Exception " + e);
				
			}
			

/*			//Validate Alert-----------------------------------------------------------------------------
			try {
				
				String Alertnote = "The certificate has been saved and is pending submission with the CA";
				AlertBoxElements.AlertWait();
				    	
				if (AlertBoxElements.VerifyAlert(Alertnote)) {
							
				    	test.log(LogStatus.PASS, "Validation Complete");
				    	Assert.assertTrue(AlertBoxElements.VerifyAlert(Alertnote));
				    	System.out.println("Order Cert Completed!");
				    	
				    }else{
				    	
				    	test.log(LogStatus.FAIL, "Validation Failed");
				    	AlertBoxElements.AlertPrint();
						Assert.fail("Validation Failed ");
				    }
		
			}catch (Exception e) {
							
				test.log(LogStatus.FAIL, "Validation Failed");
				Assert.fail("Exception " + e);
			}		*/	
		
		  	  
	  
  }

//Main Test Starts Here



}
