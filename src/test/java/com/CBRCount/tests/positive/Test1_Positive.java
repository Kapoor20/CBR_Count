package com.CBRCount.tests.positive;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.CBRCount.Utilities.HeadersForRest;
import com.JavatoJsonObject.Ankit;
import com.JavatoJsonObject.CBRparamOption;
import com.JavatoJsonObject.Cbrvo;
import com.google.gson.Gson;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test1_Positive {

	final Ankit ank = new Ankit();
	Cbrvo cbrvo = new Cbrvo();

	List<Cbrvo> cbrvo1 = new ArrayList<Cbrvo>();
	// CBRparamOption param = new CBRparamOption();
	List<CBRparamOption> listParm = new ArrayList<CBRparamOption>();

	RequestSpecification rec1;

	@Test

	public void setup() throws IOException {

		final FileInputStream fin = new FileInputStream("C:\\Users\\akapoor\\Desktop\\json.txt");

		// final String leg = prop.getProperty("LEG");

		final String s = "http://qaas1.qa.gxsonline.net:32484";
		RestAssured.unregisterParser(s);

		RestAssured.baseURI = s;

		//
		cbrvo.setDoctype("850");
		cbrvo.setEventType("RE");
		cbrvo.setProcessingOrder("1");
		cbrvo.setReceiveraddress("QA:205");
		cbrvo.setSenderaddress("QA:565");
		cbrvo.setServiceEndPoint("QABRTEST");
		cbrvo.setTimeOut("0");
		cbrvo.setTriggeringNode("S");
		cbrvo.setAdditionalMetaData("*ANY");

		cbrvo1.add(cbrvo);

		listParm.add(new CBRparamOption("ankit", "kapoor"));
		listParm.add(new CBRparamOption("bunty", "yo"));

		// param.setParamKey("");
		// param.setParamVal("");
		// listParm.add(param);

		cbrvo.setCbrparamOption(listParm);

		ank.setCbrvo(cbrvo1);

		final Gson json = new Gson();

		final String s1 = json.toJson(ank).toString();

		System.out.println("JSONbody" + s1);
		final RequestSpecification rec1 = HeadersForRest.SetHEADER_JSON().body(s1);
		// System.out.println("REC1" + rec1.get().body().asString());
		final Response res1 = rec1.request(Method.PUT,
				"/TGMSAdminRest/v1/projects/REGRESSION002/contentbasedroutings?newServiceEndPoint=QACBRTEST1");

		System.out.println(res1.getStatusCode());
		System.out.println(res1.getBody().asString());
	}

	// Response res1 =rec1.request(Method.POST,
	// "/TGMSAdminRest/v1/projects/REGRESSION002/contentbasedroutings?newServiceEndPoint=QACBRTEST1");
	//

}
