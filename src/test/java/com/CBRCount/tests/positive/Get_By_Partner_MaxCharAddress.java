package com.CBRCount.tests.positive;

import java.sql.ResultSet;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CBRCount.RestAssured.CBR_COUNT_GetCount;
import com.CBRCount.TestBase.TestBase;
import com.CBRCount.Utilities.JDBC_Connection;
import com.CBRCount.Utilities.Raw_to_Json_XMl;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Get_By_Partner_MaxCharAddress  extends TestBase{
	
	int count = 0;

	CBR_COUNT_GetCount CBR_COUNT_GetCount;
	ResultSet queryresult;

	public Get_By_Partner_MaxCharAddress() {

		super();
	}

	@BeforeMethod

	public void setup() {
		CBR_COUNT_GetCount = new CBR_COUNT_GetCount();

	}

	@Test
	public void get_CBRCount() throws Exception {
		test = report.startTest("Get_By_Partner_MaxCharAddress");

		Response result = CBR_COUNT_GetCount.CBR_Count_Get("Partner_MaxCharAddress");
		JsonPath json = Raw_to_Json_XMl.rawToJson(result);
		System.out.println(result.getBody().asString());
		int Cbr_Count_Json = json.getInt("validCBRCount");
		System.out.println(" total count"+" "+Cbr_Count_Json);
		ResultSet queryresult = JDBC_Connection.getDBConnection("Partner_MaxCharAddress");

		while (queryresult.next()) {

			count = queryresult.getInt("count");
		}

		Assert.assertEquals(count, Cbr_Count_Json);


		if (result.getStatusCode() == 200) {

			test.log(LogStatus.PASS, " HTTP Response Code Validation Passed for"+" "+"Partner_MaxCharAddress");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
		System.out.println("");
	}


}
