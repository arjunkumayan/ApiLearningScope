package com.qa.httpclientAPITests;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

public class UpdateUserPUTAPITest {
	
	// Create a new user 
	// get the id from the response body
	// use update api and append the id with the url
	// update the pojo
	// hit the put call
	// get the response
	
	@Test
	public void updateUsetTest() {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		// 1. create a POST Request with URL

		HttpPost postRequest = new HttpPost("https://gorest.co.in/public-api/users");

		// 3 . add the json payload
		Users user = new Users("monia2", "bisht1", "female", "1973-01-19", "moniabeq@gmail.com", "1-344-876-9876 09237",
				"https://www.xyz1.com", "premgeet1243", "active");

		String entity = TestUtil.getSerializedJson(user);
		System.out.println(entity);
		StringEntity userEntity = null;
		try {
			userEntity = new StringEntity(entity);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// 2. add headers
		postRequest.addHeader("Authorization", "Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif");
		postRequest.setHeader("Content-Type", "application/json");
		postRequest.addHeader("accept", "application/json");

		postRequest.setEntity(userEntity); // add the final payload to body as a string

		// 4. hit the POST API with execute method
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(postRequest);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 5. get the status code
		int statusCode = response.getStatusLine().getStatusCode();
		//Assert.assertEquals(statusCode, 200);

		// 6. print the response json
		HttpEntity httpEntity = response.getEntity();
		String responseBody = null;
		try {
			responseBody = EntityUtils.toString(httpEntity);
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}

		// 7. no json parser for HTTP client
		// com.jayway

		Object document = Configuration.defaultConfiguration().jsonProvider().parse(responseBody);
		List<String> idList = JsonPath.read(document, "$..id");

		System.out.println("User id list is: " + idList.get(0));
		String id = idList.get(0);

		// PUT Request
		String putURL = "https://gorest.co.in/public-api/users/" + id;

		HttpPut putRequest = new HttpPut(putURL);
		putRequest.addHeader("Authorization", "Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif");
		putRequest.setHeader("Content-Type", "application/json");
		putRequest.addHeader("accept", "application/json");

		user.setStatus("inactive");

		// get json from pojo:

		String entityPut = TestUtil.getSerializedJson(user);
		System.out.println(entityPut);
		StringEntity userEntityPut = null;
		try {
			userEntityPut = new StringEntity(entityPut);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// add the json payload

		putRequest.setEntity(userEntityPut);

		// execute the put call:
		CloseableHttpResponse responsePut = null;
		try {
			responsePut = httpClient.execute(putRequest);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// get the status from response

		int putResponseCode = responsePut.getStatusLine().getStatusCode();
		System.out.println("put response code: " + putResponseCode);

		// get the response body

		HttpEntity httpEntityPut = responsePut.getEntity();
		String responseBodyPut = null;
		try {
			responseBodyPut = EntityUtils.toString(httpEntityPut);
			System.out.println(responseBodyPut);
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
		System.out.println("PUT Response body");
		System.out.println("============");
		
		Object documentPut = Configuration.defaultConfiguration().jsonProvider().parse(responseBody);
		List<String> idListPut = JsonPath.read(documentPut, "$..id");

		System.out.println("User id after put: " + idListPut.get(0));
		String idPut = idListPut.get(0);
	}
}
