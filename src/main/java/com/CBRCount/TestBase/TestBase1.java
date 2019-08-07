package com.CBRCount.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.HTMLReporter;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase1 {
	public Properties prop;
	public static ExtentTest test;
	public static ExtentReports report;

	// public ExtentTest test;
	// public ExtentReports report;

	public TestBase1() {

		try {
			prop = new Properties();
			FileInputStream fns = new FileInputStream(
					"C:\\Users\\akapoor\\workspace\\CBR_COUNT\\src\\main\\java\\com\\CBRCount\\Utilities\\Environment.properties");
			prop.load(fns);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeSuite
	public void setUp() {
		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html", true);
		// test = report.startTest("Get_By_Owner_Address");

	}

	@AfterMethod
	public void getResult(ITestResult result)

	{

		if (result.getStatus() == ITestResult.FAILURE) {
			// test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"
			// Test case FAILED due to below issues:", ExtentColor.RED));
			// test.fail(result.getThrowable());
			test.log(LogStatus.FAIL, "Test Failed");

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, result.getName() + "Test Case Passed");

		}

	}

	@AfterSuite
	public static void endTest() {
		report.endTest(test);
		report.flush();
	}

}
