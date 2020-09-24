package com.labs.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
public class GetUserAPISchemaTest {
	
	@Test
	public void getUserSchemaTest() {
		RestAssured.baseURI = "https://gorest.co.in";
		
		RestAssured.given().log().all()
		.contentType("application/json")
		.header("Authorization", "Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif")
		.queryParam("last_name", "Mraz")
		.queryParam("first_name", "Lewis")
		
		.when().log().all()
		.get("/public-api/users")
		.then().log().all()
		.assertThat().body(matchesJsonSchemaInClasspath("UserResponse.json"));		
		
	}

}
