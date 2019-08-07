package com.CBRCount.tests.negative;

import java.io.IOException;
import java.sql.ResultSet;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CBRCount.RestAssured.CBR_COUNT_GetCount;
import com.CBRCount.TestBase.*;
import com.CBRCount.Utilities.JDBC_Connection;
import com.CBRCount.Utilities.Raw_to_Json_XMl;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Get_By_Direction_InvalidName extends TestBase {
	int count = 0;
	JsonPath json;

	CBR_COUNT_GetCount CBR_COUNT_GetCount;
	ResultSet queryresult;

	public Get_By_Direction_InvalidName() {

		super();
	}

	@BeforeMethod

	public void setup() {
		CBR_COUNT_GetCount = new CBR_COUNT_GetCount();
		test = report.startTest("Get_By_Direction_InvalidName");

	}
	

	@Test
	public void get_CBRCount() throws Exception {
		

		Response result = CBR_COUNT_GetCount.CBR_Count_Get("Invalid Direction");
		System.out.println(result.getBody().asString());
		int status_code = result.getStatusCode();
		JsonPath json = Raw_to_Json_XMl.rawToJson(result);

		String error_message = json.getString("errormessage").trim();

		System.out.println(error_message);

		// Assert.assertEquals("Direction should be either 'SEND' , 'RECEIVE' or
		// 'BOTH'",actual);

		Assert.assertEquals(400, status_code);
		if (error_message.equals("Direction should be either 'SEND' , 'RECEIVE' or 'BOTH'")) {

			test.log(LogStatus.PASS, " HTTP Response Message Validation Passed for" + " " + "Invalid Direction");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
		System.out.println("");
	}
}
