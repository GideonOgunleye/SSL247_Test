package Regression_Test;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilities.AlertBox;
import BaseUtilities.BrowserStack;
import BaseUtilities.Chrome2;
import BaseUtilities.Constants;
import BaseUtilities.CsR;
import BaseUtilities.DriverLoad;
import BaseUtilities.ExtentFactory;
import BaseUtilities.TakeScreenShot;
import PageFactory.Admin.Admin_AddAccountPage;
import PageFactory.Admin.Admin_BillingPage;
import PageFactory.Admin.Admin_CertificateDetailsPage;
import PageFactory.Admin.Admin_CertificateValidationPage;
import PageFactory.Admin.Admin_CertificatesPage;
import PageFactory.Admin.Admin_ClientAccountsPage;
import PageFactory.Admin.Admin_LoginPage;
import PageFactory.Admin.Admin_MySslDashBoard;
import PageFactory.Admin.Admin_NavigationLinks;
import PageFactory.Admin.Admin_OutgoingEmailsLogPage;
import PageFactory.Admin.Admin_PendingCertificatesPage;
import PageFactory.Admin.Admin_ProposalsPage;
import PageFactory.Admin.Admin_SslDashBoard;
import PageFactory.Admin.Admin_IncompleteCertificatesPage;
import PageFactory.Client.Client_AccountEndUsersPage;
import PageFactory.Client.Client_AddAccountPage;
import PageFactory.Client.Client_AddToBasketPage;
import PageFactory.Client.Client_BillingPage;
import PageFactory.Client.Client_CertificateDetailsPage;
import PageFactory.Client.Client_CertificateValidationPage;
import PageFactory.Client.Client_CertificatesPage;
import PageFactory.Client.Client_ClientAccountsPage;
import PageFactory.Client.Client_CodeSigningCertsValidationPage;
import PageFactory.Client.Client_DomainNamesEditPage;
import PageFactory.Client.Client_EditUserPage;
import PageFactory.Client.Client_IncompleteCertificatesPage;
import PageFactory.Client.Client_IncompleteCodeSigningCertsPage;
import PageFactory.Client.Client_IncompleteSmimePage;
import PageFactory.Client.Client_IssuedCertificatesPage;
import PageFactory.Client.Client_LoginPage;
import PageFactory.Client.Client_MyProductsPage;
import PageFactory.Client.Client_MySslDashBoard;
import PageFactory.Client.Client_MyUsersPage;
import PageFactory.Client.Client_NavigationLinks;
import PageFactory.Client.Client_PendingCertificatesPage;
import PageFactory.Client.Client_RegisterDomainPage;
import PageFactory.Client.Client_ShoppingBasketPage;
import PageFactory.Client.Client_SmimeValidationPage;
import PageFactory.Client.Client_ViewOrderPage;

public class Proposal_Orders extends BrowserStack {
	
	ExtentReports report;
	ExtentTest test;
	
	/*	Client_LoginPage 	LoginPageElements;
	Client_BillingPage BillingPageElements;
	Client_MySslDashBoard sslDashBoardElements;
	AlertBox AlertBoxElements;
	TakeScreenShot ScreenShot;
	CsR CsrElements;
	Admin_NavigationLinks Admin_NavigationLinksElements;
	Admin_CertificatesPage Admin_CertificatesPageElements;
	Client_NavigationLinks NavigationLinksElements;
	Admin_SslDashBoard Admin_SslDashBoardElements;
	Admin_ProposalsPage ProposalsPageElements;
	Client_ClientAccountsPage ClientAccountsPageElements;
	Client_IncompleteCertificatesPage IncompleteCertificatesPageElements;
	Client_CertificateValidationPage CertificateValidationPageElements;
	Client_PendingCertificatesPage PendingCertificatesPageElements;
*/
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
	  PageFactory.Admin.Admin_IssuedCertificatesPage Admin_IssuedCertificatesPage;
	  Admin_CertificateDetailsPage Admin_CertificateDetailsPageElements;
	  Admin_AddAccountPage Admin_AddAccountPageElements;
	  TakeScreenShot ScreenShot;
	  Admin_CertificateValidationPage Admin_CertificateValidationPageElements;
	  Admin_OutgoingEmailsLogPage Admin_OutgoingEmailsLogPageElements;
	  Admin_PendingCertificatesPage Admin_PendingCertificatesPageElements;
	  Admin_IncompleteCertificatesPage Admin_IncompleteCertificatesPageElements;
	  //Admin_CertificateValidationPage ACertificateValidationPageElements;
	  
		Client_AccountEndUsersPage	Client_AccountEndUsersPageElements;
		Client_AddAccountPage	Client_AddAccountPageElements;
		Client_AddToBasketPage	Client_AddToBasketPageElemnts;
		Client_BillingPage	Client_BillingPageElements;
		Client_CertificateDetailsPage	Client_CertificateDetailsPageElements;
		Client_CertificatesPage	Client_CertificatesPageElements;
		Client_CertificateValidationPage	Client_CertificateValidationPageElements;
		Client_ClientAccountsPage	Client_ClientAccountsPageElements;
		Client_CodeSigningCertsValidationPage	Client_CodeSigningCertsValidationPageElements;
		Client_DomainNamesEditPage	Client_DomainNamesEditPageElements;
		Client_EditUserPage	Client_EditUserPageElements;
		Client_IncompleteCertificatesPage	Client_IncompleteCertificatesPageElements;
		Client_IncompleteCodeSigningCertsPage	Client_IncompleteCodeSigningCertsPageElements;
		Client_IncompleteSmimePage	Client_IncompleteSmimePageElements;
		Client_IssuedCertificatesPage	Client_IssuedCertificatesPageElements;
		Client_LoginPage	Client_LoginPageElements;
		Client_MyProductsPage	Client_MyProductsPageElements;
		Client_MySslDashBoard	Client_MySslDashBoardElements;
		Client_MyUsersPage	Client_MyUsersPageElements;
		Client_NavigationLinks	Client_NavigationLinksElements;
		Client_PendingCertificatesPage	Client_PendingCertificatesPageElements;
		Client_RegisterDomainPage	Client_RegisterDomainPageElements;
		Client_ShoppingBasketPage	Client_ShoppingBasketPageElements;
		Client_SmimeValidationPage	Client_SmimeValidationPageElements;
		Client_ViewOrderPage	Client_ViewOrderPageElements;
	  
	  
	
	
	@BeforeMethod (groups = {"Regression","BS_Regression","Regression_Chrome"})
	public void User_Login () throws Exception {
		 
/*		LoginPageElements = new Client_LoginPage(driver);
		BillingPageElements = new Client_BillingPage(driver);
		sslDashBoardElements = new Client_MySslDashBoard(driver);
		AlertBoxElements = new AlertBox(driver);
		ScreenShot = new TakeScreenShot();
		CsrElements = new CsR(driver);
		Admin_SslDashBoardElements = new Admin_SslDashBoard(driver);
		ProposalsPageElements = new Admin_ProposalsPage(driver);
		NavigationLinksElements = new Client_NavigationLinks(driver);
		Admin_NavigationLinksElements = new Admin_NavigationLinks(driver);
		ClientAccountsPageElements = new Client_ClientAccountsPage(driver);
		Admin_CertificatesPageElements = new Admin_CertificatesPage(driver);
		IncompleteCertificatesPageElements = new Client_IncompleteCertificatesPage(driver);
		CertificateValidationPageElements = new Client_CertificateValidationPage(driver);
		PendingCertificatesPageElements = new Client_PendingCertificatesPage(driver);
*/
		//TODO
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
		  Admin_IssuedCertificatesPage = new PageFactory.Admin.Admin_IssuedCertificatesPage(driver);
		  Admin_CertificateDetailsPageElements = new Admin_CertificateDetailsPage(driver);
		  Admin_AddAccountPageElements = new Admin_AddAccountPage(driver);
		  ScreenShot = new TakeScreenShot();
		  Admin_OutgoingEmailsLogPageElements = new  Admin_OutgoingEmailsLogPage(driver);
		  Admin_CertificateValidationPageElements = new Admin_CertificateValidationPage(driver);
		  Admin_PendingCertificatesPageElements = new Admin_PendingCertificatesPage(driver);
		  Admin_IncompleteCertificatesPageElements = new Admin_IncompleteCertificatesPage(driver);
		  Admin_CertificateValidationPageElements = new Admin_CertificateValidationPage(driver);
		  
		  Client_AccountEndUsersPageElements	 = new Client_AccountEndUsersPage(driver);
		  Client_AddAccountPageElements	 = new Client_AddAccountPage(driver);
		  Client_AddToBasketPageElemnts	 = new Client_AddToBasketPage(driver);
		  Client_BillingPageElements	 = new Client_BillingPage(driver);
		  Client_CertificateDetailsPageElements	 = new Client_CertificateDetailsPage(driver);
		  Client_CertificatesPageElements	 = new Client_CertificatesPage(driver);
		  Client_CertificateValidationPageElements	 = new Client_CertificateValidationPage(driver);
		  Client_ClientAccountsPageElements	 = new Client_ClientAccountsPage(driver);
		  Client_CodeSigningCertsValidationPageElements	 = new Client_CodeSigningCertsValidationPage(driver);
		  Client_DomainNamesEditPageElements	 = new Client_DomainNamesEditPage(driver);
		  Client_EditUserPageElements	 = new Client_EditUserPage(driver);
		  Client_IncompleteCertificatesPageElements	 = new Client_IncompleteCertificatesPage(driver);
		  Client_IncompleteCodeSigningCertsPageElements	 = new Client_IncompleteCodeSigningCertsPage(driver);
		  Client_IncompleteSmimePageElements	 = new Client_IncompleteSmimePage(driver);
		  Client_IssuedCertificatesPageElements	 = new Client_IssuedCertificatesPage(driver);
		  Client_LoginPageElements	 = new Client_LoginPage(driver);
		  Client_MyProductsPageElements	 = new Client_MyProductsPage(driver);
		  Client_MySslDashBoardElements	 = new Client_MySslDashBoard(driver);
		  Client_MyUsersPageElements	 = new Client_MyUsersPage(driver);
		  Client_NavigationLinksElements	 = new Client_NavigationLinks(driver);
		  Client_PendingCertificatesPageElements	 = new Client_PendingCertificatesPage(driver);
		  Client_RegisterDomainPageElements	 = new Client_RegisterDomainPage(driver);
		  Client_ShoppingBasketPageElements	 = new Client_ShoppingBasketPage(driver);
		  Client_SmimeValidationPageElements	 = new Client_SmimeValidationPage(driver);
		  Client_ViewOrderPageElements	 = new Client_ViewOrderPage(driver);

		
		
		Thread.sleep(5000);
		
		  report = ExtentFactory.getInstance2();
		  

		
		//Log in as administrator
		Admin_LoginPageElements.AdminLogin();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		
	}	
	
	@AfterMethod (groups = {"Regression","BS_Regression","Regression_Chrome"}, alwaysRun = true)
	public void User_Logout (ITestResult result) throws Exception {
		
	
	    //Take Screen Shots

		String path =  ScreenShot.Image(driver, "TestSecreenShot-" + result.getMethod().getMethodName());
		String imagePath = test.addScreenCapture(path);
		test.log(LogStatus.INFO, "Test Complete", imagePath);
		
		Thread.sleep(1000);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)", "");
		
		try {
			
			  driver.navigate().refresh();
	  		
		  	  Alert alert = driver.switchTo().alert();
		  	  alert.accept();
		  	  test.log(LogStatus.INFO, "Clicked on Alert");
		  	  
		  	  jse.executeScript("window.scrollBy(0,500)", "");
	        
	    } catch (Exception e) {
	    	
	    	  System.out.println("Alert Not Handled");
	    	  
	    }
		
		Thread.sleep(1000);
		
		//Try Client Logout	 -------------------------------------------------------------------------------
	  	try{ 
	  		
	  		   Thread.sleep(1000);
	  		   
	  		   if(Admin_LoginPageElements.LogoutButtonIsVisible()) {
	  			   
	  			 Admin_LoginPageElements.ClickLogoutButton();
		  		 test.log(LogStatus.INFO, "After Method-Client User Logged Out");
		  		 String path2 = ScreenShot.Image(driver, "Logout");
		  		 String imagePath2 = test.addScreenCapture(path2);
		  		 test.log(LogStatus.INFO, imagePath2);
		  		 report.endTest(test);
		  		 report.flush();
	  			   
	  		   }else if(Admin_LoginPageElements.AdminLogoutButtonIsVisible()){
	  			   
	  			   	Admin_LoginPageElements.ClickAdminLogoutButton();
		  			test.log(LogStatus.INFO, "After Method-Admin User Logged Out");
		  			String path2 = ScreenShot.Image(driver, "Logout");
		  			String imagePath2 = test.addScreenCapture(path2);
		  			test.log(LogStatus.INFO, imagePath2);
		  			report.endTest(test);
		  			report.flush();
	  		   }
	  			 
	  			
	  	
	  	}catch (Exception e) {
	  				
	  			test.log(LogStatus.FAIL, "After Method-Logout Failed");
	  			String path2 = ScreenShot.Image(driver, "Logout");
	  			String imagePath2 = test.addScreenCapture(path2);
	  			test.log(LogStatus.INFO, imagePath2);
	  			report.endTest(test);
	  			report.flush();
	  			Assert.fail("Log Out Failed- "+"Exception: " + e);
	  			driver.quit();
	  				
	  	} 
		
/*		//User Log Out
		
		 try{ 
			 
			 if(LoginPageElements.AdminLogoutButtonIsVisible()) {
	  			   
	  			 LoginPageElements.ClickAdminLogoutButton();
		  		 test.log(LogStatus.INFO, "After Method-Client User Logged Out");
		  		 String path2 = ScreenShot.Image(driver, "Logout");
		  		 String imagePath2 = test.addScreenCapture(path2);
		  		 test.log(LogStatus.INFO, imagePath2);
		  		 report.endTest(test);
		  		 report.flush();
				 
			 }else {
				 
				 test.log(LogStatus.FAIL, "After Method-Logout not visible");
				 String path2 = ScreenShot.Image(driver, "Logout");
				 String imagePath2 = test.addScreenCapture(path2);
				 test.log(LogStatus.INFO, imagePath2);
				 report.endTest(test);
				 report.flush();
				 Assert.fail("Log Out not visible");
				 driver.quit();
			 }
	
		 }catch (Exception e) {
				
				test.log(LogStatus.FAIL, "After Method-Logout Failed");
				String path2 = ScreenShot.Image(driver, "Logout");
				String imagePath2 = test.addScreenCapture(path2);
				test.log(LogStatus.INFO, imagePath2);
				report.endTest(test);
				report.flush();
				Assert.fail("Log Out Failed- "+"Exception: " + e);
				driver.quit();
				
			} */
	
		
		
	}
	
	
	  @Test (priority = 1, groups = {"Regression","BS_Regression","Regression_Chrome"},dataProviderClass = Test_Data.class, dataProvider="Certificate_ProposalsOrder_Data")
	  public void Ssl_Certificates_Proposals (String ProductType, String Product, String Quantity, String Duration, String License, String CommonName) throws Exception {
		  
		  test = report.startTest("Admin Test --> SSL Certificates Proposals Order Test - " + Product);
		  
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
			  
			  Admin_SslDashBoardElements.ProposalsLinkClick();
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
					  String imagePath = test.addScreenCapture(path);
					  test.log(LogStatus.INFO, imagePath);
					  test.log(LogStatus.INFO, "Common Name Field Not Clickable");
					  //Assert.fail("Exception " + e);
			
				  }
				  
				  Thread.sleep(1000);
				  
				try {
					
					
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
				  
				  
			   	  jse.executeScript("window.scrollBy(0,250)", "");
				  	
			  	  Thread.sleep(1000);
			  	  
			  try {
				  
				  Admin_ProposalsPageElements.IssueProposalTabClink();
			  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  	  test.log(LogStatus.INFO, "Clicked on Issue Proposal Tab");
					
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
			  	  
			   	  jse.executeScript("window.scrollBy(0,250)", "");
				  	
			  	  Thread.sleep(1000);
			  	  
			  try {
				  
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
				  	
			  	  jse.executeScript("window.scrollBy(0,500)", "");
			  	  
			  	  Thread.sleep(1000);
			  
			  try {
				  
			  	  Admin_ProposalsPageElements.ConvertToInvoiceButtonClink();
			  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  	  test.log(LogStatus.INFO, "Clicked Covert to Invoice Button");
			  	  
					
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
			  	  

			  	  
		   }catch (Exception e) {
				
			   	String path = ScreenShot.Image(driver, "Proposal");
			   	test.log(LogStatus.INFO, e);
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);
				test.log(LogStatus.FAIL, "Test Failed");
				test.log(LogStatus.INFO, e);
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
			    	test.log(LogStatus.WARNING, "Alert Not Handled");
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
					   
					
					  //Admin_LoginPageElements.EnterUserName("qa@ssl247.co.uk");
					  Client_LoginPageElements.ClientLogin();
					  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					  //test.log(LogStatus.INFO, "Entereed UserName");
					  
					  //Admin_LoginPageElements.EnterPassword("Test1234");
					  //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					  //test.log(LogStatus.INFO, "Entered Password");
					  
					  //Admin_LoginPageElements.ClickLoginButton();
					  //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					  //test.log(LogStatus.INFO, "Clicked Login Button");
					  
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
				
				//Admin_MySslDashBoardElements.MysslCertificatessLinkClick();
				Client_MySslDashBoardElements.MysslCertificatessLinkClick();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Clicked on mY SSL Certificates Link");
				
				//Admin_MySslDashBoardElements.IncompleteLinkClick();
				Client_MySslDashBoardElements.IncompleteLinkClick();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Clicked on Incomplete Link");
				
				//Admin_CertificatesPageElements.Col1_ViewButtonClick();
				Client_IncompleteCertificatesPageElements.Column1EditButtonClick();
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
				
					Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Ssl-test1"));
					Client_CertificateValidationPageElements.HitEnterKey();
					Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Ssl-test2"));
					Client_CertificateValidationPageElements.HitEnterKey();
					Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Ssl-test3"));
					Client_CertificateValidationPageElements.HitEnterKey();;
					Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Ssl-test4"));
					Client_CertificateValidationPageElements.HitEnterKey();
					Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Ssl-test5"));
					Client_CertificateValidationPageElements.HitEnterKey();
					Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Ssl-test6"));
					Client_CertificateValidationPageElements.HitEnterKey();
					Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Ssl-test7"));
					Client_CertificateValidationPageElements.HitEnterKey();
					Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Ssl-test8"));
					Client_CertificateValidationPageElements.HitEnterKey();
					Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Ssl-test9"));
					Client_CertificateValidationPageElements.HitEnterKey();
					Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Ssl-test10"));
					Client_CertificateValidationPageElements.HitEnterKey();
					Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Ssl-test11"));
					Client_CertificateValidationPageElements.HitEnterKey();
					Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Ssl-test12"));
					Client_CertificateValidationPageElements.HitEnterKey();
					Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Ssl-test13"));
					Client_CertificateValidationPageElements.HitEnterKey();
					Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Ssl-test14"));
					Client_CertificateValidationPageElements.HitEnterKey();
					Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Ssl-test15"));
					Client_CertificateValidationPageElements.HitEnterKey();
					Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Ssl-test16"));
					Client_CertificateValidationPageElements.HitEnterKey();
					Client_CertificateValidationPageElements.CsrFieldFill(prop.getProperty("Ssl-test17"));
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
					//TODO
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
					
					Assert.assertTrue(Admin_PendingCertificatesPageElements.PageHeader().contains("Pending Certificates"));
					driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
					test.log(LogStatus.PASS, "Validation Passed");
					
				}catch (Exception e) {
					
					test.log(LogStatus.FATAL, "Validation Failed");
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

	  
	  @Test (priority = 2, groups = {"Regression","BS_Regression","Regression_Chrome"},dataProviderClass = Test_Data.class, dataProvider="Personal_ID_ProposalsOrder_Data")
	  public void Personal_ID_Proposals (String ProductType, String Product, String Quantity, String Duration, String License, String CommonName) throws Exception {
		  
		  test = report.startTest("Admin Test --> Proposals Order Test - " + Product);
		     
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
			  
			  Admin_SslDashBoardElements.ProposalsLinkClick();
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
					  String imagePath = test.addScreenCapture(path);
					  test.log(LogStatus.INFO, imagePath);
					  test.log(LogStatus.INFO, "Common Name Field Not Clickable");
					  //Assert.fail("Exception " + e);
			
				  }
				  
				  Thread.sleep(1000);
				  
				  //Click Calculate Prices Button
				  
				try {
					
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
				  
				  
			   	  jse.executeScript("window.scrollBy(0,250)", "");
				  	
			  	  Thread.sleep(1000);
			  	  
			  	try {
			  		
					  Admin_ProposalsPageElements.IssueProposalTabClink();
				  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  	  test.log(LogStatus.INFO, "Clicked on Issue Proposal Tab");
					
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
				  

			   	  jse.executeScript("window.scrollBy(0,250)", "");
				  	
			  	  Thread.sleep(1000);
			  	  
			  	try {
			  		
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
				  	
			  	  
			  	  jse.executeScript("window.scrollBy(0,500)", "");
			  	  
			  	  Thread.sleep(1000);
			  	  
			  	try {
			  		
				  	  Admin_ProposalsPageElements.ConvertToInvoiceButtonClink();
				  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  	  test.log(LogStatus.INFO, "Clicked Covert to Invoice Button");
					
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
			  	  
				  
				 
		   }catch (Exception e) {
				
			   	String path = ScreenShot.Image(driver, "Proposal");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);
				test.log(LogStatus.FAIL, "Test Failed");
				driver.navigate().refresh();
				Assert.fail( Product +" - Exception: "+ e);
				
			}
		  
	  }
	  
	  @Test (priority = 3, groups = {"Regression","BS_Regression","Regression_Chrome"},dataProviderClass = Test_Data.class, dataProvider="CodeSigning_ProposalsOrder_Data")
	  public void CodeSigning_Proposals (String ProductType, String Product, String Quantity, String Duration, String License, String CommonName) throws Exception {
		  
		  test = report.startTest("Admin Test --> Proposals Order Test - " + Product);
		     
		  test.log(LogStatus.INFO, "Browser Opened and Url Enterl");
		  test.log(LogStatus.INFO, "Logged in as Admin");
		  
		  System.out.println("Started Proposal For:------------------ " + Product);
		  
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
		  
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  jse.executeScript("window.scrollBy(0,500)", "");
			 
		  Thread.sleep(5000);
		  
		  Admin_ClientAccountsPageElements.ValidateResults("UKTE001");
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Search Resusult is Displayed");
			 
		  Admin_ClientAccountsPageElements.ViewAccount();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Click on UK Test Account in search Result");
		     
		  Thread.sleep(1000);
		  
		  Admin_SslDashBoardElements.ProposalsLinkClick();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Clicked on proposal link");
		  
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
					  String imagePath = test.addScreenCapture(path);
					  test.log(LogStatus.INFO, imagePath);
					  test.log(LogStatus.INFO, "Common Name Field Not Clickable");
					  //Assert.fail("Exception " + e);
			
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
			  	  
			  	  jse.executeScript("window.scrollBy(0,500)", "");
			  	  
			  	  Thread.sleep(1000);
			  	  
			  	  Admin_ProposalsPageElements.ConvertToInvoiceButtonClink();
			  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  	  test.log(LogStatus.INFO, "Clicked Covert to Invoice Button");
			  	  
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
			  	  
				  
				 
		   }catch (Exception e) {
				
			   	String path = ScreenShot.Image(driver, "Proposal");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);
				test.log(LogStatus.FAIL, "Test Failed");
				driver.navigate().refresh();
				Assert.fail( Product +" - Exception: "+ e);
				
			}
		  
	  }
	  
	  @Test (priority = 4, groups = {"Regression","BS_Regression","Regression_Chrome"},dataProviderClass = Test_Data.class, dataProvider="PdfSigning_ProposalsOrder_Data")
	  public void PdfSigning_Proposals (String ProductType, String Product, String Quantity, String Duration, String License, String CommonName) throws Exception {
		  
		  test = report.startTest("Admin Test --> Proposals Order Test - " + Product);
		     
		  test.log(LogStatus.INFO, "Browser Opened and Url Enterl");
		  test.log(LogStatus.INFO, "Logged in as Admin");
		  
		  System.out.println("Started Proposal For:------------------ " + Product);
		  
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
		  
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  jse.executeScript("window.scrollBy(0,500)", "");
			 
		  Thread.sleep(5000);
		  
		  Admin_ClientAccountsPageElements.ValidateResults("UKTE001");
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Search Resusult is Displayed");
			 
		  Admin_ClientAccountsPageElements.ViewAccount();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Click on UK Test Account in search Result");
		     
		  Thread.sleep(1000);
		  
		  Admin_SslDashBoardElements.ProposalsLinkClick();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Clicked on proposal link");
		  
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
					  String imagePath = test.addScreenCapture(path);
					  test.log(LogStatus.INFO, imagePath);
					  test.log(LogStatus.INFO, "Common Name Field Not Clickable");
					  //Assert.fail("Exception " + e);
			
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
			  	  
			  	  jse.executeScript("window.scrollBy(0,500)", "");
			  	  
			  	  Thread.sleep(1000);
			  	  
			  	  Admin_ProposalsPageElements.ConvertToInvoiceButtonClink();
			  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  	  test.log(LogStatus.INFO, "Clicked Covert to Invoice Button");
			  	  
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
			  	  
				  
				 
		   }catch (Exception e) {
				
			   	String path = ScreenShot.Image(driver, "Proposal");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);
				test.log(LogStatus.FAIL, "Test Failed");
				driver.navigate().refresh();
				Assert.fail( Product +" - Exception: "+ e);
				
			}
		  
	  }
  
	  @Test (priority = 5, groups = {"Regression","BS_Regression","Regression_Chrome"},dataProviderClass = Test_Data.class, dataProvider="BrandProtection_ProposalsOrder_Data")
	  public void BrandProtection_Proposals (String ProductType, String Product, String Quantity, String Duration, String License, String CommonName) throws Exception {
		  
		  test = report.startTest("Admin Test --> Proposals Order Test - " + Product);
		     
		  test.log(LogStatus.INFO, "Browser Opened and Url Enterl");
		  test.log(LogStatus.INFO, "Logged in as Admin");
		  
		  System.out.println("Started Proposal For:------------------ " + Product);
		  
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
		  
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  jse.executeScript("window.scrollBy(0,500)", "");
			 
		  Thread.sleep(5000);
		  
		  Admin_ClientAccountsPageElements.ValidateResults("UKTE001");
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Search Resusult is Displayed");
			 
		  Admin_ClientAccountsPageElements.ViewAccount();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Click on UK Test Account in search Result");
		     
		  Thread.sleep(1000);
		  
		  Admin_SslDashBoardElements.ProposalsLinkClick();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Clicked on proposal link");
		  
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
		  			String imagePath = test.addScreenCapture(path);
		  			test.log(LogStatus.INFO, imagePath);
		  			test.log(LogStatus.INFO, "Quantity not Selected");
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
					  String imagePath = test.addScreenCapture(path);
					  test.log(LogStatus.INFO, imagePath);
					  test.log(LogStatus.INFO, "Common Name Field Not Clickable");
					  //Assert.fail("Exception " + e);
			
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
			  	  
			  	  jse.executeScript("window.scrollBy(0,500)", "");
			  	  
			  	  Thread.sleep(1000);
			  	  
			  	  Admin_ProposalsPageElements.ConvertToInvoiceButtonClink();
			  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  	  test.log(LogStatus.INFO, "Clicked Covert to Invoice Button");
			  	  
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
			  	  
				  
				 
		   }catch (Exception e) {
				
			   	String path = ScreenShot.Image(driver, "Proposal");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);
				test.log(LogStatus.FAIL, "Test Failed");
				driver.navigate().refresh();
				Assert.fail( Product +" - Exception: "+ e);
				
			}
		  
	  }	  

	  @Test (priority = 6, groups = {"Regression","BS_Regression","Regression_Chrome"},dataProviderClass = Test_Data.class, dataProvider="ReadyIssuance_ProposalsOrder_Data")
	  public void ReadyIssuance_Proposals (String ProductType, String Product, String Quantity, String Duration, String License, String CommonName) throws Exception {
		  
		  test = report.startTest("Admin Test --> Proposals Order Test - " + Product);
		     
		  test.log(LogStatus.INFO, "Browser Opened and Url Enterl");
		  test.log(LogStatus.INFO, "Logged in as Admin");
		  
		  System.out.println("Started Proposal For:------------------ " + Product);
		  
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
		  
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  jse.executeScript("window.scrollBy(0,500)", "");
			 
		  Thread.sleep(5000);
		  
		  Admin_ClientAccountsPageElements.ValidateResults("UKTE001");
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Search Resusult is Displayed");
			 
		  Admin_ClientAccountsPageElements.ViewAccount();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Click on UK Test Account in search Result");
		     
		  Thread.sleep(1000);
		  
		  Admin_SslDashBoardElements.ProposalsLinkClick();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Clicked on proposal link");
		  
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
		  			String imagePath = test.addScreenCapture(path);
		  			test.log(LogStatus.INFO, imagePath);
		  			test.log(LogStatus.INFO, "Quantity not Selected");
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
					  String imagePath = test.addScreenCapture(path);
					  test.log(LogStatus.INFO, imagePath);
					  test.log(LogStatus.INFO, "Common Name Field Not Clickable");
					  //Assert.fail("Exception " + e);
			
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
			  	  
			  	  jse.executeScript("window.scrollBy(0,500)", "");
			  	  
			  	  Thread.sleep(1000);
			  	  
			  	  Admin_ProposalsPageElements.ConvertToInvoiceButtonClink();
			  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  	  test.log(LogStatus.INFO, "Clicked Covert to Invoice Button");
			  	  
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
			  	  
				  
				 
		   }catch (Exception e) {
				
			   	String path = ScreenShot.Image(driver, "Proposal");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);
				test.log(LogStatus.FAIL, "Test Failed");
				driver.navigate().refresh();
				Assert.fail( Product +" - Exception: "+ e);
				
			}
		  
	  }	  

	  @Test (priority = 7, groups = {"Regression","BS_Regression","Regression_Chrome"},dataProviderClass = Test_Data.class, dataProvider="PenTest_ProposalsOrder_Data")
	  public void PenTest_Proposals (String ProductType, String Product, String Quantity, String Duration, String License, String CommonName) throws Exception {
		  
		  test = report.startTest("Admin Test --> Proposals Order Test - " + Product);
		     
		  test.log(LogStatus.INFO, "Browser Opened and Url Enterl");
		  test.log(LogStatus.INFO, "Logged in as Admin");
		  
		  System.out.println("Started Proposal For:------------------ " + Product);
		  
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
		  
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  jse.executeScript("window.scrollBy(0,500)", "");
			 
		  Thread.sleep(5000);
		  
		  Admin_ClientAccountsPageElements.ValidateResults("UKTE001");
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Search Resusult is Displayed");
			 
		  Admin_ClientAccountsPageElements.ViewAccount();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Click on UK Test Account in search Result");
		     
		  Thread.sleep(1000);
		  
		  Admin_SslDashBoardElements.ProposalsLinkClick();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Clicked on proposal link");
		  
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
		  			String imagePath = test.addScreenCapture(path);
		  			test.log(LogStatus.INFO, imagePath);
		  			test.log(LogStatus.INFO, "Quantity not Selected");
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
					  String imagePath = test.addScreenCapture(path);
					  test.log(LogStatus.INFO, imagePath);
					  test.log(LogStatus.INFO, "Common Name Field Not Clickable");
					  //Assert.fail("Exception " + e);
			
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
			  	  
			  	  jse.executeScript("window.scrollBy(0,500)", "");
			  	  
			  	  Thread.sleep(1000);
			  	  
			  	  Admin_ProposalsPageElements.ConvertToInvoiceButtonClink();
			  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  	  test.log(LogStatus.INFO, "Clicked Covert to Invoice Button");
			  	  
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
			  	  			  		 
		   }catch (Exception e) {
				
			   	String path = ScreenShot.Image(driver, "Proposal");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);
				test.log(LogStatus.FAIL, "Test Failed");
				driver.navigate().refresh();
				Assert.fail( Product +" - Exception: "+ e);
				
			}
		  
	  }

	  @Test (priority = 8, groups = {"Regression","BS_Regression","Regression_Chrome"},dataProviderClass = Test_Data.class, dataProvider="EntrustEnterpriseAccount_ProposalsOrder_Data")
	  public void EntrustEnterpriseAccount_Proposals (String ProductType, String Product, String Quantity, String Duration, String License, String CommonName) throws Exception {
		  
		  test = report.startTest("Admin Test --> Proposals Order Test - " + Product);
		     
		  test.log(LogStatus.INFO, "Browser Opened and Url Enterl");
		  test.log(LogStatus.INFO, "Logged in as Admin");
		  
		  System.out.println("Started Proposal For:------------------ " + Product);
		  
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
		  
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  jse.executeScript("window.scrollBy(0,500)", "");
			 
		  Thread.sleep(5000);
		  
		  Admin_ClientAccountsPageElements.ValidateResults("UKTE001");
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Search Resusult is Displayed");
			 
		  Admin_ClientAccountsPageElements.ViewAccount();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Click on UK Test Account in search Result");
		     
		  Thread.sleep(1000);
		  
		  Admin_SslDashBoardElements.ProposalsLinkClick();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Clicked on proposal link");
		  
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
		  			String imagePath = test.addScreenCapture(path);
		  			test.log(LogStatus.INFO, imagePath);
		  			test.log(LogStatus.INFO, "Quantity not Selected");
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
					  String imagePath = test.addScreenCapture(path);
					  test.log(LogStatus.INFO, imagePath);
					  test.log(LogStatus.INFO, "Common Name Field Not Clickable");
					  //Assert.fail("Exception " + e);
			
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
			  	  
			  	  jse.executeScript("window.scrollBy(0,500)", "");
			  	  
			  	  Thread.sleep(1000);
			  	  
			  	  Admin_ProposalsPageElements.ConvertToInvoiceButtonClink();
			  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  	  test.log(LogStatus.INFO, "Clicked Covert to Invoice Button");
			  	  
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
			  	  
				  
				 
		   }catch (Exception e) {
				
			   	String path = ScreenShot.Image(driver, "Proposal");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);
				test.log(LogStatus.FAIL, "Test Failed");
				driver.navigate().refresh();
				Assert.fail( Product +" - Exception: "+ e);
				
			}
		  
	  }
	  
	  @Test (priority = 1, groups = {"Regression","BS_Regression","Regression_Chrome"},dataProviderClass = Test_Data.class, dataProvider="Certificate_WithSAN_ProposalsOrder_Data")
	  public void Ssl_Certificates_WithSAN_Proposals (String ProductType, String Product, String Quantity, String Duration, String License, String CommonName) throws Exception {
		  
		  test = report.startTest("Admin Test --> Proposals Order Test + SAN - " + Product);
		  
		  Properties prop = new Properties();
		  FileInputStream fis = new FileInputStream(Constants.File_Path + Constants.DataFile_Name);
		  
		  prop.load(fis);
		     
		  test.log(LogStatus.INFO, "Browser Opened and Url Enterl");
		  test.log(LogStatus.INFO, "Logged in as Admin");
		  
		  System.out.println("Started Proposal For:------------------ " + Product);
		  
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
		  
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  jse.executeScript("window.scrollBy(0,500)", "");
			 
		  Thread.sleep(5000);
		  
		  Admin_ClientAccountsPageElements.ValidateResults("UKTE001");
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Search Resusult is Displayed");
			 
		  Admin_ClientAccountsPageElements.ViewAccount();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Click on UK Test Account in search Result");
		     
		  Thread.sleep(1000);
		  
		  Admin_SslDashBoardElements.ProposalsLinkClick();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Clicked on proposal link");
		  
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
				//TODO
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
}
