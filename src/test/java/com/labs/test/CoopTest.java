package com.labs.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CoopTest {
	String tokenID;
	
	
	@BeforeMethod
	public void setUp() {
		RequestSpecification request = RestAssured.given().formParam("client_id", "AprilAPI")
				.formParam("client_secret", "c37dd8ce50d2a987941d756964d78d29")
				.formParam("grant_type", "client_credentials");

		Response response = request.post("http://coop.apps.symfonycasts.com/token");

		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());

		JsonPath js = response.jsonPath();

		tokenID = js.get("access_token");

	}
	
	
	@Test(priority = 1)
	public void feedChickensTest() {
		RequestSpecification request1 = RestAssured.given().auth().oauth2(tokenID);

		Response response1 = request1.post("http://coop.apps.symfonycasts.com/api/879/chickens-feed");

		System.out.println(response1.getStatusCode());
		System.out.println(response1.prettyPrint());

	}
		
	@Test(priority = 2)
	public void eggsCollect() {
		RequestSpecification request1 = RestAssured.given().auth().oauth2(tokenID);

		Response response1 = request1.post("http://coop.apps.symfonycasts.com/api/879/eggs-collect");

		System.out.println(response1.getStatusCode());
		System.out.println(response1.prettyPrint());

	}
	
	
	

}
