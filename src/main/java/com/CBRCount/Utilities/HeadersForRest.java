package com.CBRCount.Utilities;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

//import io.restassured.RestAssured;
//import io.restassured.specification.RequestSpecification;

public class HeadersForRest {

	public static RequestSpecification SetHEADER() throws IOException {

		final RequestSpecification requestSpec = RestAssured.given();

		requestSpec.header("x-ottg-Caller-application", "Ankit").header("x-ottg-agent", "rest")
				.header("x-ottg-operator", "restassured").header("Content-Type", "application/xml")
				.header("Accept", "application/xml").header("agent", "ankit").header("operator", "restassured")
				.header("Authorization", "Basic Y3VzdHVzZXI6Y3VzdHVzZXI=").auth().basic("custuser", "custuser");
		return requestSpec;

	}

	public static RequestSpecification SetHEADER_JSON() throws IOException {

		final RequestSpecification requestSpec = RestAssured.given();

		requestSpec.header("x-ottg-Caller-application", "Ankit").header("x-ottg-agent", "rest")
				.header("x-ottg-operator", "restassured").header("Content-Type", "application/json")
				.header("Accept", "application/json").header("agent", "ankit").header("operator", "restassured")
				.header("Authorization", "Basic Y3VzdHVzZXI6Y3VzdHVzZXI=").auth().basic("custuser", "custuser");
		return requestSpec;

	}

}
