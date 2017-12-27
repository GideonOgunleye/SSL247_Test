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


public class Client_AddToBasketPage extends DriverLoad {
	ExtentReports report;
	ExtentTest test;
	
	
	/********Proposal Page*******/
	@FindBy(xpath = ".//*[@id='BasketCommonName']")
	WebElement CommonNameField;
	
	@FindBy(xpath = ".//*[@id='check-cn-btn']")
	WebElement CheckButton;
	
	@FindBy(xpath = ".//*[@id='BasketAddCertificateForm']/div[12]/input[2]")
	WebElement YesButton;
	
	@FindBy(xpath = ".//*[@id='BasketAddCertificateForm']/div[12]/input[1]")
	WebElement NoButton;
	
	@FindBy(id = "BasketYears3")
	WebElement ThreeYears_RadioButton;
	
	
	@FindBy(xpath = ".//*[@id='addCertificateToBasket']")
	WebElement AddToBasketButton;
	
	public Client_AddToBasketPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		//PageFactory.initElements(driver, this);
		
	}
	

	public void CommonNameField_SendKeys(String Cname){
		
		CommonNameField.sendKeys(Cname);
	}
	
	
	public void CheckButton_Clink(){
		
		CheckButton.click();
	}
	
	public void YesButton_Clink(){
		
		YesButton.click();
	}
	
	public void NoButton_Clink(){
		
		NoButton.click();
	}
	
	public void ThreeYears_RadioButton_Clink(){
		
		ThreeYears_RadioButton.click();
	}
	
	public void AddToBasketButton_Clink(){
		
		AddToBasketButton.click();
	}


}
