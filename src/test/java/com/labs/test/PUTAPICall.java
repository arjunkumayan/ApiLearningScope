package com.labs.test;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PUTAPICall {
	
	@Test
	public void updateUserWithPutTest() {
		
		RestAssured.baseURI = "https://gorest.co.in";
		
		RequestSpecification request = RestAssured.given().log().all();
		request.contentType("application/json");
		request.header("Authorization", "Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif");
		
		File file = new File("D:\\Users\\asingh6766\\eclipse-workspace\\ApiAutoationLearning\\src\\test\\resources\\UpdateUser.json");
		
		request.body(file);
		
		Response response = request.put("/public-api/users/12902");
		
		System.out.println(response.prettyPrint());
		
	 JsonPath js= response.jsonPath();
	 String statusCode = js.get("result.status");
	 System.out.println(statusCode);
		
	}
	
	

}
