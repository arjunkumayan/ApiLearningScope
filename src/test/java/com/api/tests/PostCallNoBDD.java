package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostCallNoBDD {
	
	
	
	@Test
	public void createNewUserAPITest() {
		
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		
		RequestSpecification  request = RestAssured.given().log().all();
		String payload = "{\"username\" : \"admin\",\"password\" : \"admin123\"}";
			
		request.body(payload);
		
		request.contentType("application/json");
		Response response = request.post("/auth");
		
		System.out.println(response.prettyPrint());
		System.out.println(response.getStatusCode());
		
		
		JsonPath js = response.jsonPath();
		String tokenId = js.get("token");
		
		Assert.assertNotNull(tokenId);
		
	}
	
	
	
	public void postCallTest() {
		
		RestAssured.baseURI = "";
		
		RequestSpecification request = RestAssured.given().log().all();
		String payload =" {\"username\":\"admin\",\"password\":\"temp123\"   }";
		
		request.body(payload);
		
		request.contentType("application/json");
		
		Response  response = request.post("/auth");
		System.out.println(response.prettyPrint());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getCookie("cookie"));
		System.out.println(response.getBody());
		
		JsonPath js = response.jsonPath();
		
		String tokenID= js.get("token");
		
		Assert.assertNotNull(tokenID);
		
		
		
	}

}
