package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DELETECallAPITest {
	
	@Test
	public void deleteUserAPITest() {
		
         RestAssured.baseURI = "https://gorest.co.in";
		
		RequestSpecification  request = RestAssured.given().log().all();
		request.header("Authorization", "Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif");
		
		request.contentType("application/json");
		
		Response response = request.delete("/public-api/users/1623");
		System.out.println(response.prettyPrint());
		
		Assert.assertEquals(response.getStatusCode(), HTTPStatus.HTTP_STATUS_CODE_200);
		
		JsonPath  js = response.jsonPath();
		//System.out.println(js.get("result").toString());
		
		Assert.assertNull(js.get("result"));
		
	}
	
	@Test
	public void deleteUserWithBDDTest() {
		 RestAssured.baseURI = "https://gorest.co.in";
		
		RestAssured.given().log().all()
		.header("Authorization", "Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif")
		.contentType("application/json")
		.when()
		.delete("/public-api/users/1625")
		.then()
		.statusCode(200);
		
		
	}

}
