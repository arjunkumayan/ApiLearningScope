package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GetApiNoBDD {

	
	@Test(enabled=false)
	public void getUserAPITest() {
		
		RestAssured.baseURI="https://gorest.co.in/";
		RequestSpecification request = RestAssured.given().log().all();
		
		request.header("Authorization","Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif");
		
		Response response = request.get("public-api/users");	
		
		System.out.println(response.asString());
		
		System.out.println(response.prettyPrint());
		
		System.out.println(response.getStatusCode());
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
		
		System.out.println(response.getHeaders());
		
		String server= response.getHeader("Server");
		Assert.assertEquals(server, "nginx");
		
		
	}
	
	@Test
	public void getUserAPIByParamsTest() {
		
		RestAssured.baseURI="https://gorest.co.in/";
		RequestSpecification request = RestAssured.given().log().all();
		
		request.header("Authorization","Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif");
		request.queryParam("first_name", "Simola");
		request.queryParam("gender", "male");
		Response response = request.get("public-api/users");	
		
		System.out.println(response.asString());
		
		System.out.println(response.prettyPrint());
		
		System.out.println(response.getStatusCode());
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
		
		System.out.println(response.getHeaders());
		
		String server= response.getHeader("Server");
		Assert.assertEquals(server, "nginx");
		
		
	}
	
	public static void getUSERPI() {
		RestAssured.baseURI = " https://gorest.co.in/ ";
		RequestSpecification  request = RestAssured.given().log().all();
		request.header("Authorization", "Bearer ");
		
		
		Response response = request.get("public-api/users/");
		
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getContentType());
		System.out.println(response.getStatusLine());
		System.out.println(response.getBody());
		System.out.println(response.prettyPrint());
		System.out.println(response.getHeaders());
		
		String server = response.getHeader("server");
		Assert.assertEquals(server, "nginx");
		
		System.out.println(response.getBody());
		
		ResponseBody  body = response.getBody();
		
		
	}
}
