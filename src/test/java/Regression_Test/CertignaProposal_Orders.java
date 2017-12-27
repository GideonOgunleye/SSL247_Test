package Regression_Test;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
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
import BaseUtilities.Chrome;
import BaseUtilities.Constants;
import BaseUtilities.CsR;
import BaseUtilities.DriverLoad;
import BaseUtilities.ExtentFactory;
import BaseUtilities.TakeScreenShot;
import PageFactory.Admin.Admin_BillingPage;
import PageFactory.Admin.Admin_CertificateValidationPage;
import PageFactory.Admin.Admin_CertificatesPage;
import PageFactory.Admin.Admin_ClientAccountsPage;
import PageFactory.Admin.Admin_CodeSigningCertsValidationPage;
import PageFactory.Admin.Admin_IncompleteCertificatesPage;
import PageFactory.Admin.Admin_IncompleteCodeSigningCertsPage;
import PageFactory.Admin.Admin_IncompleteSmimePage;
import PageFactory.Admin.Admin_LoginPage;
import PageFactory.Admin.Admin_MySslDashBoard;
import PageFactory.Admin.Admin_NavigationLinks;
import PageFactory.Admin.Admin_OrdersPage;
import PageFactory.Admin.Admin_ProposalsPage;
import PageFactory.Admin.Admin_SmimeValidationPage;
import PageFactory.Admin.Admin_SslDashBoard;
import PageFactory.Client.Client_BillingPage;
import PageFactory.Client.Client_CertificateValidationPage;
import PageFactory.Client.Client_ClientAccountsPage;
import PageFactory.Client.Client_CodeSigningCertsValidationPage;
import PageFactory.Client.Client_IncompleteCertificatesPage;
import PageFactory.Client.Client_IncompleteCodeSigningCertsPage;
import PageFactory.Client.Client_IncompleteSmimePage;
import PageFactory.Client.Client_LoginPage;
import PageFactory.Client.Client_MySslDashBoard;
import PageFactory.Client.Client_NavigationLinks;
import PageFactory.Client.Client_SmimeValidationPage;

public class CertignaProposal_Orders extends BrowserStack {
	ExtentReports report;
	ExtentTest test;
	Admin_LoginPage 	Admin_LoginPageElements;
	Admin_BillingPage Admin_BillingPageElements;
	Admin_MySslDashBoard Admin_MySslDashBoardElements;
	AlertBox AlertBoxElements;
	TakeScreenShot ScreenShot;
	CsR CsrElements;
	Admin_NavigationLinks Admin_NavigationLinksElements;
	Admin_CertificatesPage Admin_CertificatesPageElements;
	Admin_NavigationLinks NavigationLinksElements;
	Admin_SslDashBoard Admin_SslDashBoardElements;
	Admin_ProposalsPage ProposalsPageElements;
	Admin_ClientAccountsPage Admin_ClientAccountsPageElements;
	Admin_OrdersPage Admin_OrdersPageElements;
	Admin_IncompleteCertificatesPage Admin_IncompleteCertificaesPageElements;
	Admin_CertificateValidationPage Admin_CertificateValidationPageElements;
	Admin_IncompleteSmimePage Admin_IncompleteSmimePageElements;
	Admin_SmimeValidationPage Admin_SmimeValidationPageElements;
	Admin_IncompleteCodeSigningCertsPage Admin_IncompleteCodeSigningCertsPageElements;
	Admin_CodeSigningCertsValidationPage Admin_CodeSigningCertsValidationPageElements;
	
	@BeforeMethod (groups = {"Regression","BS_Regression","Regression_Chrome"})
	public void User_Login () throws Exception {
		 
		Admin_LoginPageElements = new Admin_LoginPage(driver);
		Admin_BillingPageElements = new Admin_BillingPage(driver);
		Admin_MySslDashBoardElements = new Admin_MySslDashBoard(driver);
		AlertBoxElements = new AlertBox(driver);
		ScreenShot = new TakeScreenShot();
		CsrElements = new CsR(driver);
		Admin_SslDashBoardElements = new Admin_SslDashBoard(driver);
		ProposalsPageElements = new Admin_ProposalsPage(driver);
		//NavigationLinksElements = new Admin_NavigationLinks(driver);
		Admin_NavigationLinksElements = new Admin_NavigationLinks(driver);
		Admin_ClientAccountsPageElements = new Admin_ClientAccountsPage(driver);
		Admin_CertificatesPageElements = new Admin_CertificatesPage(driver);
		Admin_OrdersPageElements = new Admin_OrdersPage(driver);
		Admin_IncompleteCertificaesPageElements = new Admin_IncompleteCertificatesPage(driver);
		Admin_CertificateValidationPageElements = new Admin_CertificateValidationPage(driver);
		Admin_IncompleteSmimePageElements = new Admin_IncompleteSmimePage(driver);
		Admin_SmimeValidationPageElements = new Admin_SmimeValidationPage(driver);
		Admin_CodeSigningCertsValidationPageElements = new Admin_CodeSigningCertsValidationPage(driver);
		Admin_IncompleteCodeSigningCertsPageElements = new Admin_IncompleteCodeSigningCertsPage(driver);
	
	
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
		jse.executeScript("window.scrollBy(0,-500)", "");
	
		
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
		
	}
	
	
	  @Test (priority = 1, groups = {"Regression","BS_Regression","Regression_Chrome"},dataProviderClass = Test_Data.class, dataProvider="CertignaCertificate_ProposalsOrder_Data")
	  public void CertignaCertificates_Proposals (String ProductType, String Product1, String Quantity, String Duration, String License, String CommonName, String StaffName, String Line1, String Line2, String Line3, String Line4, String Line5, String Line6, String Line7, String Line8, String Line9, String Line10, String Line11, String Line12, String Line13, String Line14, String Line15, String Line16, String Line17) throws Exception {
		  
		  Properties prop = new Properties();
		  FileInputStream fis = new FileInputStream(Constants.File_Path + Constants.DataFile_Name);
		  
		  prop.load(fis);
		  
		  test = report.startTest("Certingna Cert --> Proposals Order Test - " + Product1);
		     
		  test.log(LogStatus.INFO, "Browser Opened and Url Enterl");
		  test.log(LogStatus.INFO, "Logged in as Admin");
		  
		  System.out.println("Started Proposal For:------------------ " + Product1 );
		  
		  Admin_NavigationLinksElements.ClientsAccountsLinkClick();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Click on clients Accounts Link");
		  
		  //ClientAccountsPageElements.ValidatePage();
		  //driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  //test.log(LogStatus.INFO, "Click Account Page Validated");
			 
			 
		  Admin_ClientAccountsPageElements.SearchQueryFieldFill("FRT");
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Click on Search Query and Enter UK Test");
			 
		  Admin_ClientAccountsPageElements.UpdateButtonClink();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Click on Update Button");
		  
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  jse.executeScript("window.scrollBy(0,500)", "");
			 
		  Thread.sleep(5000);
		  
		  Admin_ClientAccountsPageElements.ValidateResults("FRTE001");
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Search Resusult is Displayed");
			 
		  Admin_ClientAccountsPageElements.ViewAccount();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Click on UK Test Account in search Result");
		     
		  Thread.sleep(1000);
		  
		  
		  Admin_SslDashBoardElements.ProposalsLinkClick();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Clicked on proposal link");
		  
		  Thread.sleep(2000);
		 
		  try {
			  
				  ProposalsPageElements.NewProposalButton2Clink();
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Clicked on New Proposal Button");
				  
				  jse.executeScript("window.scrollBy(0,500)", "");
				  
				  Thread.sleep(2000);
				  
				//Add First Product-----------------------------------------------------------------------  
				  
				  //Select Product Type
				  ProposalsPageElements.ProductTypeFieldSelect(ProductType);
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Selected Product Type");
				  
				  Thread.sleep(1000);
				  
				  //Select Product 
				  ProposalsPageElements.ProductFieldSelect(Product1);
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Selected Product");
				  
				  Thread.sleep(1000);
				
				try {  
					
				  //Select Quantity
				  ProposalsPageElements.QuantityFieldClear();
				  ProposalsPageElements.QuantityFieldSenkeys(Quantity);
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
				  
				//Select Duration----------------------------------------
				  try {
					
					  ProposalsPageElements.DurationFieldSelect(Duration);
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
				  
				  //Fill Common Name Field----------------------------------
				  try { 
					 
					  ProposalsPageElements.CommonNameFieldClear();
					  ProposalsPageElements.CommonNameFieldSendKeys(CommonName);
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
				  
				  ProposalsPageElements.CalculatePricesButtonClink();
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Click on Calculate Prices Button");
				  
				  Thread.sleep(1000);
				  jse.executeScript("window.scrollBy(0,500)", "");
				  
				  test.log(LogStatus.PASS, "Proposal Created");
				  String path = ScreenShot.Image(driver, "Proposal");
				  String imagePath = test.addScreenCapture(path);
				  test.log(LogStatus.INFO, imagePath);
				  
				  Thread.sleep(1000);
					
				  //Click Save 
				
				  ProposalsPageElements.SaveProposalButtonClink();
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Click on Save Proposal Button");
				  
			   	  jse.executeScript("window.scrollBy(0,250)", "");
			  	  Thread.sleep(1000);
				 
			  	  
			  	  //Issue Proposal------------------------------------------------------------------
				  ProposalsPageElements.IssueProposalTabFRClink();
			  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  	  test.log(LogStatus.INFO, "Clicked on Issue Proposal Tab");
			  	  
			   	  jse.executeScript("window.scrollBy(0,250)", "");
				  	
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
			  	  
			  	  jse.executeScript("window.scrollBy(0,500)", "");
			  	  Thread.sleep(1000);
			  	  
			  	  //Convert Proposal To Invoice------------------------------------------------------------------
			  	  
			  	  ProposalsPageElements.ConvertToInvoiceButtonClink();
			  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  	  test.log(LogStatus.INFO, "Clicked Covert to Invoice Button");
			  	  

			    
		   }catch (Exception e) {
				
			   	String path = ScreenShot.Image(driver, "Proposal");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);
				test.log(LogStatus.FAIL, "Test Failed");
				driver.navigate().refresh();
				//Assert.fail( Product1 +" - Exception: "+ e);
				
			}
			  	  

			//Handle Alart-------------------------------------------------------------------------------------  	
			  	try {
			  		
				  	  Alert alert = driver.switchTo().alert();
				  	  alert.accept();
				  	  test.log(LogStatus.INFO, "Clicked on Alert");
				  	  
				  	  jse.executeScript("window.scrollBy(0,500)", "");
			        
			    } catch (Exception e) {
			    	
			    	System.out.println("Alert Not Handled");
			    }		
			
			//View Ordered Certificate--------------------------------------------------------
			
			
			try {
				
				Thread.sleep(1000);
				
				Admin_SslDashBoardElements.OrdersLinkFRClick();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  	test.log(LogStatus.INFO, "Clicked on Orders Link");
			  	
			  	Admin_OrdersPageElements.SavedTabFRClick();
			  	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  	test.log(LogStatus.INFO, "Clicked on Saved Tab");
			  	
				String path = ScreenShot.Image(driver, "Proposal");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);
	
			  	
			}catch (Exception e) {
				
				String path = ScreenShot.Image(driver, "Proposal");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);
				test.log(LogStatus.INFO, "Invoice Not Issued");
				System.out.println("View Ordered Cert Exception:-  " + e);
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
				   
				
				  Admin_LoginPageElements.EnterUserName("qa@ssl247.fr");
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
					System.out.println("Element Not Found");
					String path2 = ScreenShot.Image(driver, "Element");
					String imagePath2 = test.addScreenCapture(path2);
					test.log(LogStatus.INFO, imagePath2);
					report.endTest(test);
					report.flush();
					Assert.fail("Exception " + e);
				}
			 
			 
			 Thread.sleep(2000);
			 
		//Validate Certificate-------------------------------------------------------------------------	 
			
			Admin_MySslDashBoardElements.MysslCertificatessLinkFRClick();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked on My SSL Link");
			    
			Admin_MySslDashBoardElements.IncompleteLinkFRClick();
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked on Issued Link");	
			
			Admin_IncompleteCertificaesPageElements.Column1EditButtonClick();
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked to view certificate on First Row");
			
			test.log(LogStatus.PASS, "Saved Order Found");
			String path = ScreenShot.Image(driver, "Proposal");
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.INFO, imagePath);
				
		//Certificate Details Tab-------------------------------------------------------------------------		
	try {	
			Admin_CertificateValidationPageElements.CertificatesDetailsTabClick();
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked on Certificate Details Tab");	
			
			Thread.sleep(2000);
		  	jse.executeScript("window.scrollBy(0,500)", "");
			
			Admin_CertificateValidationPageElements.CsrFieldClick();;
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked on CSR Field");	
		
			Admin_CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line1));
			Admin_CertificateValidationPageElements.HitEnterKey();
			Admin_CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line2));
			Admin_CertificateValidationPageElements.HitEnterKey();
			Admin_CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line3));
			Admin_CertificateValidationPageElements.HitEnterKey();;
			Admin_CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line4));
			Admin_CertificateValidationPageElements.HitEnterKey();
			Admin_CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line5));
			Admin_CertificateValidationPageElements.HitEnterKey();
			Admin_CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line6));
			Admin_CertificateValidationPageElements.HitEnterKey();
			Admin_CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line7));
			Admin_CertificateValidationPageElements.HitEnterKey();
			Admin_CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line8));
			Admin_CertificateValidationPageElements.HitEnterKey();
			Admin_CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line9));
			Admin_CertificateValidationPageElements.HitEnterKey();
			Admin_CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line10));
			Admin_CertificateValidationPageElements.HitEnterKey();
			Admin_CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line11));
			Admin_CertificateValidationPageElements.HitEnterKey();
			Admin_CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line12));
			Admin_CertificateValidationPageElements.HitEnterKey();
			Admin_CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line13));
			Admin_CertificateValidationPageElements.HitEnterKey();
			Admin_CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line14));
			Admin_CertificateValidationPageElements.HitEnterKey();
			Admin_CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line15));
			Admin_CertificateValidationPageElements.HitEnterKey();
			Admin_CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line16));
			Admin_CertificateValidationPageElements.HitEnterKey();
			Admin_CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line17));
			Admin_CertificateValidationPageElements.HitEnterKey();
			
			test.log(LogStatus.PASS, "Certificate Details Tab Filled");
			String path2 = ScreenShot.Image(driver, "Proposal");
			String imagePath2 = test.addScreenCapture(path2);
			test.log(LogStatus.INFO, imagePath2);
			
	  }catch (Exception e) {
			
			test.log(LogStatus.FAIL, "Error iN Certails Tab");
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
			 
		  	Admin_CertificateValidationPageElements.AdminTabClick();
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked Admin Tab");	
			
			Admin_CertificateValidationPageElements.AdminNameFieldSelect("Gideon Ogunleye");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Selected Admin contact name");	
			
			Admin_CertificateValidationPageElements.AdminOrganisationFieldFill("SSL247  SARL");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin Organisation Name");
			
			Thread.sleep(1000);
		  	jse.executeScript("window.scrollBy(0,500)", "");
		  	
		  	Admin_CertificateValidationPageElements.AdminFavouriteColourQuestionFieldFill("Blue");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin Questtion 1");
			
			Admin_CertificateValidationPageElements.AdminFavouriteBookQuestionFieldFill("Oliver Twist");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin Question 2");
			
			Admin_CertificateValidationPageElements.AdminFavouriteVegetableQuestionFieldFill("Carrot");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin Question 3");
			
			Admin_CertificateValidationPageElements.AdminFavouriteSportQuestionFieldFill("Football");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin Question 4");
			
			Admin_CertificateValidationPageElements.AdminStreetNameQuestionFieldFill("London");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin Question 5");
			
			test.log(LogStatus.PASS, "Admin Tab Filled");
			String path2 = ScreenShot.Image(driver, "Proposal");
			String imagePath2 = test.addScreenCapture(path2);
			test.log(LogStatus.INFO, imagePath2);
			
		  }catch (Exception e) {
				
				test.log(LogStatus.FAIL, "Error In Admin Tab");
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
			  
			  Admin_CertificateValidationPageElements.TechnicalTabClick();
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Click on Technical Tab");
			  
			  Admin_CertificateValidationPageElements.TechnicalNameFieldSelect("Gideon Ogunleye");
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Selected Technical Contact");
			  
			  Admin_CertificateValidationPageElements.TechnicalOrganisationFieldFill("SSL247 SARL");
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Filled Tech Organisation Field");
			  
			  Thread.sleep(1000);
			  jse.executeScript("window.scrollBy(0,500)", "");
			  	
			  Admin_CertificateValidationPageElements.TechFavouriteColourQuestionFieldFill("Blue");
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Filled Tech Questtion 1");
				
			  Admin_CertificateValidationPageElements.TechFavouriteBookQuestionFieldFill("Oliver Twist");
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Filled Tech Question 2");
				
		      Admin_CertificateValidationPageElements.TechFavouriteVegetableQuestionFieldFill("Carrot");
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Filled Tech Question 3");
				
			  Admin_CertificateValidationPageElements.TechFavouriteSportQuestionFieldFill("Football");
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Filled Tech Question 4");
				
			  Admin_CertificateValidationPageElements.TechStreetNameQuestionFieldFill("London");
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Filled Tech Question 5");
			  
			  test.log(LogStatus.PASS, "Tech Tab Filled");
			  String path2 = ScreenShot.Image(driver, "Proposal");
			  String imagePath2 = test.addScreenCapture(path2);
			  test.log(LogStatus.INFO, imagePath2);
			  
		  }catch (Exception e) {
				
				test.log(LogStatus.FAIL, "Error In Technical Tab");
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
		

		//Organisation Tab-------------------------------------------------------------------------------------------
		try {
			
			Admin_CertificateValidationPageElements.OrganisationTabClick();	
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked Organisation Tab");
			
			Admin_CertificateValidationPageElements.OrganisationLegalNameFieldFill("SSL247 SARL");	
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Organisation Legal Name Field");
			
			Admin_CertificateValidationPageElements.OrganisationCategoryFieldSelect("Registered company or corporation");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Selected Organisation Category");
			
			Admin_CertificateValidationPageElements.OrganisationRegistrationNumberFieldFill("05802692");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Organisation Rgistration Number");
			
			test.log(LogStatus.PASS, "Organisation Tab Filled");
			String path2 = ScreenShot.Image(driver, "Proposal");
			String imagePath2 = test.addScreenCapture(path2);
			test.log(LogStatus.INFO, imagePath2);
			
			
		}catch (Exception e) {
			
			test.log(LogStatus.FAIL, "Error In Organisation Tab");
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
	  	
	  	
	  	//Director Tab-------------------------------------------------------------------------------------------------
	  	try {
	  		
	  		Admin_CertificateValidationPageElements.DirectorTabClick();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked Director Tab");
	  		
	  		
	  		Admin_CertificateValidationPageElements.DirectorContactFieldSelect("Gideon Ogunleye");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Selected Director Contact Name");
	  		
	  		Admin_CertificateValidationPageElements.DirectorOrganisationFieldFill("SSL247 SARL");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Director Organisation Name Field");
	  		
	  		
			Thread.sleep(1000);
			jse.executeScript("window.scrollBy(0,500)", "");
	  		
	  		
	  		Admin_CertificateValidationPageElements.DirectorFavouriteColourQuestionFieldFill("Blue");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Director Tab Questtion 1");
	  		
	  		Admin_CertificateValidationPageElements.DirectorFavouriteVegetableQuestionFieldFill("Oliver Twist");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Director Tab Questtion 2");
	  		
	  		Admin_CertificateValidationPageElements.DirectorFavouriteBookQuestionFieldFill("Carrot");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Director Tab Questtion 3");
	  		
	  		Admin_CertificateValidationPageElements.DirectorFavouriteSportQuestionFieldFill("Football");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Director Tab Questtion 4");
	  		
	  		Admin_CertificateValidationPageElements.DirectorStreetNameQuestionFieldFill("London");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Director Tab Questtion 1");
			
			test.log(LogStatus.PASS, "Director Tab Filled");
			String path2 = ScreenShot.Image(driver, "Proposal");
			String imagePath2 = test.addScreenCapture(path2);
			test.log(LogStatus.INFO, imagePath2);
	  		
	  		
	  	}catch (Exception e) {
			
			test.log(LogStatus.FAIL, "Error In Director Tab");
			System.out.println("Element Not Found");
			String path2 = ScreenShot.Image(driver, "Element");
			String imagePath2 = test.addScreenCapture(path2);
			test.log(LogStatus.INFO, imagePath2);
			report.endTest(test);
			report.flush();
			Assert.fail("Exception " + e);
		}
	  	
		
		
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
	  	jse.executeScript("window.scrollBy(0,-2000)", "");
	  	Thread.sleep(1000);
	  	 	
		//Miscc Tab------------------------------------------------------------------------------
		  try {
			  
			  Admin_CertificateValidationPageElements.TermsTabClick();
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Misc tab Clicked");
			  
			  Thread.sleep(2000);
			  jse.executeScript("window.scrollBy(0,700)", "");
			  
			  Admin_CertificateValidationPageElements.TermsCheckBoxTick();
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Terms Checkbox Clicked");
			  
			  test.log(LogStatus.PASS, "Misc Tab Filled");
			  String path1 = ScreenShot.Image(driver, "Proposal");
			  String imagePath1 = test.addScreenCapture(path1);
			  test.log(LogStatus.INFO, imagePath1);
			  test.log(LogStatus.INFO, "Terms Checkbox 2nd Clicked");
			  
			  Thread.sleep(1000);
			  
		  }catch (Exception e) {
				
				test.log(LogStatus.FAIL, "Error in Misc Tab");
				System.out.println("Misc Element Not Found");
				String path3 = ScreenShot.Image(driver, "Element");
				String imagePath3 = test.addScreenCapture(path3);
				test.log(LogStatus.INFO, imagePath3);
				
			}
	  	
		Thread.sleep(1000);
	  	jse.executeScript("window.scrollBy(0,-900)", "");
	  	
	  	Admin_CertificateValidationPageElements.SubmitCertForIssuanceButtonClick();
	  	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Clicked Submit Certificate For Issuance Button");

		//Validate Alert-----------------------------------------------------------------------------
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
		}
		
	  }
	  
	  @Test (priority = 2, groups = {"Regression","BS_Regression","Regression_Chrome"},dataProviderClass = Test_Data.class, dataProvider="CertignaPersonalID_ProposalsOrder_Data")
	  public void CertignaPersonalID_ProposalsOrder (String ProductType, String Product1, String Quantity, String Duration, String License, String CommonName, String StaffName, String Line1, String Line2, String Line3, String Line4, String Line5, String Line6, String Line7, String Line8, String Line9, String Line10, String Line11, String Line12, String Line13, String Line14, String Line15, String Line16, String Line17) throws Exception {
		  
		  Properties prop = new Properties();
		  FileInputStream fis = new FileInputStream(Constants.File_Path + Constants.DataFile_Name);
		  
		  prop.load(fis);
		  
		  test = report.startTest("Certigna Personal ID --> Proposals Order Test - " + Product1);
		     
		  test.log(LogStatus.INFO, "Browser Opened and Url Enterl");
		  test.log(LogStatus.INFO, "Logged in as Admin");
		  
		  System.out.println("Started Proposal For:------------------ " + Product1 );
	
		  
		  Admin_NavigationLinksElements.ClientsAccountsLinkClick();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Click on clients Accounts Link");
		  
		  Admin_ClientAccountsPageElements.SearchQueryFieldFill("FRT");
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Click on Search Query and Enter UK Test");
			 
		  Admin_ClientAccountsPageElements.UpdateButtonClink();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Click on Update Button");
		  
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  jse.executeScript("window.scrollBy(0,500)", "");
			 
		  Thread.sleep(5000);
		  
		  Admin_ClientAccountsPageElements.ValidateResults("FRTE001");
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Search Resusult is Displayed");
			 
		  Admin_ClientAccountsPageElements.ViewAccount();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Click on UK Test Account in search Result");
		     
		  Thread.sleep(1000);
		  
		  
		  Admin_SslDashBoardElements.ProposalsLinkClick();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Clicked on proposal link");
		  
		  Thread.sleep(2000);
		 
		  try {
			  
				  ProposalsPageElements.NewProposalButton2Clink();
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Clicked on New Proposal Button");
				  
				  jse.executeScript("window.scrollBy(0,500)", "");
				  
				  Thread.sleep(2000);
				  
				//Add First Product-----------------------------------------------------------------------  
				  
				  //Select Product Type
				  ProposalsPageElements.ProductTypeFieldSelect(ProductType);
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Selected Product Type");
				  
				  Thread.sleep(1000);
				  
				  //Select Product 
				  ProposalsPageElements.ProductFieldSelect(Product1);
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Selected Product");
				  
				  Thread.sleep(1000);
				
				try {  
					
				  //Select Quantity
				  ProposalsPageElements.QuantityFieldClear();
				  ProposalsPageElements.QuantityFieldSenkeys(Quantity);
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
				  
				//Select Duration----------------------------------------
				  try {
					
					  ProposalsPageElements.DurationFieldSelect(Duration);
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
				  
				  //Fill Common Name Field----------------------------------
				  try { 
					 
					  ProposalsPageElements.CommonNameFieldClear();
					  ProposalsPageElements.CommonNameFieldSendKeys(CommonName);
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
				  
				  ProposalsPageElements.CalculatePricesButtonClink();
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Click on Calculate Prices Button");
				  
				  Thread.sleep(1000);
				  jse.executeScript("window.scrollBy(0,500)", "");
				  
				  test.log(LogStatus.PASS, "Proposal Created");
				  String path = ScreenShot.Image(driver, "Proposal");
				  String imagePath = test.addScreenCapture(path);
				  test.log(LogStatus.INFO, imagePath);
				  
				  Thread.sleep(1000);
					
				  //Click Save 
				
				  ProposalsPageElements.SaveProposalButtonClink();
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Click on Save Proposal Button");
				  
			   	  jse.executeScript("window.scrollBy(0,250)", "");
			  	  Thread.sleep(1000);
				 
			  	  
			  	  //Issue Proposal------------------------------------------------------------------
				  ProposalsPageElements.IssueProposalTabFRClink();
			  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  	  test.log(LogStatus.INFO, "Clicked on Issue Proposal Tab");
			  	  
			   	  jse.executeScript("window.scrollBy(0,250)", "");
				  	
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
			  	  
			  	  jse.executeScript("window.scrollBy(0,500)", "");
			  	  Thread.sleep(1000);
			  	  
			  	  //Convert Proposal To Invoice------------------------------------------------------------------
			  	  
			  	  ProposalsPageElements.ConvertToInvoiceButtonClink();
			  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  	  test.log(LogStatus.INFO, "Clicked Covert to Invoice Button");
			  	  

			    
		   }catch (Exception e) {
				
			   	String path = ScreenShot.Image(driver, "Proposal");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);
				test.log(LogStatus.FAIL, "Test Failed");
				driver.navigate().refresh();
				//Assert.fail( Product1 +" - Exception: "+ e);
				
			}
			  	  

			//Handle Alart-------------------------------------------------------------------------------------  	
			  	try {
			  		
				  	  Alert alert = driver.switchTo().alert();
				  	  alert.accept();
				  	  test.log(LogStatus.INFO, "Clicked on Alert");
				  	  
				  	  jse.executeScript("window.scrollBy(0,500)", "");
			        
			    } catch (Exception e) {
			    	
			    	System.out.println("Alert Not Handled");
			    }		
			
			//View Ordered Certificate--------------------------------------------------------
			
			
			try {
				
				Thread.sleep(1000);
				
				Admin_SslDashBoardElements.OrdersLinkFRClick();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  	test.log(LogStatus.INFO, "Clicked on Orders Link");
			  	
			  	Admin_OrdersPageElements.SavedTabFRClick();
			  	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  	test.log(LogStatus.INFO, "Clicked on Saved Tab");
			  	
				String path = ScreenShot.Image(driver, "Proposal");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);
  	
			  	
			}catch (Exception e) {
				
				String path = ScreenShot.Image(driver, "Proposal");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);
				test.log(LogStatus.INFO, "Invoice Not Issued");
				System.out.println("View Ordered Cert Exception:-  " + e);
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
					String path2 = ScreenShot.Image(driver, "Logout");
					String imagePath2 = test.addScreenCapture(path2);
					test.log(LogStatus.INFO, imagePath2);
					report.endTest(test);
					report.flush();
					Assert.fail("Log Out Failed- "+"Exception: " + e);
					driver.quit();
					
				} 
			
			
			
			 
			//Client Login---------------------------------------------------------------------
			 
		
			try{	
				  Admin_LoginPageElements.EnterUserName("qa@ssl247.fr");
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
					System.out.println("Element Not Found");
					String path2 = ScreenShot.Image(driver, "Element");
					String imagePath2 = test.addScreenCapture(path2);
					test.log(LogStatus.INFO, imagePath2);
					report.endTest(test);
					report.flush();
					Assert.fail("Exception " + e);
				}
			 
			 
			 Thread.sleep(2000);
			 
		//Validate Certificate-------------------------------------------------------------------------	 
		try {	
			
			Admin_MySslDashBoardElements.MySMIMELinkClick();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked on My SMIME Link");
			 
			Admin_MySslDashBoardElements.IncompleSMIMELinkClick();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked on Incomplete SMIME Sub Link");
			
			test.log(LogStatus.PASS, "Saved Order Found");
			String path = ScreenShot.Image(driver, "Proposal");
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.INFO, imagePath);
			 
			Admin_IncompleteSmimePageElements.Column1EditButtonClick();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked to view Product on First Row");
				 
			  
		}catch (Exception e) {
					
			test.log(LogStatus.FAIL, "Saved Order Not Found");
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
	
			Admin_SmimeValidationPageElements.DetailsTabClick();
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked on Details Tab");	
			
			Admin_SmimeValidationPageElements.PassPhraseFieldFill("Test1234");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Passphrase Field");	
			
			Thread.sleep(2000);
			//JavascriptExecutor jse = (JavascriptExecutor)driver;
		  	jse.executeScript("window.scrollBy(0,500)", "");
		  	
		  	Admin_SmimeValidationPageElements.AdminNameFieldSelect("Gideon Ogunleye");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Selected Admin Contact");	
			
			Admin_SmimeValidationPageElements.AdminDivisionFieldFill("Development");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin Division Field");	
			
			Admin_SmimeValidationPageElements.TechnicalNameFieldSelect("Gideon Ogunleye");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Selected Technical Contact");	
			
			Admin_SmimeValidationPageElements.TechDivisionFieldFill("Development");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Tech Division Field");
			
			Thread.sleep(2000);
		  	jse.executeScript("window.scrollBy(0,900)", "");
		  	
		  	Admin_SmimeValidationPageElements.AdminFavouriteColourQuestionFieldFill("Blue");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin Question 1");
		  	
		  	Admin_SmimeValidationPageElements.AdminFavouriteVegetableQuestionFieldFill("Oliver Twist");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin Question 2");
		  	
		  	Admin_SmimeValidationPageElements.AdminFavouriteBookQuestionFieldFill("Carrot");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin Question 3");
		  	
		  	Admin_SmimeValidationPageElements.AdminFavouriteSportQuestionFieldFill("Football");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin Question 4");
		  	
		  	Admin_SmimeValidationPageElements.AdminStreetNameQuestionFieldFill("London");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin Question 5");
			
			
		  	Admin_SmimeValidationPageElements.TechFavouriteColourQuestionFieldFill("Blue");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Tech Question 1");
		  	
		  	Admin_SmimeValidationPageElements.TechFavouriteVegetableQuestionFieldFill("Oliver Twist");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Tech Question 2");
		  	
		  	Admin_SmimeValidationPageElements.TechFavouriteBookQuestionFieldFill("Carrot");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Tech Question 3");
		  	
		  	Admin_SmimeValidationPageElements.TechFavouriteSportQuestionFieldFill("Football");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Tech Question 4");
		  	
		  	Admin_SmimeValidationPageElements.TechStreetNameQuestionFieldFill("London");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Tech Question 5");
			
			Thread.sleep(2000);
		  	jse.executeScript("window.scrollBy(0,1500)", "");
		  	
		  	
		  	Admin_SmimeValidationPageElements.DirectorContactFieldSelect("Gideon Ogunleye");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Selected Director Contact");
		  	
		  	Admin_SmimeValidationPageElements.DirectorDivisionFieldFill("Development");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Director Division Field");
			
			Thread.sleep(2000);
		  	jse.executeScript("window.scrollBy(0,1900)", "");
		  	
		  	Admin_SmimeValidationPageElements.DirectorFavouriteColourQuestionFieldFill("Blue");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Director Question 1");
		  	
		  	Admin_SmimeValidationPageElements.DirectorFavouriteVegetableQuestionFieldFill("Oliver Twist");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Director Question 2");
		  	
		  	Admin_SmimeValidationPageElements.DirectorFavouriteBookQuestionFieldFill("Carrot");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Director Question 3");
		  	
		  	Admin_SmimeValidationPageElements.DirectorFavouriteSportQuestionFieldFill("Football");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Director Question 4");
		  	
		  	Admin_SmimeValidationPageElements.DirectorStreetNameQuestionFieldFill("London");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Director Question 5");
			
			Admin_SmimeValidationPageElements.OrganisationLegalNameFieldFill("SSL247 SARL");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Organisation Legal Nmae Field");
			
			Admin_SmimeValidationPageElements.OrganisationRegistrationNumberFieldFill("05802692");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Organisation Reg Number Field");
		  	
			test.log(LogStatus.PASS, "Details Tab Filled");
			String path1 = ScreenShot.Image(driver, "Proposal");
			String imagePath1 = test.addScreenCapture(path1);
			test.log(LogStatus.INFO, imagePath1);
			
	  }catch (Exception e) {
			
			test.log(LogStatus.FAIL, "Error in Details Tab");
			System.out.println("Element Not Found");
			String path3 = ScreenShot.Image(driver, "Element");
			String imagePath3 = test.addScreenCapture(path3);
			test.log(LogStatus.INFO, imagePath3);
			report.endTest(test);
			report.flush();
			Assert.fail("Exception " + e);
		}	
			
			Thread.sleep(1000);
			//JavascriptExecutor jse = (JavascriptExecutor)driver;
		  	jse.executeScript("window.scrollBy(0,-4000)", "");
		  	
		  	Thread.sleep(5000);
		  	
		  	
	//Miscc Tab------------------------------------------------------------------------------
	  try {
		  
		  Admin_SmimeValidationPageElements.MiscTabClick();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Misc tab Clicked");
		  
		  Thread.sleep(2000);
		  jse.executeScript("window.scrollBy(0,700)", "");
		  
		  Admin_SmimeValidationPageElements.TermsCheckBoxTick();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Terms Checkbox Clicked");
		  
		  //SmimeValidationPageElements.PopUpClick();
		  //driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	
		  
		  test.log(LogStatus.PASS, "Misc Tab Filled");
		  String path1 = ScreenShot.Image(driver, "Proposal");
		  String imagePath1 = test.addScreenCapture(path1);
		  test.log(LogStatus.INFO, imagePath1);
		  test.log(LogStatus.INFO, "Terms Checkbox 2nd Clicked");
		  
		  Thread.sleep(1000);
		  
	  }catch (Exception e) {
			
			test.log(LogStatus.FAIL, "Error in Misc Tab");
			System.out.println("Misc Element Not Found");
			String path3 = ScreenShot.Image(driver, "Element");
			String imagePath3 = test.addScreenCapture(path3);
			test.log(LogStatus.INFO, imagePath3);
			
			//report.endTest(test);
			//report.flush();
			//Assert.fail("Exception " + e);
		}
	  
		Thread.sleep(1000);
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
	  	jse.executeScript("window.scrollBy(0,-700)", "");
	  	
	  	Admin_SmimeValidationPageElements.SaveChangesButtonClick();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Clicked Save Chages Button");
		
		test.log(LogStatus.PASS, "Cert Validation Complete");
		String path1 = ScreenShot.Image(driver, "Proposal");
		String imagePath1 = test.addScreenCapture(path1);
		test.log(LogStatus.INFO, imagePath1);
	 

	/*
		//Validate Alert-----------------------------------------------------------------------------
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
		}
    */
		
	  }
	  
	  @Test (priority = 3, groups = {"Regression","BS_Regression","Regression_Chrome"},dataProviderClass = Test_Data.class, dataProvider="CodeSigningCerts_ProposalsOrder_Data")
	  public void CodeSigningCerts_Proposals (String ProductType, String Product1, String Quantity, String Duration, String License, String CommonName, String StaffName, String Line1, String Line2, String Line3, String Line4, String Line5, String Line6, String Line7, String Line8, String Line9, String Line10, String Line11, String Line12, String Line13, String Line14, String Line15, String Line16, String Line17) throws Exception {
		  
		  Properties prop = new Properties();
		  FileInputStream fis = new FileInputStream(Constants.File_Path + Constants.DataFile_Name);
		  
		  prop.load(fis);
		  
		  test = report.startTest("Certigna Code Signing --> Proposals Order Test - " + Product1);
		     
		  test.log(LogStatus.INFO, "Browser Opened and Url Enterl");
		  test.log(LogStatus.INFO, "Logged in as Admin");
		  
		  System.out.println("Started Proposal For:------------------ " + Product1 );
		  
		  Admin_NavigationLinksElements.ClientsAccountsLinkClick();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Click on clients Accounts Link");
			  
		  Admin_ClientAccountsPageElements.SearchQueryFieldFill("FRT");
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Click on Search Query and Enter UK Test");
			 
		  Admin_ClientAccountsPageElements.UpdateButtonClink();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Click on Update Button");
		  
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  jse.executeScript("window.scrollBy(0,500)", "");
			 
		  Thread.sleep(5000);
		  
		  Admin_ClientAccountsPageElements.ValidateResults("FRTE001");
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Search Resusult is Displayed");
			 
		  Admin_ClientAccountsPageElements.ViewAccount();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Click on UK Test Account in search Result");
		     
		  Thread.sleep(1000);
		  
		  
		  Admin_SslDashBoardElements.ProposalsLinkClick();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Clicked on proposal link");
		  
		  Thread.sleep(2000);
		 
		  try {
			  
				  ProposalsPageElements.NewProposalButton2Clink();
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Clicked on New Proposal Button");
				  
				  jse.executeScript("window.scrollBy(0,500)", "");
				  
				  Thread.sleep(2000);
				  
				//Add First Product-----------------------------------------------------------------------  
				  
				  //Select Product Type
				  ProposalsPageElements.ProductTypeFieldSelect(ProductType);
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Selected Product Type");
				  
				  Thread.sleep(1000);
				  
				  //Select Product 
				  ProposalsPageElements.ProductFieldSelect(Product1);
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Selected Product");
				  
				  Thread.sleep(1000);
				
				try {  
					
				  //Select Quantity
				  ProposalsPageElements.QuantityFieldClear();
				  ProposalsPageElements.QuantityFieldSenkeys(Quantity);
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
				  
				//Select Duration----------------------------------------
				  try {
					
					  ProposalsPageElements.DurationFieldSelect(Duration);
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
				  
				  //Fill Common Name Field----------------------------------
				  try { 
					 
					  ProposalsPageElements.CommonNameFieldClear();
					  ProposalsPageElements.CommonNameFieldSendKeys(CommonName);
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
				  
				  ProposalsPageElements.CalculatePricesButtonClink();
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Click on Calculate Prices Button");
				  
				  Thread.sleep(1000);
				  jse.executeScript("window.scrollBy(0,500)", "");
				  
				  test.log(LogStatus.PASS, "Proposal Created");
				  String path = ScreenShot.Image(driver, "Proposal");
				  String imagePath = test.addScreenCapture(path);
				  test.log(LogStatus.INFO, imagePath);
				  
				  Thread.sleep(1000);
					
				  //Click Save 
				
				  ProposalsPageElements.SaveProposalButtonClink();
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Click on Save Proposal Button");
				  
			   	  jse.executeScript("window.scrollBy(0,250)", "");
			  	  Thread.sleep(1000);
				 
			  	  
			  	  //Issue Proposal------------------------------------------------------------------
				  ProposalsPageElements.IssueProposalTabFRClink();
			  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  	  test.log(LogStatus.INFO, "Clicked on Issue Proposal Tab");
			  	  
			   	  jse.executeScript("window.scrollBy(0,250)", "");
				  	
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
			  	  
			  	  jse.executeScript("window.scrollBy(0,500)", "");
			  	  Thread.sleep(1000);
			  	  
			  	  //Convert Proposal To Invoice------------------------------------------------------------------
			  	  
			  	  ProposalsPageElements.ConvertToInvoiceButtonClink();
			  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  	  test.log(LogStatus.INFO, "Clicked Covert to Invoice Button");
			  	  

			    
		   }catch (Exception e) {
				
			   	String path = ScreenShot.Image(driver, "Proposal");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);
				test.log(LogStatus.FAIL, "Test Failed");
				driver.navigate().refresh();
				//Assert.fail( Product1 +" - Exception: "+ e);
				
			}
			  	  

			//Handle Alart-------------------------------------------------------------------------------------  	
			  	try {
			  		
				  	  Alert alert = driver.switchTo().alert();
				  	  alert.accept();
				  	  test.log(LogStatus.INFO, "Clicked on Alert");
				  	  
				  	  jse.executeScript("window.scrollBy(0,500)", "");
			        
			    } catch (Exception e) {
			    	
			    	System.out.println("Alert Not Handled");
			    }		
			
			//View Ordered Certificate--------------------------------------------------------
			
			
			try {
				
				Thread.sleep(1000);
				
				Admin_SslDashBoardElements.OrdersLinkFRClick();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  	test.log(LogStatus.INFO, "Clicked on Orders Link");
			  	
			  	Admin_OrdersPageElements.SavedTabFRClick();
			  	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  	test.log(LogStatus.INFO, "Clicked on Saved Tab");
			  	
				String path = ScreenShot.Image(driver, "Proposal");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);
	
			  	
			}catch (Exception e) {
				
				String path = ScreenShot.Image(driver, "Proposal");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);
				test.log(LogStatus.INFO, "Invoice Not Issued");
				System.out.println("View Ordered Cert Exception:-  " + e);
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
				   
				
				  Admin_LoginPageElements.EnterUserName("qa@ssl247.fr");
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
					System.out.println("Element Not Found");
					String path2 = ScreenShot.Image(driver, "Element");
					String imagePath2 = test.addScreenCapture(path2);
					test.log(LogStatus.INFO, imagePath2);
					report.endTest(test);
					report.flush();
					Assert.fail("Exception " + e);
				}
			 
			 
			 Thread.sleep(2000);
			 
		//Validate Certificate-------------------------------------------------------------------------	 
			
			Admin_MySslDashBoardElements.MyCodeSigningCertsLinkClick();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked on My Code Signing Link");
			    
			Admin_MySslDashBoardElements.IncompleteCodeSigningCertsLinkClick();
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked on Incomplete Certs");	
			
			Admin_IncompleteCodeSigningCertsPageElements.Column1EditButtonClick();
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked to view certificate on First Row");
			
			test.log(LogStatus.PASS, "Saved Order Found");
			String path = ScreenShot.Image(driver, "Proposal");
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.INFO, imagePath);
		  	
		 //Admin Tab----------------------------------------------------------
		 try {  	
			 
		  	Admin_CodeSigningCertsValidationPageElements.AdminTabClick();
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked Admin Tab");	
			
			Admin_CodeSigningCertsValidationPageElements.AdminNameFieldSelect("Gideon Ogunleye");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Selected Admin contact name");	
			
			Admin_CodeSigningCertsValidationPageElements.AdminOrganisationFieldFill("SSL247  SARL");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin Organisation Name");
			
			Thread.sleep(1000);
		  	jse.executeScript("window.scrollBy(0,500)", "");
		  	
		  	Admin_CodeSigningCertsValidationPageElements.AdminFavouriteColourQuestionFieldFill("Blue");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin Questtion 1");
			
			Admin_CodeSigningCertsValidationPageElements.AdminFavouriteBookQuestionFieldFill("Oliver Twist");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin Question 2");
			
			Admin_CodeSigningCertsValidationPageElements.AdminFavouriteVegetableQuestionFieldFill("Carrot");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin Question 3");
			
			Admin_CodeSigningCertsValidationPageElements.AdminFavouriteSportQuestionFieldFill("Football");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin Question 4");
			
			Admin_CodeSigningCertsValidationPageElements.AdminStreetNameQuestionFieldFill("London");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin Question 5");
			
			test.log(LogStatus.PASS, "Admin Tab Filled");
			String path2 = ScreenShot.Image(driver, "Proposal");
			String imagePath2 = test.addScreenCapture(path2);
			test.log(LogStatus.INFO, imagePath2);
			
		  }catch (Exception e) {
				
				test.log(LogStatus.FAIL, "Error In Admin Tab");
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
			  
			  Admin_CodeSigningCertsValidationPageElements.TechnicalTabClick();
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Click on Technical Tab");
			  
			  Admin_CodeSigningCertsValidationPageElements.TechnicalNameFieldSelect("Gideon Ogunleye");
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Selected Technical Contact");
			  
			  Admin_CodeSigningCertsValidationPageElements.TechnicalOrganisationFieldFill("SSL247 SARL");
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Filled Tech Organisation Field");
			  
			  Thread.sleep(1000);
			  jse.executeScript("window.scrollBy(0,500)", "");
			  	
			  Admin_CodeSigningCertsValidationPageElements.TechFavouriteColourQuestionFieldFill("Blue");
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Filled Tech Questtion 1");
				
			  Admin_CodeSigningCertsValidationPageElements.TechFavouriteBookQuestionFieldFill("Oliver Twist");
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Filled Tech Question 2");
				
		      Admin_CodeSigningCertsValidationPageElements.TechFavouriteVegetableQuestionFieldFill("Carrot");
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Filled Tech Question 3");
				
			  Admin_CodeSigningCertsValidationPageElements.TechFavouriteSportQuestionFieldFill("Football");
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Filled Tech Question 4");
				
			  Admin_CodeSigningCertsValidationPageElements.TechStreetNameQuestionFieldFill("London");
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Filled Tech Question 5");
			  
			  test.log(LogStatus.PASS, "Tech Tab Filled");
			  String path2 = ScreenShot.Image(driver, "Proposal");
			  String imagePath2 = test.addScreenCapture(path2);
			  test.log(LogStatus.INFO, imagePath2);
			  
		  }catch (Exception e) {
				
				test.log(LogStatus.FAIL, "Error In Technical Tab");
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
		

		//Organisation Tab-------------------------------------------------------------------------------------------
		try {
			
			Admin_CodeSigningCertsValidationPageElements.OrganisationTabClick();	
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked Organisation Tab");
			
			Admin_CodeSigningCertsValidationPageElements.OrganisationLegalNameFieldFill("SSL247 SARL");	
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Organisation Legal Name Field");
			
			Admin_CodeSigningCertsValidationPageElements.OrganisationCategoryFieldSelect("Registered company or corporation");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Selected Organisation Category");
			
			Admin_CodeSigningCertsValidationPageElements.OrganisationRegistrationNumberFieldFill("05802692");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Organisation Rgistration Number");
			
			test.log(LogStatus.PASS, "Organisation Tab Filled");
			String path2 = ScreenShot.Image(driver, "Proposal");
			String imagePath2 = test.addScreenCapture(path2);
			test.log(LogStatus.INFO, imagePath2);
			
			
		}catch (Exception e) {
			
			test.log(LogStatus.FAIL, "Error In Organisation Tab");
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
	  	
	  	
	  	//Director Tab-------------------------------------------------------------------------------------------------
	  	try {
	  		
	  		Admin_CodeSigningCertsValidationPageElements.DirectorTabClick();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked Director Tab");
	  		
	  		
	  		Admin_CodeSigningCertsValidationPageElements.DirectorContactFieldSelect("Gideon Ogunleye");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Selected Director Contact Name");
	  		
	  		Admin_CodeSigningCertsValidationPageElements.DirectorOrganisationFieldFill("SSL247 SARL");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Director Organisation Name Field");
	  		
	  		
			Thread.sleep(1000);
			jse.executeScript("window.scrollBy(0,500)", "");
	  		
	  		
	  		Admin_CodeSigningCertsValidationPageElements.DirectorFavouriteColourQuestionFieldFill("Blue");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Director Tab Questtion 1");
	  		
	  		Admin_CodeSigningCertsValidationPageElements.DirectorFavouriteVegetableQuestionFieldFill("Oliver Twist");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Director Tab Questtion 2");
	  		
	  		Admin_CodeSigningCertsValidationPageElements.DirectorFavouriteBookQuestionFieldFill("Carrot");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Director Tab Questtion 3");
	  		
	  		Admin_CodeSigningCertsValidationPageElements.DirectorFavouriteSportQuestionFieldFill("Football");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Director Tab Questtion 4");
	  		
	  		Admin_CodeSigningCertsValidationPageElements.DirectorStreetNameQuestionFieldFill("London");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Director Tab Questtion 1");
			
			test.log(LogStatus.PASS, "Director Tab Filled");
			String path2 = ScreenShot.Image(driver, "Proposal");
			String imagePath2 = test.addScreenCapture(path2);
			test.log(LogStatus.INFO, imagePath2);
	  		
	  		
	  	}catch (Exception e) {
			
			test.log(LogStatus.FAIL, "Error In Director Tab");
			System.out.println("Element Not Found");
			String path2 = ScreenShot.Image(driver, "Element");
			String imagePath2 = test.addScreenCapture(path2);
			test.log(LogStatus.INFO, imagePath2);
			report.endTest(test);
			report.flush();
			Assert.fail("Exception " + e);
		}
	  	
		
		
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
	  	jse.executeScript("window.scrollBy(0,-2000)", "");
	  	Thread.sleep(1000);
	  	 	
		//Miscc Tab------------------------------------------------------------------------------
		  try {
			  
			  Admin_CodeSigningCertsValidationPageElements.TermsTabClick();
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Misc tab Clicked");
			  
			  Thread.sleep(2000);
			  jse.executeScript("window.scrollBy(0,700)", "");
			  
			  Admin_CodeSigningCertsValidationPageElements.TermsCheckBoxTick();
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Terms Checkbox Clicked");
			  
			  test.log(LogStatus.PASS, "Misc Tab Filled");
			  String path1 = ScreenShot.Image(driver, "Proposal");
			  String imagePath1 = test.addScreenCapture(path1);
			  test.log(LogStatus.INFO, imagePath1);
			  test.log(LogStatus.INFO, "Terms Checkbox 2nd Clicked");
			  
			  Thread.sleep(1000);
			  
		  }catch (Exception e) {
				
				test.log(LogStatus.FAIL, "Error in Misc Tab");
				System.out.println("Misc Element Not Found");
				String path3 = ScreenShot.Image(driver, "Element");
				String imagePath3 = test.addScreenCapture(path3);
				test.log(LogStatus.INFO, imagePath3);
				
			}
	  	
		Thread.sleep(1000);
	  	jse.executeScript("window.scrollBy(0,-900)", "");
	  	
		String path1 = ScreenShot.Image(driver, "Proposal");
		String imagePath1 = test.addScreenCapture(path1);
		test.log(LogStatus.INFO, imagePath1);
		//test.log(LogStatus.INFO, "Terms Checkbox 2nd Clicked");
	  	
	  	Admin_CodeSigningCertsValidationPageElements.SubmitCertForIssuanceButtonClick();
	  	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Clicked Submit Certificate For Issuance Button");
	
	  }


  
}
