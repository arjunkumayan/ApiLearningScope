package com.labs.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.tests.HTTPStatus;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
public class DeleteApiCall {
	
	
	@Test
	public void userDeleteApiTest() {
		
		RestAssured.baseURI = "https://gorest.co.in";
		
		RequestSpecification request = RestAssured.given().log().all();
		request.contentType("application/json");
		request.header("Authorization", "Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif");
		
		Response response = request.delete("/public-api/users/12900");
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, HTTPStatus.HTTP_STATUS_CODE_200);
		
		JsonPath js = response.jsonPath();
		Assert.assertNull(js.get("result"));
	}

}
