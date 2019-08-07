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

public class Get_By_OwnerAdress_SpecialCharacters extends TestBase {

	int count = 0;

	CBR_COUNT_GetCount CBR_COUNT_GetCount;
	ResultSet queryresult;

	public Get_By_OwnerAdress_SpecialCharacters() {

		super();
	}

	@BeforeMethod

	public void setup() {
		CBR_COUNT_GetCount = new CBR_COUNT_GetCount();

	}

	@Test
	public void get_CBRCount1() throws Exception {
		test = report.startTest("Get_By_OwnerAdress_SpecialCharacters");

		Response result = CBR_COUNT_GetCount.CBR_Count_Get("OwnerAdress_SpecialCharacters");
		JsonPath json = Raw_to_Json_XMl.rawToJson(result);
		System.out.println(result.getBody().asString());
		int status_code = result.getStatusCode();

		String error_message = json.getString("errormessage").trim();

		System.out.println(error_message);

	}

}
