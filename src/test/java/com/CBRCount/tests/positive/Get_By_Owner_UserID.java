package com.CBRCount.tests.positive;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CBRCount.RestAssured.CBR_COUNT_GetCount;
import com.CBRCount.TestBase.TestBase;
import com.CBRCount.Utilities.JDBC_Connection;
import com.CBRCount.Utilities.Raw_to_Json_XMl;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Get_By_Owner_UserID extends TestBase {

	int count = 0;

	CBR_COUNT_GetCount CBR_COUNT_GetCount;

	public Get_By_Owner_UserID() {

		super();
	}

	@Test
	public void get_CBRCount() throws Exception {
		test = report.startTest("Get_By_Owner_UserID");

		final StringBuffer responseString = new StringBuffer();
		final Response result = CBR_COUNT_GetCount.CBR_Count_Get("OwnerUserId");

		// System.out.println(result.getBody().asString());
		// System.out.println("testing1" + " " + result.getStatusCode());

		System.out.println("testing2" + " " + result.getHeaders());

		final Headers headers = result.getHeaders();
		final Map<String, String> headersMap = new HashMap<>();
		for (final Header header : headers) {
			headersMap.put(header.getName(), header.getValue());
		}

		System.out.println("All Headers:: " + headersMap);

		// final BufferedReader rd = new BufferedReader(new
		// InputStreamReader(null, result.getBody().asString()));
		// String line = "";
		// while ((line = rd.readLine()) != null) {
		// responseString.append(line);
		// }

		final JsonPath json = Raw_to_Json_XMl.rawToJson(result);

		final int Cbr_Count_Json = json.getInt("validCBRCount");
		final ResultSet queryresult = JDBC_Connection.getDBConnection("OwnerUserId");

		while (queryresult.next()) {

			count = queryresult.getInt("count");
		}

		Assert.assertEquals(count, Cbr_Count_Json);

		if (Cbr_Count_Json == count) {

			test.log(LogStatus.PASS, "CBR count matched in DB & REST Call for OwnerUserID");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
		System.out.println("");
	}

	@BeforeMethod

	public void setup() {
		CBR_COUNT_GetCount = new CBR_COUNT_GetCount();

	}

}
