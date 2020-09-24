package com.api.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetUserSchemaTest {
	
	//Json schema validator
	
	@Test
	public void getUserSchemaTest() {
	
		
		RestAssured.given().log().all()
		.contentType("application/json")
		.header("Authorization", "Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif")
		
		.when().log().all()
		.get("https://gorest.co.in/public-api/users/1617")
		
		.then().log().all()
		.assertThat()
		.body(matchesJsonSchemaInClasspath("UserSchema.json"));
			
		
	}
	
	
	
	

}
