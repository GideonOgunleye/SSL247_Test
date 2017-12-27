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


public class Client_MyUsersPage extends DriverLoad {
	ExtentReports report;
	ExtentTest test;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[4]/div[2]/div[2]/div[1]/div/address/div/a[1]")
	WebElement User1_EditButton;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[4]/div[2]/div[2]/div[2]/div/address/div/a[1]")
	WebElement User2_EditButton;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[4]/div[2]/div[2]/div[3]/div/address/div/a[1]")
	WebElement User3_EditButton;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[4]/div[2]/div[2]/div[4]/div/address/div/a[1]")
	WebElement User4_EditButton;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[4]/div[2]/div[2]/div[5]/div/address/div/a[1]")
	WebElement User5_EditButton;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[4]/div[2]/div[2]/div[6]/div/address/div/a[1]")
	WebElement User6_EditButton;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[4]/div[2]/h2")
	WebElement PageHeader;
	
	@FindBy(css = "a[href*='/myssl/contacts/new']")
	WebElement NewUserButton;
	

	
	public Client_MyUsersPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	
	public String PageHeader_GetText() {
		
		return PageHeader.getText();
		
	}
	
	
	public void User1_EditButton_Clink(){
		
		User1_EditButton.click();
	}

	public void User2_EditButton_Clink(){
		
		User2_EditButton.click();
	}
	
	public void User3_EditButton_Clink(){
		
		User3_EditButton.click();
	}
	
	public void User4_EditButton_Clink(){
		
		User4_EditButton.click();
	}
	
	public void User5_EditButton_Clink(){
		
		User5_EditButton.click();
	}
	
	public void User6_EditButton_Clink(){
		
		User6_EditButton.click();
	}
	
	public void NewUserButton_Clink(){
		
		NewUserButton.click();
	}

}
