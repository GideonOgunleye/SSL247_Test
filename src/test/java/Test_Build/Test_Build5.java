package Test_Build;

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
import BaseUtilities.HtmlUnit;
import BaseUtilities.TakeScreenShot;
import PageFactory.Client.Client_BillingPage;
import PageFactory.Client.Client_CertificateDetailsPage;
import PageFactory.Client.Client_IssuedCertificatesPage;
import PageFactory.Client.Client_LoginPage;
import PageFactory.Client.Client_MySslDashBoard;
import PageFactory.Client.Client_NavigationLinks;
import Regression_Test.Test_Data;

import org.testng.annotations.BeforeTest;
//import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.net.HttpURLConnection;


public class Test_Build5 extends Chrome  {
	
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
	Test_Build5 TestBuild5;
	
   /*public Test_Build5(WebDriver driver) {
	    	
	        this.driver = driver;
	  }
	
   public void ImageTest() {
   	
       try {
       	
	        	
	  		  List<WebElement> inputs = driver.findElements(By.tagName("img"));
			  System.out.println("Total images are " + inputs.size());
			  
			  for (Iterator<WebElement> iterator = inputs.iterator(); iterator.hasNext();) {
				  
			      WebElement webElement = (WebElement) iterator.next();
			      URLConnection urlConnection = new URL(webElement.getAttribute("src")).openConnection();
			      int size = urlConnection.getContentLength();
			      System.out.println("Image Src Is:"+ webElement.getAttribute("src"));
		    	  test.log(LogStatus.INFO, "Image Src Is:"+ webElement.getAttribute("src"));
			      System.out.println("Image Size is: " + size+"Bytes");
		    	  test.log(LogStatus.INFO, "Image Size is: " + size+"Bytes");
			      
			      if (size > 250000 ) {
			    	  
			    	  System.out.println("Image Size is greater than 150kb!!!");
			    	  test.log(LogStatus.FAIL, "Image Size is greater than 150kb" );
			      }
			      
			      System.out.println("-----------------------------------------------------");
			   
			  }
       	
       }catch (Exception e) {

       	System.out.println("Image Array Method not Validated");
       	System.out.println("e");
       	
       }
   	
   	
   }*/
	
	@BeforeMethod (groups = {"Sanity","Smoke","BS_Smoke","BS_Sanity","BS_Sanity","BS_DailySanity","Smoke_Firefox","Smoke_Chrome","Sanity_Chrome"})
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
		TestBuild5 = new Test_Build5();
		
		
		//LoginPageElements.ClientLogin();
		
		Thread.sleep(2000);		
	}

	
	@AfterMethod (groups = {"Sanity","Smoke","BS_Smoke","BS_Sanity","BS_DailySanity", "BS_Sanity","Smoke_Firefox","Smoke_Chrome","Sanity_Chrome"}, alwaysRun = true)
	public void Logout (ITestResult result) throws Exception {

	    //Take Screen Shots
	/*			
	  	String path =  ScreenShot.Image(driver, "TestSecreenShot-" + result.getMethod().getMethodName());
		String imagePath = test.addScreenCapture(path);
		test.log(LogStatus.INFO, "Test Complete", imagePath);
	*/	
		//driver.navigate().refresh();
		
		//Thread.sleep(1000);
	/*	
		String path2 = ScreenShot.Image(driver, "Logout");
		String imagePath2 = test.addScreenCapture(path2);
		test.log(LogStatus.INFO, imagePath2);
	*/
		report.endTest(test);
		report.flush();
	
		
	}
	

	
	@Test (priority = 0, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
	  public void Get_Attribute () throws Exception{
		 

		
		  Properties prop = new Properties();
		  FileInputStream fis = new FileInputStream(Constants.File_Path + Constants.DataFile_Name);
		  prop.load(fis);
			  
		  report = ExtentFactory.getInstance3();
				
		  //test = report.startTest("<---------------------------Test Suite Start----------------------------------->");
		  test = report.startTest("Url Test --> Validate Links on- "+ "France Website"); 
		  
	     // TODO 
	        
	     //String homePage = "https://www.ssl247.co.uk";
	     String url = "";

	        
	     //driver = new ChromeDriver();
	        
	     driver.manage().window().maximize();
	        
	     //driver.get(prop.getProperty("FrenchUrl2"));
	     driver.get("https://www.ssl247.ae/ssl-certificates");
	        
	   	 //List<WebElement> demovar=driver.findElements(By.tagName("a"));
	     List<WebElement> demovar = driver.findElement(By.xpath(".//*[@class='contentWrapper']")).findElements(By.tagName("a"));
		 System.out.println(demovar.size());
		
		 ArrayList<String> hrefs = new ArrayList<String>(); //List for storing all href values for 'a' tag
		 

		    for (WebElement var : demovar) {
		    	
		    	url = var.getAttribute("href");
		    	
	            if(url == null || url.isEmpty()){
	            	System.out.println("URL is either not configured for anchor tag or it is empty");
	            	                continue;
	             }
	            
	              if(!url.contains("ssl247.")){
	            	  
	                  System.out.println("URL belongs to another domain, skipping it.");
	                  continue;
	                  
	              	}
	              
	              if(url.contains("/#")){
	            	  
	                  System.out.println("Irrelevant Url");
	                  continue;
	                  
	              	}
	            
		        System.out.println(var.getText()); // used to get text present between the anchor tags
		        System.out.println(var.getAttribute("href"));
		        hrefs.add(var.getAttribute("href")); 
		        System.out.println("*************************************");
		
		          
		    }

		    //Navigating to each link
		    int i=0;
		    for (String href : hrefs) {
		    	
		        driver.navigate().to(href);
		        System.out.println((++i)+": navigated to URL with href: "+href);
		        Thread.sleep(3000); // To check if the navigation is happening properly.
		        
		        try {
		        	
		        	 System.out.println("Page Title Is:-" + driver.getTitle());
		        	 
		        }catch (Exception e) {
		        	
		        	System.out.println("Page Has no Title");
		        	System.out.println(e);
		        }
		        
		        
		        try {
		        	
		        	if (driver.getTitle().contains("404")) {
		        		
		        		System.out.println("ERROR 404 FOUND ON PAGE!!!!!");
		        		test.log(LogStatus.FAIL, "ERROR 404 FOUND ON PAGE!!!!!: - " + href);
		        		String path = ScreenShot.Image(driver, "Link Error");
			  			String imagePath = test.addScreenCapture(path);
			  			test.log(LogStatus.INFO, imagePath);
			  			
			  			//test.log(LogStatus.FAIL, "Failed Link is:" + href);
			  			
		        		
		        	}else if (driver.getPageSource().contains("not found")){
		        		
		        		System.out.println("Page Not Found Error..!!");
		        		test.log(LogStatus.FAIL, "Page Not Found Error..!!: - " + href);
		        		String path = ScreenShot.Image(driver, "Link Error");
			  			String imagePath = test.addScreenCapture(path);
			  			test.log(LogStatus.INFO, imagePath);
			  			
			  			//test.log(LogStatus.FAIL, "Failed Link is:" + href);
		        		
		        	}
		        	
		        try {
		        	
		    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content']"));
		    		//String PageContentBox = ContentDiv.getAttribute("value");
		    		
			         if(ContentDiv.getText().isEmpty()) {
			        		
			        	System.out.println("Content Div is empty");
			        	test.log(LogStatus.FAIL, "Content Link Is Empty----:" + href);
			        		
			         }else {
			        		
			        		System.out.println("Page Has Content");
			        		test.log(LogStatus.INFO, "Page Has Content:----" + href);
			        	}
		        	
		        }catch (Exception e){
		        	
		        	//test.log(LogStatus.FAIL, "Div Link Not Found:" + href);
		        	//test.log(LogStatus.FAIL, driver.getTitle());
		        	System.out.println("Page Content Dive Not Found");
		        	//System.out.println("Exception On Page:----" + e);

	        		}
		        
		        //Try Page Content # Div
		        
		        try {
		        	
			    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content ha']"));
			    		//String PageContentBox = ContentDiv.getAttribute("value");
			    		
				         if(ContentDiv.getText().isEmpty()) {
				        		
				        	System.out.println("Content Div is empty");
				        	test.log(LogStatus.FAIL, "Content Link Is Empty----:" + href);
				        		
				         }else {
				        		
				        		System.out.println("Page Has Content");
				        		test.log(LogStatus.INFO, "Page Has Content:----" + href);
				        	}
			        	
			      }catch (Exception e){
			        	
			        	//test.log(LogStatus.FAIL, "Div Link Not Found:" + href);
			        	//test.log(LogStatus.FAIL, driver.getTitle());
			    	  System.out.println("Page Content # Dive Not Found");
			    	 // System.out.println("Exception On Page:----" + e);

		        	}
		        
		        //Try Page Content Fullwidth_Page	
		        
		        try {
		        	
			    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content fullwidth_page']"));
			    		//String PageContentBox = ContentDiv.getAttribute("value");
			    		
				         if(ContentDiv.getText().isEmpty()) {
				        		
				        	System.out.println("Content Div is empty");
				        	test.log(LogStatus.FAIL, "Content Link Is Empty----:" + href);
				        		
				         }else {
				        		
				        		System.out.println("Page Has Content");
				        		test.log(LogStatus.INFO, "Page Has Content:----" + href);
				        	}
			        	
			      }catch (Exception e){
			        	
			        	//test.log(LogStatus.FAIL, "Div Link Not Found:" + href);
			        	//test.log(LogStatus.FAIL, driver.getTitle());
			    	  System.out.println("page-content fullwidth_page Dive Not Found");
			    	  //System.out.println("Exception On Page:----" + e);

		        	}
		        
		        
		        	
		     }catch (Exception k){
		        	
		        System.out.println(k);
		    }
		        
		        //new Test_Build5(driver).ImageTest();
		        //TestBuild5.ImageTest();
		        
		        //TODO
		        try {
		           	
		        	
			  		  List<WebElement> inputs = driver.findElements(By.tagName("img"));
					  System.out.println("Total images are " + inputs.size());
					  
					  for (Iterator<WebElement> iterator = inputs.iterator(); iterator.hasNext();) {
						  
					      WebElement webElement = (WebElement) iterator.next();
					      URLConnection urlConnection = new URL(webElement.getAttribute("src")).openConnection();
					      int size = urlConnection.getContentLength();
					      System.out.println("Image Src Is:"+ webElement.getAttribute("src"));
				    	  test.log(LogStatus.INFO, "Image Src Is:"+ webElement.getAttribute("src"));
					      System.out.println("Image Size is: " + size+"Bytes");
				    	  test.log(LogStatus.INFO, "Image Size is: " + size+"Bytes");
					      
					      if (size > 250000 ) {
					    	  
					    	  System.out.println("Image Size is greater than 150kb!!!");
					    	  test.log(LogStatus.FAIL, "Image Size is greater than 150kb" );
					      }
					      
					      System.out.println("-----------------------------------------------------");
					   
					  }
		       	
		       }catch (Exception e) {

		       	System.out.println("Image Array Method not Validated");
		       	System.out.println("e");
		       	
		       }
		        
		        driver.navigate().back();
		        Thread.sleep(3000); // To check if the navigation is happening properly.
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		        System.out.println("Navigate Back");
		        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		    }

	    }
		  
/*	 @AfterTest (groups = {"Sanity","SQL","Regression","Smoke"})
	  public void afterTest() throws Exception {
		  
		  Thread.sleep(10000);
			 //report.endTest(test);
			 
		driver.quit();

		  
	  }*/

	
}