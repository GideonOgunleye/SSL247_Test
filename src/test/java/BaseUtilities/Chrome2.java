package BaseUtilities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Chrome2 {
	
	
	public WebDriver driver;
	


  @BeforeMethod (groups = {"Sanity","SQL","Regression","Smoke"} )
  public void beforeTest() throws IOException  {
	
 	 
	  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-2.exe");
	  //driver = new ChromeDriver();  
	  //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	  
	  ChromeOptions o = new ChromeOptions();
	  o.addArguments("disable-extensions");
	  o.addArguments("--start-maximized");
	  driver = new ChromeDriver(o);
	  
	  
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
   
  }

  @AfterMethod (groups = {"Sanity","SQL","Regression","Smoke"})
  public void afterTest() throws Exception {
	  
	  Thread.sleep(1000);
		 //report.endTest(test);
		 
	driver.quit();

	  
  }

 
  
}
