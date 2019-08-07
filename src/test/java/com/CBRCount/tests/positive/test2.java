package com.CBRCount.tests.positive;

import com.JavatoJsonObject.Ankit;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class test2 {

	public static void main(final String[] args) {
		final String data = "{\"cbrvo\":[{\"additionalMetaData\":\"*ANY\",\"doctype\":\"850\",\"eventType\":\"RE\",\"processingOrder\":\"1\",\"receiveraddress\":\"QA:205\",\"senderaddress\":\"QA:565\",\"serviceEndPoint\":\"QABRTEST\",\"timeOut\":\"0\",\"triggeringNode\":\"S\",\"cbrparamOption\":[{\"paramKey\":\"itineraryName\",\"paramVal\":\"QA-1 SC109\"},{\"paramKey\":\"itineraryVersion\",\"paramVal\":\"CURRENT\"}]}]}";
		final Gson gson = new Gson();
		final Ankit ankit = gson.fromJson(data, Ankit.class);

		final JsonParser jparser = new JsonParser();

		final JsonObject jobj = jparser.parse(data).getAsJsonObject();

		System.out.println("!!!!!" + jobj.get("cbrvo").getAsJsonArray().get(0).getAsJsonObject().get("doctype"));

		System.out.println("@@@@" + jobj.getAsJsonArray("cbrvo").get(0).getAsJsonObject().get("doctype"));

		// jobj.getAsJsonArray("cbrvo").get(0).getAsJsonArray();

		System.out.println("check" + jobj.getAsJsonArray("cbrvo").get(0).getAsJsonObject().get("cbrparamOption")
				.getAsJsonArray().getAsJsonArray().remove(0));

		// JsonObject json1 = new JsonObject();
		//
		// System.out.println(ankit.getCbrvo());
		//
		// ankit.getCbrvo().get(0).setDoctype("950");
		// ankit.getCbrvo().get(0).setEventType("BP");
		// final String newjson = gson.toJson(ankit);
		// System.out.println("NEW" + ankit.getCbrvo());
		//
		// System.out.println("wihtout using classes");

	}

}
