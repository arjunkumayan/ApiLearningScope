package com.api.tests;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostCallWithFile {
	
	@Test
	public void getTokenWithJsonFileTest() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RequestSpecification request = RestAssured.given().log().all();
		
		request.contentType("application/json");
		
		File file = new File("D:\\Users\\asingh6766\\eclipse-workspace\\ApiAutoationLearning\\src\\test\\java\\com\\api\\tests\\Credentials.json");
		
		request.body(file);
		
		Response response = request.post("/auth");
		
		System.out.println(response.prettyPrint());
		
		
	}

	
	@Test
	public void getTokenWithInvalidJsonFileTest() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RequestSpecification request = RestAssured.given().log().all();
		
		request.contentType("application/json");
		
		File file = new File("D:\\Users\\asingh6766\\eclipse-workspace\\ApiAutoationLearning\\src\\test\\java\\com\\api\\tests\\InvalidCredentials.json");
		
		request.body(file);
		
		Response response = request.post("/auth");
		
		System.out.println(response.prettyPrint());
		
		Assert.assertEquals(response.getStatusCode(), HTTPStatus.HTTP_STATUS_CODE_400);
		
		
	}
}
