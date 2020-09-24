package com.qa.httpclientAPITests;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUserAPITest {
	
	
	@Test
	public void goRestGetUserAPITest() {
		
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		//1. give URL
		HttpGet getRequest = new HttpGet("https://gorest.co.in/public-api/users");
		
		//2. Add headers: 
		getRequest.addHeader("Authorization","Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif");
	
		//3. execute the API
		CloseableHttpResponse  response = null;
		try {
			response = httpClient.execute(getRequest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//4. get the status code
		
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);
	
		//5. get the response body
		
		HttpEntity httpEntity = response.getEntity();
		String responseBody = null;
		try {
			responseBody = EntityUtils.toString(httpEntity);
		} catch (ParseException | IOException e) {
				}
		
		System.out.println(responseBody);
	}

}
