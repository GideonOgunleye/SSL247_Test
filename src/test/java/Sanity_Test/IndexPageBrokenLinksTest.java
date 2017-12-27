package Sanity_Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilities.AlertBox;
import BaseUtilities.BrowserStack;
import BaseUtilities.Chrome;
import BaseUtilities.Constants;
import BaseUtilities.DriverLoad;
import BaseUtilities.ExtentFactory;
import BaseUtilities.FindLinks;
import BaseUtilities.TakeScreenShot;
import PageFactory.Client.Client_LoginPage;
import PageFactory.Client.Client_NavigationLinks;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class IndexPageBrokenLinksTest extends Chrome {
  
	ExtentReports report;
	ExtentTest test;
	Client_NavigationLinks NavigationElements;
	Client_LoginPage 	LoginPageElements;
	AlertBox AlertBoxElements;
	TakeScreenShot ScreenShot;
	FindLinks Links;

/*  @BeforeMethod (groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
  public void beforeMethod() throws Exception {
	  
	  NavigationElements = new NavigationLinks(driver);
	  LoginPageElements = new LoginPage(driver);
	  AlertBoxElements = new AlertBox(driver);
	  ScreenShot = new TakeScreenShot();
	  Links = new  FindLinks(driver);
	  
	  
	  report = ExtentFactory.getInstance4();

	  
  }

  @AfterMethod (groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
  public void afterMethod(ITestResult result) throws IOException, Exception {
	  

		report.endTest(test);
		report.flush();
	

	  
  }*/
  
  
  
  
  @Test (priority = 0, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void HomePage_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	  NavigationElements = new Client_NavigationLinks(driver);
	  LoginPageElements = new Client_LoginPage(driver);
	  AlertBoxElements = new AlertBox(driver);
	  ScreenShot = new TakeScreenShot();
	  Links = new  FindLinks(driver);
	  
	  //report = ExtentFactory.getInstance4();
	  //test = report.startTest("Nav Links Test --> HomePage Test-  " + Websitename);
	 try { 
		 
	  driver.get(WebsiteUrl);
	  /*driver.manage().window().maximize();*/
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  
	 }catch (Exception e) {
		 
		 System.out.println(e);
	 }
	  try {
		  
	     // TODO - Find All Links Method
	        System.out.println("Loaded..............");
		  //Links.Indexpagelinks(Websitename, Path, driver.getCurrentUrl());
		  
		  Links.Submenupagelinks(Websitename, Path, driver.getCurrentUrl());
	  	
	  }catch (Exception e) {
	  						
	  		//test.log(LogStatus.FAIL, "Validation Failed");
	  		Assert.fail("Exception " + e);
	  }

  }
  
}
