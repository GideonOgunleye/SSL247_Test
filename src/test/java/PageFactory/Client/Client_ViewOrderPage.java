package PageFactory.Client;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilities.DriverLoad;

import org.testng.Assert;


public class Client_ViewOrderPage extends DriverLoad {
	ExtentReports report;
	ExtentTest test;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[4]/div[2]/div[2]/table/tbody/tr/td[5]/a")
	WebElement CompleteOrderButton;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[4]/div[2]/div[2]/table/tbody/tr/td[6]/a")
	WebElement CompleteButton;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[4]/div[2]/h2")
	WebElement PageHeader;
	

	
	public Client_ViewOrderPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	
	public String PageHeader_GetText() {
		
		return PageHeader.getText();
		
	}
	
	
	public void CompleteOrderButton_Clink(){
		
		CompleteOrderButton.click();
	}
	
	public void CompleteButton_Clink(){
		
		CompleteButton.click();
	}

	

}
