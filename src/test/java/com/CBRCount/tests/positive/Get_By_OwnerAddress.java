package com.CBRCount.tests.positive;

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

public class Get_By_OwnerAddress extends TestBase {

	

	int count = 0;

	CBR_COUNT_GetCount CBR_COUNT_GetCount;
	ResultSet queryresult;

	public Get_By_OwnerAddress() {

		super();
	}

	@BeforeMethod

	public void setup() {
		CBR_COUNT_GetCount = new CBR_COUNT_GetCount();

	}

	@Test
	public void get_CBRCount1() throws Exception {
		test = report.startTest("Get_By_Owner_Address");

		Response result = CBR_COUNT_GetCount.CBR_Count_Get("OwnerAdddess");
		JsonPath json = Raw_to_Json_XMl.rawToJson(result);
		System.out.println(result.getBody().asString());
		int Cbr_Count_Json = json.getInt("validCBRCount");
		ResultSet queryresult = JDBC_Connection.getDBConnection("OwnerAdddess");

		while (queryresult.next()) {

			count = queryresult.getInt("count");
		}

		Assert.assertEquals(count, Cbr_Count_Json);


		if (result.getStatusCode() == 200) {

			test.log(LogStatus.PASS, " HTTP Response Code Validation Passed for" +"OwnerAddress");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
		System.out.println("");
	}

}
