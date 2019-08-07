package com.CBRCount.tests.positive;

import java.io.IOException;
import java.sql.ResultSet;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CBRCount.TestBase.TestBase;
import com.CBRCount.Utilities.HeadersForRest;
import com.CBRCount.Utilities.JDBC_Connection;
import com.CBRCount.Utilities.Raw_to_Json_XMl;
import com.opentext.tgms.cbr.ContentBasedRouting;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class ContentBasedRoutingTests extends TestBase {

	@BeforeMethod
	public void setup() throws IOException {
		final String leg = prop.getProperty("LEG");
		final String s = prop.getProperty(leg + "_" + "HOST");
		RestAssured.unregisterParser(s);
		RestAssured.baseURI = s;

	}

	@Test
	public void testThatContentBasedRoutingIsGettableByOwnerId() throws Exception {

		final ContentBasedRouting cbrRouting = new ContentBasedRouting();

		final Response response;
		int count = 0;

		test = report.startTest("Get_By_Owner_UserID");

		final RequestSpecification requestSpec = HeadersForRest.SetHEADER_JSON();

		final Response result = cbrRouting.searchAndReturnWithQueryParameters(requestSpec, "?ownerUserID=AAC96783");

		final JsonPath json = Raw_to_Json_XMl.rawToJson(result);

		System.out.println("Response :" + result.getBody().asString());

		final int Cbr_Count_Json = json.getInt("validCBRCount");
		final ResultSet queryresult = JDBC_Connection.getDBConnection("OwnerUserId");

		while (queryresult.next()) {

			count = queryresult.getInt("count");
		}

		Assert.assertEquals(count, Cbr_Count_Json);

		if (result.getStatusCode() == 200) {

			test.log(LogStatus.PASS, " HTTP Response Code Validation Passed for" + "" + "OwnerAddress");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
		System.out.println("");

	}
}
