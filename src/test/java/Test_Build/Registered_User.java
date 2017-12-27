package Test_Build;

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
import PageFactory.Client.Client_NewUserPage;
import PageFactory.Client.Client_PendingCertificatesPage;
import PageFactory.Client.Client_RegisterDomainPage;
import PageFactory.Client.Client_ShoppingBasketPage;
import PageFactory.Client.Client_SmimeValidationPage;
import PageFactory.Client.Client_ViewOrderPage;
import Regression_Test.Test_Data;
import Sanity_Test.Test_DataSanity;

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

public class Registered_User extends Chrome2  {
	
	AlertBox	AlertBoxElements;
	ExtentReports report;
	ExtentTest test;
	TakeScreenShot ScreenShot;
	CsR CsrElements;
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
	Client_NewUserPage	Client_NewUserPageElements;
	Client_PendingCertificatesPage	Client_PendingCertificatesPageElements;
	Client_RegisterDomainPage	Client_RegisterDomainPageElements;
	Client_ShoppingBasketPage	Client_ShoppingBasketPageElements;
	Client_SmimeValidationPage	Client_SmimeValidationPageElements;
	Client_ViewOrderPage	Client_ViewOrderPageElements;

	
	@BeforeMethod (groups = {"Sanity","Smoke","BS_Smoke","BS_Sanity","BS_Sanity","BS_DailySanity","Smoke_Firefox","Smoke_Chrome","Sanity_Chrome"})
	public void Login () throws Exception {
		
		AlertBoxElements	= new AlertBox(driver);
		CsrElements	= new CsR(driver);
		ScreenShot	= new TakeScreenShot();
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
		Client_NewUserPageElements	 = new Client_NewUserPage(driver);
		Client_PendingCertificatesPageElements	 = new Client_PendingCertificatesPage(driver);
		Client_RegisterDomainPageElements	 = new Client_RegisterDomainPage(driver);
		Client_ShoppingBasketPageElements	 = new Client_ShoppingBasketPage(driver);
		Client_SmimeValidationPageElements	 = new Client_SmimeValidationPage(driver);
		Client_ViewOrderPageElements	 = new Client_ViewOrderPage(driver);
		 
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
	
}
