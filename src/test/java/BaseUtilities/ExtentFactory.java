package BaseUtilities;
import java.io.File;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.DisplayOrder;
import org.testng.ITestContext;

public class ExtentFactory {
	
//	 private static ExtentReports extent;
//	 private static ITestContext iTestContext;
	

	public synchronized static ExtentReports getInstance() {
		ExtentReports extent;
		//ITestContext iTestContext;

//		String Path = "C:\\ExtentReport\\Sanity Test.html";
		String Path = "./test-output/Extent Report/Sanity Test.html";
//		File outPutDirectory = new File(Path.getOutputDirectory());
//		File resultDirectory = new File(outPutDirectory.getParentFile(), "ExtentReport");
		
//		extent = new ExtentReports(resultDirectory + File.separator + "ExtentReport.html", true, DisplayOrder.NEWEST_FIRST);

		extent = new ExtentReports (Path, true);
		
		
		return extent;

	}
	
//    public static void setOutPutDirectory(ITestContext iTestContext) {
//    	ExtentFactory.iTestContext = iTestContext;
//}
	
	public static ExtentReports getInstance2() {
		ExtentReports extent;

		String Path = "C:\\ExtentReport\\Regression Test.html";

		extent = new ExtentReports (Path, false);
		
		
		return extent;

	}
	
	public static ExtentReports getInstance3() {
		ExtentReports extent;

		String Path = "C:\\ExtentReport\\Smoke Test.html";

		extent = new ExtentReports (Path, false);
		
		
		return extent;

	}
	
	public static ExtentReports getInstance4() {
		ExtentReports extent;

		String Path = "C:\\ExtentReport\\IndexPageCrokenLinks Test.html";

		extent = new ExtentReports (Path, false);
		
		
		return extent;

	}
	
	public static ExtentReports getInstance5() {
		ExtentReports extent;

		String Path = "C:\\ExtentReport\\MainNavBrokenLinks Test.html";

		extent = new ExtentReports (Path, false);
		
		
		return extent;

	}
	
	public static ExtentReports getInstance6() {
		ExtentReports extent;

		String Path = "C:\\ExtentReport\\SubNavBrokenLinks Test.html";

		extent = new ExtentReports (Path, false);
		
		
		return extent;

	}


}
