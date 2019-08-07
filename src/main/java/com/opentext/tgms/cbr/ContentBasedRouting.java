package com.opentext.tgms.cbr;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ContentBasedRouting {

	public ContentBasedRouting() {
	}

	public String getContentBasedRoutingBaseUri() {
		return "/TGMSAdminRest/v1/cbrcount";
	}

	// public String searchAndReturnWithQueryParameters(final
	// RequestSpecification requestSpec,
	// final String queryParameters) {
	// String responseString = "";
	// if (requestSpec != null) {
	// final String endPointUri = getContentBasedRoutingBaseUri() +
	// queryParameters;
	// final Response response = requestSpec.request(Method.GET, endPointUri);
	// if (response != null) {
	// responseString = response.getBody().asString();
	// }
	// }
	// return responseString;
	// }
	// }
	public Response searchAndReturnWithQueryParameters(final RequestSpecification requestSpec,
			final String queryParameters) {

		final String endPointUri = getContentBasedRoutingBaseUri() + queryParameters;
		final Response response = requestSpec.request(Method.GET, endPointUri);

		return response;
	}
}
