package com.CBRCount.RestAssured;

//import utilities.request;
import java.io.IOException;

import com.CBRCount.ResourceList.GetRequest;
import com.CBRCount.TestBase.TestBase;
import com.CBRCount.Utilities.HeadersForRest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;;

public class CBR_COUNT_GetCount extends TestBase {

	public Response CBR_Count_Get(final String resourceName) throws IOException {

		final String leg = prop.getProperty("LEG");

		final String s = prop.getProperty(leg + "_" + "HOST");
		RestAssured.unregisterParser(s);

		RestAssured.baseURI = s;

		final RequestSpecification rec1 = HeadersForRest.SetHEADER_JSON();

		final Response res1 = rec1.request(Method.GET, GetRequest.getResource(resourceName));
		// Assert.assertEquals(200, res1.getStatusCode());
		//
		// System.out.println(res1.body().asString());
		// System.out.println(res1.getStatusCode());

		return res1;

	}
}