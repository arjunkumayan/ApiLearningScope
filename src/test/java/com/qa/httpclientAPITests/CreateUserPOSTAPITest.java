package com.qa.httpclientAPITests;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateUserPOSTAPITest {

	
	@Test
	public void createUserAPITest() {
		
		
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		
		//1. create a POST Request with URL
		
		HttpPost postRequest = new HttpPost("https://gorest.co.in/public-api/users");
		
		//2. add headers
		postRequest.addHeader("Authorization","Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif");
		postRequest.setHeader("Content-Type","application/json");
		postRequest.addHeader("accept","application/json");
		
		
		//3 . add the json payload
		Users user = new Users("priyanka", "jhala", "female", "1973-01-19", "priyanka12@gmail.com", "1-344-388-9876 09237", "https://www.xyz1.com", "premgeet", "active");
		
     
		String  entity = TestUtil.getSerializedJson(user);
		System.out.println(entity);
		StringEntity userEntity = null;
		try {
			userEntity = new StringEntity(entity);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		postRequest.setEntity(userEntity); // add the final payload to body as a string
		
		//4. hit the API with execute method
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(postRequest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//5. get the status code
		int statusCode = response.getStatusLine().getStatusCode();
		//Assert.assertEquals(statusCode, 200);
		
		//6. print the response json
		HttpEntity httpEntity = response.getEntity();
		String responsebody = null;
		try {
			responsebody = EntityUtils.toString(httpEntity);
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void createUserTest() {
		
		CloseableHttpClient  httpClient = MyHttpclientUtil.createHttpClient();
		
		HttpPost postRequest = MyHttpclientUtil.createRequestWithURL("https://gorest.co.in/public-api/users");
		
		MyHttpclientUtil.addHeaders(postRequest);
		MyHttpclientUtil.addToken(postRequest, "g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif");
		Users user = new Users("priyanka1", "jha1la", "female", "1973-04-19", "priyankad12@gmail.com", "1-344-388-9876 09237", "https://www.xyz1.com", "premgeet", "active");

		MyHttpclientUtil.addJsonPayloadBody(postRequest, user);
		CloseableHttpResponse response = MyHttpclientUtil.executeAPI(httpClient, postRequest);
		int statusCode = MyHttpclientUtil.getResponseStatusCode(response);
		Assert.assertEquals(statusCode, 200);
		
		String responseBody = MyHttpclientUtil.getResponseBody(response);
		System.out.println(responseBody);
		
	}
}
