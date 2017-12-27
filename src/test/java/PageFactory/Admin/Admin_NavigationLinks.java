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

public class Admin_NavigationLinks extends DriverLoad {
	
	
	/*****Main Menu*******/
	@FindBy(xpath = ".//*[@id='mainNavigation']/li[2]/a")
	WebElement ClientsAccountsLink;
	
	@FindBy(xpath = ".//*[@id='mainNavigation']/li[3]/a")
	WebElement ProductsLink;
	
	/********Clients Accounts SubMenu Navigation**********/
	@FindBy(xpath = ".//*[@id='mainNavigation']/li[2]/ul/li[1]/a")
	WebElement NewAccountLink;
	
	/********Clients Accounts SubMenu Navigation**********/
	@FindBy(css = "a[href*='/admin/websites/index']")
	WebElement CmsLink;
	
	/********Clients Accounts SubMenu Navigation**********/
	@FindBy(css = "a[href*='/admin/outgoing_emails/index']")
	WebElement OutgoingEmailsLink;
	

	
	/********Products SubMenu Navigation**********/
	@FindBy(xpath = ".//*[@id='mainNavigation']/li[3]/ul/li[1]/a")
	WebElement CertificatesLink;
	
	
	/********Identify SubMenu Navigation**********/
	
	
	/********Register SubMenu Navigation**********/
	
	
	/********Manage SubMenu Navigation**********/
	
	
	/********Become a Partner SubMenu Navigation**********/
	
	
	/********My SSL SubMenu Navigation**********/
	
	
	/********Free Trials SubMenu Navigation**********/
	
	
	/********About SubMenu Navigation**********/
	
	
	/********Support SubMenu Navigation**********/
	
	
	
	
	
	public Admin_NavigationLinks(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 100), this);
		//PageFactory.initElements(driver, this);
		
	}

	
	public void ClientsAccountsLinkClick(){
		
		ClientsAccountsLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//assertTrue(driver.getTitle().contains("SSL247 Accounts"));

	
	}
	
	
	
	public void  ProductsLinkMouse(){
		
		Actions  actions=new Actions(driver);
		actions.moveToElement(ProductsLink).build().perform();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  	//actions.perform();
	  	//actions.moveToElement(ProductsLink);
		//assertTrue(driver.getTitle().contains("Products for United Kingdom"));
		
	
	}
	
	public void ProductsLinkClick(){
		
		Actions  actions=new Actions(driver);
		actions.moveToElement(ProductsLink);
	  	actions.click();
	  	actions.perform();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//assertTrue(driver.getTitle().contains("Products for United Kingdom"));
	}
	
	public void CertificatesLinkClick(){
		
		Actions  actions=new Actions(driver);
		actions.moveToElement(CertificatesLink).click().perform();
	  	//actions.click();
	  	//actions.perform();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//assertTrue(driver.getTitle().contains("Products for United Kingdom"));
	}
	
	public void  ClientsAccountsLinkMouse(){
		
		Actions  actions=new Actions(driver);
		actions.moveToElement(ClientsAccountsLink).build().perform();
	  	//actions.perform();
	  	//actions.moveToElement(ProductsLink);
		//assertTrue(driver.getTitle().contains("Products for United Kingdom"));
		
	
	}
	
	public void NewAccountLinkClick(){
		
		Actions  actions=new Actions(driver);
		actions.moveToElement(NewAccountLink);
	  	actions.click();
	  	actions.perform();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//assertTrue(driver.getTitle().contains("Products for United Kingdom"));
	}
	
	public void  CmsLink_Mouse(){
		
		Actions  actions=new Actions(driver);
		actions.moveToElement(CmsLink).build().perform();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	
	}
	
	public void OutgoingEmailsLink_Click(){
		
		Actions  actions=new Actions(driver);
		actions.moveToElement(OutgoingEmailsLink);
	  	actions.click();
	  	actions.perform();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//assertTrue(driver.getTitle().contains("Products for United Kingdom"));
	}
	
}
