package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasicAuthHandle {
	
	// token authentication
	// basic auth - username and password
	// auth 1.0 and auth 2.0
	
	@Test
	public void basicAuthRestAssuredTest() {
		
		RestAssured.baseURI = "http://the-internet.herokuapp.com";
		RequestSpecification  requestSpecification = RestAssured.given().log().all();
		requestSpecification.auth().basic("admin", "admin");
		Response resp = requestSpecification.get("/basic_auth");
		
		System.out.println(resp.prettyPrint());
		
	}
	
	
	public void basicAuthRestTest() {
		
		RestAssured.baseURI="";
		RequestSpecification request = RestAssured.given().log().all();
		request.auth().basic("admin", "admin");
		Response response = request.get("/basic-auth");
	
		System.out.println(response.prettyPrint());
		System.out.println(response.contentType());
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeader("server"));
		
	   Assert.assertEquals(response.getStatusCode(),200);
	   
	   Assert.assertEquals(response.contentType(), "application/json");
	   Assert.assertEquals(response.getHeader("server"), "nginx");
	   
	   Assert.assertEquals(response.getCookie("coo"), "coo1123");
	   
		
	}

}
