package PageFactory.Admin;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilities.BrowserStack;
import BaseUtilities.DriverLoad;

public class Admin_OutgoingEmailsLogPage extends DriverLoad {
	
	
	/*****Main Menu*******/
	@FindBy(xpath = ".//*[@id='mainContainer']/div[6]/div/div/table/tbody/tr[1]/td[1]")
	WebElement Col1_Subject;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[6]/div/div/table/tbody/tr[1]/td[4]/a")
	WebElement Col1_ViewButtion;
	

	
	
	
	
	
	public Admin_OutgoingEmailsLogPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 100), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	
	public boolean Col1_SubjectContains (String Product){
		
		return Col1_Subject.getText().contains(Product);
		
	}
	
	public void Col1_ViewButtionClick(){
		
		Col1_ViewButtion.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//assertTrue(driver.getTitle().contains("SSL247 Accounts"));

	}

	
}
