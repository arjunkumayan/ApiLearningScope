package com.qa.httpclientAPITests;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class DeleteUserAPITest {
	
	@Test
	public void deleteUserAPITest() {
		
		
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		
		//1. create a delete request with http request:
		HttpDelete deleteRequest = new HttpDelete("https://gorest.co.in/public-api/user");
		
		//2. add token header 
		deleteRequest.addHeader("Authorization","Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif");
		
		//3. execute the API
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(deleteRequest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//4. get the status
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		
		//5. get the responseBody
		// EntityUtils.toString(response.getEntity());
		
		HttpEntity httpEntity = response.getEntity();
	   String responsebody = null;
		try {
			responsebody = EntityUtils.toString(httpEntity);
			System.out.println(responsebody);
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	

}
