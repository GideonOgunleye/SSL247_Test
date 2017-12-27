	public AdminCertificateDetailsPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		//PageFactory.initElements(driver, this);
		
	}

	public boolean PageIsVisible() {
		
		return PageHeader.isDisplayed();
		
	}
	
	public String PageHeader_GetText() {
		
		return PageHeader.getText();
		
	}	
	
	public void ClickMyProductsLink_Click(){
		
		MyProductsLink.click();
	}
	
	public void SearchAccountField_SendKeys(String Account) {
		
		SearchAccountField.clear();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		SearchAccountField.sendKeys(Account);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	}
	
	public boolean Result_Contains(String AccountCode){
		
		return Result.getText().contains(AccountCode);
		
	}
	
	public void ContactField_Select(String Name){
		
		 Select Level = new Select(ContactField);
		 Level.selectByVisibleText(Name);
	}
	
	public void LanguageField_Select(int 1){
		
		 Select Level = new Select(LanguageField);
		 Level.selectByIndex(1);
	}
	
	public void ClientDashboard_TextValidation() {
		
		String Status = "MySSL® » Dashboard";
		Assert.assertTrue(driver.getTitle().contains(Status));
		System.out.println("Page Title is:"  + Status);
		
	}
	
	public void EmailAddressField_Select(String Email){
		
		Select EmailAdd = new Select(EmailAddressField);
	  	EmailAdd.selectByVisibleText(Email);
	  	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
	}
	
	public void  CmsLink_Mouse(){
		
		Actions  actions=new Actions(driver);
		actions.moveToElement(CmsLink).build().perform();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	
	}
	
	public void FourthCert_DropDownClick(){
		
		Actions  Mouse=new Actions(driver);
	    WebElement Dropdown=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div/table/tbody/tr[4]/td[9]/div/button"));
	    Mouse.click(Dropdown);
	    driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	    WebElement EyeIcon=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div/table/tbody/tr[4]/td[9]/div/ul/li[4]/a"));
	    Mouse.moveToElement(EyeIcon);
	    Mouse.perform();
	    
	}
	
	public void LoadSsl247_TestCsR () throws Exception {
		
	/*	Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C://Users//Gideon Okunleye//workspace//AutomationTestScripts//DataDriving.properties");
	*/	
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(Constants.File_Path + Constants.DataFile_Name);
				 
		prop.load(fis);
		
		CsrFieldFill(prop.getProperty("Ssl-test1"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test2"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test3"));
		HitEnterKey();;
		CsrFieldFill(prop.getProperty("Ssl-test4"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test5"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test6"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test7"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test8"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test9"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test10"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test11"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test12"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test13"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test14"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test15"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test16"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test17"));
		HitEnterKey();
	
	}
	
	try {
		
	}catch (Exception e){
		
		test.log(LogStatus.FAIL, "Element Not Found");
		test.log(LogStatus.INFO, e);
		System.out.println("Element Not Found");
		String path2 = ScreenShot.Image(driver, "Element");
		String imagePath2 = test.addScreenCapture(path2);
		test.log(LogStatus.INFO, imagePath2);
		report.endTest(test);
		report.flush();
		System.out.println("Exception" + e);
		Assert.fail("Exception " + e);
		
	}
		
		
		
