package com.api.tests;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PUTAPICall {
	
	// update the resource or data
	
	@Test
	public void updateUserWithApiTest() {
		RestAssured.baseURI = "https://gorest.co.in";
		
		RequestSpecification  request = RestAssured.given().log().all();
		request.header("Authorization", "Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif");
		
		request.contentType("application/json");
				
		File file = new File("D:\\Users\\asingh6766\\eclipse-workspace\\ApiAutoationLearning\\src\\test\\java\\com\\api\\tests\\updateUser.json");
		
		request.body(file);
		
		Response response = request.put("/public-api/users/1619");
		
		System.out.println(response.prettyPrint());
	}
	

	
	public void putTest() {
		
		RestAssured.baseURI=" ";
		
		RequestSpecification request = RestAssured.given().log().all();
		request.header("","");
		request.contentType("application/json");
		request.body("");
		request.auth().basic("", "");
		request.auth().oauth("consumerKey", "consumerSecret", "accessToken", "secretToken");
		request.auth().oauth2("accessToken");
		//request.auth().oauth("consumerKey", "consumerSecret", "accessToken", "secretToken", "signature");
		
		request.body("{\"username\":\"password\"}");
		
		Response response = request.put("public-api/users/455");
		System.out.println(response.getContentType());
		System.out.println(response.getStatusCode());
		
		System.out.println(response.prettyPrint());
		
		System.out.println(response);
		
		JsonPath js = response.jsonPath();
		js.get("");
		
		
	}

}
