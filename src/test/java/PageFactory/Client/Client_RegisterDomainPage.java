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


public class Client_RegisterDomainPage extends DriverLoad {
	ExtentReports report;
	ExtentTest test;
	
	@FindBy(xpath = ".//*[@id='check-domain-name']")
	WebElement SearchField;
	
	@FindBy(xpath = ".//*[@id='BasketCheckDomain']/div[2]/button")
	WebElement CheckAvailabilityButton;
	
	@FindBy(xpath = ".//*[@id='domain-name-results']/tbody/tr[2]/td[1]")
	WebElement SearchResult_column_1_DomainName;
	
	@FindBy(xpath = ".//*[@id='domain-name-results']/tbody/tr[2]/td[2]")
	WebElement SearchResult_column_1_Availibity;
	
	@FindBy(xpath = ".//*[@id='domain-name-results']/tbody/tr[2]/td[4]")
	WebElement SearchResult_column_1_CheckBox;
	
	@FindBy(xpath = ".//*[@id='domain-search-results']/div/button")
	WebElement AddToBasketButton;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[4]/div[3]/span")
	WebElement PageHeader;
	

	
	public Client_RegisterDomainPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	
	public String PageHeader_GetText() {
		
		return PageHeader.getText();
		
	}
	
	
	public void SearchField_SendKeys(String CommonName) {
		
		SearchField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		SearchField.sendKeys(CommonName);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}

	public void CheckAvailabilityButton_Click(){
		
		CheckAvailabilityButton.click();
	}
	
	public String SearchResult_column_1_DomainName_GetText() {
		
		return SearchResult_column_1_DomainName.getText();
		
	}
	
	public String SearchResult_column_1_Availibity_GetText() {
		
		return SearchResult_column_1_Availibity.getText();
		
	}
	
	public void SearchResult_column_1_CheckBox_Click(){
		
		SearchResult_column_1_CheckBox.click();
	}
	
	public void AddToBasketButton_Click(){
		
		AddToBasketButton.click();
	}
	
	

}
