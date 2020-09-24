package com.labs.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class GETApiNoBDD {
	
	
	@Test
	public void getUserAPI() {
		
		RestAssured.baseURI = "https://gorest.co.in";
		
		// Create a request
		RequestSpecification  request = RestAssured.given();
		 request.header("Authorization", "Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif");
		 
		Response response = request.get("/public-api/users");
		
		System.out.println(response);
		
		System.out.println(response.prettyPrint());
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeader("server"));
		System.out.println(response.getHeaders());
		
		Headers  header = response.getHeaders();
		System.out.println(" --  "+ header.get("server"));
		
		System.out.println(header.getValues("server"));
		
		System.out.println(header.getList("server"));
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void getUserAPIParamTest() {
		RestAssured.baseURI = "https://gorest.co.in";
		
		RequestSpecification request = RestAssured.given();
		request.header("Authorization","Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif");
		request.queryParam("first_name", "Lewis");
		request.queryParam("last_name","Mraz");
		
		Response response = request.get("/public-api/users");
		
		System.out.println(response.prettyPrint());
		System.out.println(response.getContentType());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusCode());
		
		
		ResponseBody body = response.getBody();
		
		System.out.println(body.prettyPrint());
	}

}
