package com.viva.dao.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.viva.dao.Response;

public class ResponseBuilder {

	public static Response getResponse(int responseCode, String responseType, Object responseObject) {
		Response response = new Response();
		if (responseCode == 0) {
			response.setResponseCode(0);
			response.setResponseMessage(responseType +" : Please check given details");
			response.setResponseObject(responseObject);
		} else if (responseCode == -1) {
			response.setResponseCode(-1);
			response.setResponseMessage(responseType + " Internal server error");
			response.setResponseObject(responseObject);
		} else {
			response.setResponseCode(1);
			response.setResponseMessage(responseType+" success");
			response.setResponseObject(responseObject);
		}
		Logger.getLogger(ResponseBuilder.class.getName()).log(Level.INFO,response.toString());
		System.out.println(responseType +" Response : " + response);
		return response;
	}
}
