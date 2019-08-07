package com.CBRCount.Utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class Raw_to_Json_XMl {
	
public static JsonPath rawToJson( Response R){
		
		String S= R.asString();
		JsonPath j= new JsonPath(S);
		return j;
	}

	
public static XmlPath rawToXMl( Response R){
		
		String S= R.asString();
		XmlPath j= new XmlPath(S);
		return j;
	}


}
