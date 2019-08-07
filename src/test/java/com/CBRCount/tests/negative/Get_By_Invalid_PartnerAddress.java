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

public class Get_By_Invalid_PartnerAddress extends TestBase {
	int count = 0;
	JsonPath json;

	CBR_COUNT_GetCount CBR_COUNT_GetCount;
	ResultSet queryresult;

	public Get_By_Invalid_PartnerAddress() {

		super();
	}

	@BeforeMethod

	public void setup() {
		CBR_COUNT_GetCount = new CBR_COUNT_GetCount();

	}

	@Test
	public void get_CBRCount() throws Exception {
		test = report.startTest("Get_By_Invalid_PartnerAddress");

		Response result = CBR_COUNT_GetCount.CBR_Count_Get("Invalid PartnerAddress");
		System.out.println(result.getBody().asString());
		int status_code = result.getStatusCode();
		JsonPath json = Raw_to_Json_XMl.rawToJson(result);

		String error_message = json.getString("errormessage").trim();

		System.out.println(error_message);

		String subString[] = error_message.split(" ");
		String address_given = subString[2];

		Assert.assertEquals(400, status_code);

		if (error_message.equals("EDI Address"+" "+address_given+" "+"does not exist")) {
			test.log(LogStatus.PASS, " Response message validation Passed for" + " " + "Invalid PartnerAddress");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
		System.out.println("");
	}

}
