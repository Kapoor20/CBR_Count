package com.CBRCount.TestBase;

//import static com.TGMS.TestBase.TestBase.report;
//import static com.TGMS.TestBase.TestBase.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {

	public static ExtentTest test;
	public static ExtentReports report;

	@AfterSuite
	public static void endTest() {
		report.endTest(test);
		report.flush();
	}

	// public ExtentTest test;
	// public ExtentReports report;

	public Properties prop;

	public TestBase() {

		try {
			prop = new Properties();
			final FileInputStream fns = new FileInputStream(
					"C:\\Users\\akapoor\\workspace\\CBR_COUNT\\src\\main\\java\\com\\CBRCount\\TestData\\Environment.properties");
			prop.load(fns);
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public synchronized void getResult(final ITestResult result)

	{

		if (result.getStatus() == ITestResult.FAILURE) {
			// test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"
			// Test case FAILED due to below issues:", ExtentColor.RED));
			// test.fail(result.getThrowable());
			test.log(LogStatus.FAIL, result.getName() + "Test Failed");

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, result.getName() + "Test Case Passed");

		}

	}

	@BeforeSuite
	public void setUp() {
		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html", true);
		// test = report.startTest("Get_By_Owner_Address");

	}

}
