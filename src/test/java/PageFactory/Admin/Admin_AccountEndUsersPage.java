package PageFactory.Admin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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


public class Admin_AccountEndUsersPage extends DriverLoad {
	ExtentReports report;
	ExtentTest test;
	
	
	/*****Users Page Elements******/
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[1]/div/address/strong[1]")
	WebElement User1_Link;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[1]/div/address/div[2]/div/button")
	WebElement User1_ActionButton;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[1]/div/address/div[2]/div/ul/li[1]/a")
	WebElement User1_EditLink;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[2]/div/address/strong[1]")
	WebElement User2_Link;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[2]/div/address/div[2]/div/button")
	WebElement User2_ActionButton;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[2]/div/address/div[2]/div/ul/li[1]/a")
	WebElement User2_EditLink;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[3]/div/address/strong[1]")
	WebElement User3_Link;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[3]/div/address/div[2]/div/button")
	WebElement User3_ActionButton;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[3]/div/address/div[2]/div/ul/li[1]/a")
	WebElement User3_EditLink;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[4]/div/address/strong[1]")
	WebElement User4_Link;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[]/div/address/div[2]/div/button")
	WebElement User4_ActionButton;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[1]/div/address/div[2]/div/ul/li[1]/a")
	WebElement User4_EditLink;
	

	
	
	
	public Admin_AccountEndUsersPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	public boolean User1_LinkContains(String Name){
		
		return User1_Link.getText().contains(Name);

	}
	
	public boolean User2_LinkContains(String Name){
		
		return User2_Link.getText().contains(Name);
	
	}
	
	public boolean User3_LinkContains(String Name){
		
		return User3_Link.getText().contains(Name);

	}
	
	public boolean User4_LinkContains(String Name){
		
		return User4_Link.getText().contains(Name);

	}
	
	public void User1_EditButton(){
		
		 Actions  actions=new Actions(driver);
		 WebElement User1_ActionButton =driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[1]/div/address/div[2]/div/button"));
		 actions.click(User1_ActionButton);
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 WebElement User1_EditLink =driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[1]/div/address/div[2]/div/ul/li[1]/a"));
		 actions.moveToElement(User1_EditLink);
		 actions.click();
		 actions.perform();		

	}
	
	public void User2_EditButton(){
		
		 Actions  actions=new Actions(driver);
		 WebElement User2_ActionButton =driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[2]/div/address/div[2]/div/button"));
		 actions.click(User2_ActionButton);
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 WebElement User2_EditLink =driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[2]/div/address/div[2]/div/ul/li[1]/a"));
		 actions.moveToElement(User2_EditLink);
		 actions.click();
		 actions.perform();		

	}
	
	public void User3_EditButton(){
		
		 Actions  actions=new Actions(driver);
		 WebElement User3_ActionButton =driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[3]/div/address/div[2]/div/button"));
		 actions.click(User3_ActionButton);
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 WebElement User3_EditLink =driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[3]/div/address/div[2]/div/ul/li[1]/a"));
		 actions.moveToElement(User3_EditLink);
		 actions.click();
		 actions.perform();		

	}
	
	public void User4_EditButton(){
		
		 Actions  actions=new Actions(driver);
		 WebElement User4_ActionButton =driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[]/div/address/div[2]/div/button"));
		 actions.click(User4_ActionButton);
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 WebElement User4_EditLink =driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[1]/div/address/div[2]/div/ul/li[1]/a"));
		 actions.moveToElement(User4_EditLink);
		 actions.click();
		 actions.perform();		

	}
	
}
